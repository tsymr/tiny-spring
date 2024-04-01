package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:50 AM
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> requireType) throws BeansException;

    String[] getBeanDefinitionNames();
}
