package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 9:57 AM
 */
public interface ConfigurableBeanFactory  extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
