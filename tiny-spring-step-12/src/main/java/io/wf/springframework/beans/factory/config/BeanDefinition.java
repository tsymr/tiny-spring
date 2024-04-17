package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.PropertyValues;
import lombok.Getter;
import lombok.Setter;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/10 10:13 AM
 */
@Getter
@Setter
public class BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    private Class<?> beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;

    private boolean isSingleton = true;

    private boolean isPrototype = false;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.isSingleton = scope.equals(SCOPE_SINGLETON);
        this.isPrototype = scope.equals(SCOPE_PROTOTYPE);
    }

}
