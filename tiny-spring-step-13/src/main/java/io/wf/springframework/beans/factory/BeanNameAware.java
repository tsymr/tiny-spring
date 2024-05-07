package io.wf.springframework.beans.factory;

/**
 * BeanNameAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:03 AM
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String beanName);
}
