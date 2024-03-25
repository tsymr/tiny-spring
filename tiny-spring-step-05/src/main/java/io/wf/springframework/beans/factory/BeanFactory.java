package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * BeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:40 AM
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String beanName, Class<T> requireType) throws BeansException;

}
