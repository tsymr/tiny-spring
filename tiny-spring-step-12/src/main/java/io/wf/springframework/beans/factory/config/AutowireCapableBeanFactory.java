package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.BeanFactory;

/**
 * AutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:21 PM
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(String beanName, Object existingBean) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(String beanName, Object existingBean) throws BeansException;
}
