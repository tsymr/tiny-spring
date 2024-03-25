package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:47 AM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singleton){
        this.singletonObjects.put(beanName, singleton);
    }
}
