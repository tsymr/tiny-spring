package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinitionRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/29 10:23 AM
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
