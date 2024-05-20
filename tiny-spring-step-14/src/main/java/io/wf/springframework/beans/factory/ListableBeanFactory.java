package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:23 AM
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型获取 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有 Bean 的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
