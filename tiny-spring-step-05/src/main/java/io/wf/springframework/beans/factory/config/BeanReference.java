package io.wf.springframework.beans.factory.config;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 9:46 AM
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
