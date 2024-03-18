package io.wf.springframework.test;

import io.wf.springframework.test.bean.UserService;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){

        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class));

        //3.第一次获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService", "Ts");
        userService.queryUserInfo();

    }
}
