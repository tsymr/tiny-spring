package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 10:58 AM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
