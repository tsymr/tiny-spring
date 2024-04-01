package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanFactoryAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 10:33 AM
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
