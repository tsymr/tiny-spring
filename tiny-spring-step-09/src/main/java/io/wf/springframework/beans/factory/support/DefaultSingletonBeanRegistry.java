package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 3:13 PM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private Map<String, DisposableBean> disposableBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singleton) {
        this.singletonObjects.put(beanName, singleton);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = disposableBeanMap.keySet();
        Object[] disableBeanNames = keySet.toArray();
        for (int i = disableBeanNames.length - 1; i >= 0; i--) {
            Object disableBeanName = disableBeanNames[i];
            DisposableBean disposableBean = disposableBeanMap.remove(disableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name [" + disableBeanName + "] threw an exception", e);
            }
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        this.disposableBeanMap.put(beanName, disposableBean);
    }

    public Map<String, DisposableBean> getDisposableBeans() {
        return disposableBeanMap;
    }
}