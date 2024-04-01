package io.wf.springframework.beans.factory;

/**
 * FactoryBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:57 AM
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
