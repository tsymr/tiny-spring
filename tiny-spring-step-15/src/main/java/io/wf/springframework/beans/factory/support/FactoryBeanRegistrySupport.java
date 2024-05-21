package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FactoryBeanRegistrySupport
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:52 AM
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();


    protected Object getCachedObjectFromFactoryBean(String beanName) {
        Object object = factoryBeanObjectCache.get(beanName);
        return object != NULL_OBJECT ? object : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName){
        if(factory.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);
            if(object == null){
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, object);
            }
            return object != NULL_OBJECT ? object : null;
        }else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw an exception on object [" + beanName + "] creation", e);
        }
    }
}
