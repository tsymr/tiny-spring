package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * BeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 3:37 PM
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 初始化方法执行前执行该方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 初始化方法执行后执行该方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
