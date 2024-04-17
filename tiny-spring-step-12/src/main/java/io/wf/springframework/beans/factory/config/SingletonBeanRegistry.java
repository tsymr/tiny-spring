package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:15 PM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void  registerSingleton(String beanName, Object singleton);

    void destroySingletons();
}
