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
 * @date 2024/4/1 9:54 AM
 */
public interface ConfigurableListableBeanFactory extends AutowireCapableBeanFactory, ConfigurableBeanFactory, ListableBeanFactory {

    void preInstantiateSingletons() throws BeansException;

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
