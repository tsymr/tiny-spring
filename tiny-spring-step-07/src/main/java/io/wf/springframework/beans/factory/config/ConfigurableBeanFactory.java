package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 4:45 PM
 */
public interface ConfigurableBeanFactory  extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void  addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
