package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 10:51 AM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private Map<String, DisposableBean> disposableBeanMap = new ConcurrentHashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singleton) {
        this.singletonObjects.put(beanName, singleton);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean){
        this.disposableBeanMap.put(beanName, disposableBean);
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
                throw new BeansException("Destroy method on bean with name [" + disposableBeanName + "] threw an exception" , e);
            }
        }
    }
}
