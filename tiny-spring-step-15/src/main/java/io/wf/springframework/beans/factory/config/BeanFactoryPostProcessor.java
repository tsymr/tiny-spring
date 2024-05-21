package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:40 AM
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
