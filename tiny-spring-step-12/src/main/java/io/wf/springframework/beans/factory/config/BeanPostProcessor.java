package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * BeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:19 PM
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(String beanName, Object bean) throws BeansException;

    Object postProcessAfterInitialization(String beanName, Object bean) throws BeansException;
}
