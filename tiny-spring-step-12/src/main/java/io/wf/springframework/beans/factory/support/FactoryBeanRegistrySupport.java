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
 * @date 2024/4/17 10:10 AM
 */
public class FactoryBeanRegistrySupport  extends DefaultSingletonBeanRegistry{

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName){
        return this.factoryBeanObjectCache.get(beanName);
    }


    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName){
        if (factoryBean.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (null == object){
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, factoryBean);
            }
            return object;
        }else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }


    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName){
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw an exception on object [" + beanName + "] creation", e);
        }
    }
}
