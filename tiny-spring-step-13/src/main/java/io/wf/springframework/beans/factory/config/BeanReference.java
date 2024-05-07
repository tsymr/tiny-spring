package io.wf.springframework.beans.factory.config;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:15 PM
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
