package io.wf.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/18 9:38 AM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            applyPropertyValues(beanName, beanDefinition, bean);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args){
        Constructor constructor = null;
        Class clazz = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if (null != args && args.length == declaredConstructor.getParameterTypes().length){
                constructor = declaredConstructor;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructor, args);
    }

    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean){
        try {
            PropertyValues propertyValues =  beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setProperty(bean, name, value);
            }
        } catch (BeansException e) {
            throw new RuntimeException("Error setting property values for bean: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
