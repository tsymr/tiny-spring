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
 * @date 2024/3/27 3:32 PM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<>();


    protected void addSingleton(String beanName, Object singleton) {
        this.singletonObjects.put(beanName, singleton);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }


    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        this.disposableBeans.put(beanName, disposableBean);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    public Map<String, DisposableBean> getDisposableBeans() {
        return disposableBeans;
    }
}
