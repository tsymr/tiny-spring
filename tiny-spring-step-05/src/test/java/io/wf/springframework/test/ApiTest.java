package io.wf.springframework.test;

import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanReference;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import io.wf.springframework.test.bean.UserDao;
import io.wf.springframework.test.bean.UserService;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.test.common.MyBeanFactoryPostProcessor;
import io.wf.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){

        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 4.设置UserService属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id","1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 5.注册UserService定义
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanDefinition.setPropertyValues(propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 6.获取UserService
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


    @Test
    public void test_xml(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        
        UserService userService = (UserService) beanFactory.getBean("userService");
        var result=  userService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_bean_post_processor(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring2.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        var result=  userService.queryUserInfo();
        System.out.println(result);
    }



}
