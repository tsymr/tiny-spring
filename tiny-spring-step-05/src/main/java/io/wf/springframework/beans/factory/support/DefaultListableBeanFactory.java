package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultListableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:04 AM
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }
}
