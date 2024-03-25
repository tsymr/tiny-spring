package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.config.BeanDefinition;

/**
 * AbstractBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:50 AM
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requireType) throws BeansException {
        return (T) getBean(beanName);
    }

    private <T> T doGetBean(String beanName, Object... args){
        Object bean = getSingleton(beanName);
        if (null != bean){
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
