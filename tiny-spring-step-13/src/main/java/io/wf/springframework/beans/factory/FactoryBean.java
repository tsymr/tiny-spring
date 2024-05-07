package io.wf.springframework.beans.factory;

/**
 * FactoryBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:22 PM
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
