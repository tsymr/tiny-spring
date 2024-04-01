package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:40 AM
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private Map<String, DisposableBean> disposableBeanMap = new ConcurrentHashMap<>();

    protected void addSingleton(String beanName, Object singleton) {
        this.singletonObjects.put(beanName, singleton);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        this.disposableBeanMap.put(beanName, bean);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = disposableBeanMap.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeanMap.remove(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' threw on exception", e);
            }
        }
    }
}
