package io.wf.springframework.beans.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/18 9:34 AM
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例Bean
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
