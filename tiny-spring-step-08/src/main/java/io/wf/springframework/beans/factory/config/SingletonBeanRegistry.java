package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 3:30 PM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void destroySingletons();
}
