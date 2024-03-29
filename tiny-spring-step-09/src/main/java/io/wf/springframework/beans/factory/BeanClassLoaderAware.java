package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * BeanClassLoaderAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/29 11:17 AM
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}
