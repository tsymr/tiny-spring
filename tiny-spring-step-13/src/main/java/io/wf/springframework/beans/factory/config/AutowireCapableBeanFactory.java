package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.BeanFactory;

/**
 * AutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 9:56 AM
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object bean, String beanName) throws BeansException;
}
