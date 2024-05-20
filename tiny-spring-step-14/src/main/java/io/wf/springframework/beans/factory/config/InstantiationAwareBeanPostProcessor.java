package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:42 AM
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法前，执行此方法
     * 主要作用在于目标对象的实例化过程中需要处理的事情，
     * 包括实例化对象的前后过程以及实例的属性设置
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
