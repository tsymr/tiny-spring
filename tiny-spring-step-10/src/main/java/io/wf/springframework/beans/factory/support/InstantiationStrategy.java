package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * InstantiationStrategy
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 10:10 AM
 */
public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException;
}
