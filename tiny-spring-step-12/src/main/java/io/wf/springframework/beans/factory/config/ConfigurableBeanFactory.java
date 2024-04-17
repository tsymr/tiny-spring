package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:22 PM
 */
public interface ConfigurableBeanFactory extends SingletonBeanRegistry, HierarchicalBeanFactory {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
