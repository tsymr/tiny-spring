package io.wf.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:54 AM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            applyBeanPropertyValues(beanName, beanDefinition, bean);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor ctor = null;
        for (Constructor declaredConstructor : declaredConstructors) {
            if (null != args && args.length == declaredConstructor.getParameterTypes().length) {
                ctor = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, ctor, args);
    }

    private void applyBeanPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean){
        try {
            PropertyValues propertyValues =  beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference beanReference){
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting bean property values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
