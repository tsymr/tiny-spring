package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * BeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:52 AM
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
