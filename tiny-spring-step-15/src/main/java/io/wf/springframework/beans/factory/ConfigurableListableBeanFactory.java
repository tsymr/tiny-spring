package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.AutowireCapableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:38 AM
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, ListableBeanFactory , AutowireCapableBeanFactory {

    /**
     * 根据名称获取 Bean 定义
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化单例对象
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
