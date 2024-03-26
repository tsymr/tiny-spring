package io.wf.springframework.test.common;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.test.bean.UserService;

/**
 * MyBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 10:13 AM
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("改为萧山");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
