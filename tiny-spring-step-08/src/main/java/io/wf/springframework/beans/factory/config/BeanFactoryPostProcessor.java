package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 5:23 PM
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

}
