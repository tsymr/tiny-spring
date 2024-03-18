package io.wf.springframework.beans.factory.config;

/**
 * BeanDefinition
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/18 9:33 AM
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
