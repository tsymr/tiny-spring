package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 9:53 AM
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
