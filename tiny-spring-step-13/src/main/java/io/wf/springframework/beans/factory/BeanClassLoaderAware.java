package io.wf.springframework.beans.factory;

/**
 * BeanClassLoaderAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:04 AM
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
