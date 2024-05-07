package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:05 AM
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
