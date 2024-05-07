package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * SimpleInstantiationStrategy
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:17 AM
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null == constructor){
                return clazz.getDeclaredConstructor().newInstance();
            }else {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
