package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:32 AM
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
