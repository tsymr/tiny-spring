package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanFactoryAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:03 AM
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
