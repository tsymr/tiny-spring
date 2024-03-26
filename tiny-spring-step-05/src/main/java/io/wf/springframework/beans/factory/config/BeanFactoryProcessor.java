package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 11:21 AM
 */
public interface BeanFactoryProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
