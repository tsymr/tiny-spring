package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 10:44 AM
 */
public interface ConfigurableListableBeanFactory extends HierarchicalBeanFactory, ListableBeanFactory, ConfigurableBeanFactory {

    void preInstantiateSingletons();

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
