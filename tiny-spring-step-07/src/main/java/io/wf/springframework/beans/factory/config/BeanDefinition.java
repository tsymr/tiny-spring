package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.PropertyValues;
import lombok.Getter;
import lombok.Setter;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 4:44 PM
 */
@Getter
@Setter
public class BeanDefinition {

    private Class beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }
}
