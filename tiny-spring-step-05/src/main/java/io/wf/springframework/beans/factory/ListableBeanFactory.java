package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 11:12 AM
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表总所有的bean名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
