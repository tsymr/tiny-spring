package io.wf.springframework.test.common;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;
import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanFactoryPostProcessor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * MyBeanFactoryPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 11:36 AM
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (Arrays.asList(beanFactory.getBeanDefinitionNames()).contains("userServiceV2")) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userServiceV2");
            PropertyValues propertyValues =  beanDefinition.getPropertyValues();
            propertyValues.addPropertyValue(new PropertyValue("company", "改为匠人网络"));
        }else {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
            PropertyValues propertyValues =  beanDefinition.getPropertyValues();
            propertyValues.addPropertyValue(new PropertyValue("company", "改为匠人网络"));
        }

    }
}
