package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 3:05 PM
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
