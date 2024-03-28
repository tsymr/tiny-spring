package io.wf.springframework.beans.factory;

/**
 * BeanClassLoaderAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 2:18 PM
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
