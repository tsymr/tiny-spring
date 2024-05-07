package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:21 PM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
