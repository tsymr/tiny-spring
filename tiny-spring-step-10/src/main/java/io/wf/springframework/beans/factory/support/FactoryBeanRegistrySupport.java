package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.FactoryBean;

import java.util.Map;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FactoryBeanRegistrySupport
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:57 AM
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return Objects.isNull(object) ? null : object;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (null == object) {
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, object);
            }
            return Objects.isNull(object) ? null : object;
        } else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw an exception on Object [" + beanName + "] creation", e);
        }
    }
}
