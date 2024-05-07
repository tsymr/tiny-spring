package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:20 PM
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
