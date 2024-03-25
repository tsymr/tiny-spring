package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:46 AM
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
