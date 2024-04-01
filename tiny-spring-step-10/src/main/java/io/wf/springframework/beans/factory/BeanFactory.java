package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:49 AM
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object[] args) throws BeansException;

    <T> T getBean(String beanNam, Class<T> requireType) throws BeansException;
}
