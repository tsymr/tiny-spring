package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 3:39 PM
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型获取 Bean
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 获取所有 Bean 定义的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
