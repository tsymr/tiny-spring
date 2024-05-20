package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.PropertyValues;
import lombok.Getter;
import lombok.Setter;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:25 AM
 */
@Getter
@Setter
public class BeanDefinition {
    String SCOPE_SINGLETON = "SCOPE_SINGLETON";

    String SCOPE_PROTOTYPE = "SCOPE_PROTOTYPE";

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    private String scope;

    private boolean singleton = true;

    private boolean prototype = false;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setScope(String scope){
        this.scope = scope;
        this.singleton = scope.equals(SCOPE_SINGLETON);
        this.prototype = scope.equals(SCOPE_PROTOTYPE);
    }
}
