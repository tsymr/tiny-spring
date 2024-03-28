package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.factory.config.AutowireCapableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 3:45 PM
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, AutowireCapableBeanFactory, ListableBeanFactory {

    /**
     * 提前实例化单例 bean
     */
    void preInstantiateSingletons();

    /**
     * 获取 beanDefinition
     *
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);
}
