package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/18 9:35 AM
 */
public class DefaultSingletonRegistry  implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singleton){
        singletonObjects.put(beanName, singleton);
    }
}
