package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.AutowireCapableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 11:23 AM
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, ListableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
