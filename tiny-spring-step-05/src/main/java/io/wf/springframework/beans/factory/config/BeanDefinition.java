package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.PropertyValues;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:45 AM
 */
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
