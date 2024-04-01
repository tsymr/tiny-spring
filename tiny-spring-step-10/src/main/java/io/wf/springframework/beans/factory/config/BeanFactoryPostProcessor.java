package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:54 AM
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
