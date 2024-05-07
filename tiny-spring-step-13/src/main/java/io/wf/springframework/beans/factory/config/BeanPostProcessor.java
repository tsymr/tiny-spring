package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * BeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 9:57 AM
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
