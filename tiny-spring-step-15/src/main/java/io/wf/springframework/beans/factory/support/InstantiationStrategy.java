package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * InstantiationStrategy
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:47 AM
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;
}
