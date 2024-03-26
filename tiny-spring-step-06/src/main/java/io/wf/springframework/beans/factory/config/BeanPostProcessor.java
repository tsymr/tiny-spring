package io.wf.springframework.beans.factory.config;

/**
 * BeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 11:06 AM
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
