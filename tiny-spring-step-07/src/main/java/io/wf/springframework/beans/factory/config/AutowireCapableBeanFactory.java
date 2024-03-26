package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.BeanFactory;

/**
 * AutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 4:48 PM
 */
public interface AutowireCapableBeanFactory  extends BeanFactory {

    void applyBeanPostProcessorsBeforeInitialization(Object existBean, String beanName);

    void applyBeanPostProcessorsAfterInitialization(Object existBean, String beanName);
}
