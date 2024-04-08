package io.wf.springframework.test;

import cn.hutool.core.io.IoUtil;
import io.wf.springframework.aop.AdvisedSupport;
import io.wf.springframework.aop.MethodMatcher;
import io.wf.springframework.aop.TargetSource;
import io.wf.springframework.aop.aspectj.AspectJExpressionPointcut;
import io.wf.springframework.aop.framework.Cglib2AopProxy;
import io.wf.springframework.aop.framework.JdkDynamicAopProxy;
import io.wf.springframework.aop.framework.ReflectiveMethodInvocation;
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
import io.wf.springframework.test.bean.event.CustomEvent;
import io.wf.springframework.test.bean.factorybean.FactoryBeanUserService;
import io.wf.springframework.test.common.MyBeanFactoryPostProcessor;
import io.wf.springframework.test.common.MyBeanPostProcessor;
import io.wf.springframework.test.proxy.IProxyService;
import io.wf.springframework.test.proxy.ProxyService;
import io.wf.springframework.test.proxy.ProxyServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


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
        String result = userService.queryUserInfo();
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
        String result = userService.queryUserInfo();
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
    }

    @Test
    public void test_application_context() {
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
        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factorybean.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        FactoryBeanUserService userService01 = applicationContext.getBean("userService", FactoryBeanUserService.class);
        FactoryBeanUserService userService02 = applicationContext.getBean("userService", FactoryBeanUserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factorybean.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        FactoryBeanUserService userService = applicationContext.getBean("userService", FactoryBeanUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.ProxyService.*(..))");
        Class<ProxyService> clazz = ProxyService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));

        // true、true
    }

    @Test
    public void test_proxy_method() {
        Object targetObj = new ProxyService();
        IProxyService proxy = (IProxyService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {

            // 方法匹配
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.IProxyService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin by AOP");
                            System.out.println("方法名称: " + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_dynamic() {
        IProxyService proxyService = new ProxyService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(proxyService));
        advisedSupport.setMethodInterceptor(new ProxyServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.IProxyService.*(..))"));

        IProxyService proxy_jdk = (IProxyService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo() + "\r\n");

        // 代理对象(Cglib2AopProxy)
        IProxyService proxy_cglib = (IProxyService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
