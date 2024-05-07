package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:06 AM
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
