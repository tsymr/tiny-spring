package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:39 AM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void destroySingletons();
}
