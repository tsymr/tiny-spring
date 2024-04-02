package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanNameAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 11:26 AM
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String beanName) throws BeansException;
}
