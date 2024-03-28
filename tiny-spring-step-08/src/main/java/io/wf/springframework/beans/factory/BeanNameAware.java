package io.wf.springframework.beans.factory;

/**
 * BeanNameAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 2:18 PM
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
