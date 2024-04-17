package io.wf.springframework.beans.factory;

/**
 * FactoryBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 3:12 PM
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
