package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultSingletonBeanRegistry
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:53 AM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        this.singletonObjects.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        this.disposableBeans.put(beanName, disposableBean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' failed", e);
            }
        }
    }
}
