package io.wf.springframework.test;

import cn.hutool.core.io.IoUtil;
import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanReference;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import io.wf.springframework.context.support.ClassPathXmlApplicationContext;
import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.Resource;
import io.wf.springframework.core.io.ResourceLoader;
import io.wf.springframework.test.bean.UserDao;
import io.wf.springframework.test.bean.UserService;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.test.bean.UserServiceV2;
import io.wf.springframework.test.bean.aware.AwareUserService;
import io.wf.springframework.test.common.MyBeanFactoryPostProcessor;
import io.wf.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class ApiTest {

    @Test
    public void test_BeanFactory() {

        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 4.设置UserService属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 5.注册UserService定义
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanDefinition.setPropertyValues(propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 6.获取UserService
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.queryUserInfo());
    }


    @Test
    public void test_classpath() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService");
        var result = userService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_bean_post_processor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring2.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        var result = userService.queryUserInfo();
        System.out.println(result);
    }


    @Test
    public void test_inti_destroy_method_by_beanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring3.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        UserServiceV2 userService = (UserServiceV2) beanFactory.getBean("userServiceV2");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        beanFactory.getDisposableBeans().values().forEach(disposableBean -> {
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void test_application_context(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_inti_destroy_method() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring3.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserServiceV2 userService = applicationContext.getBean("userServiceV2", UserServiceV2.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_aware() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aware_spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        AwareUserService userService = applicationContext.getBean("awareUserService", AwareUserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }
}
