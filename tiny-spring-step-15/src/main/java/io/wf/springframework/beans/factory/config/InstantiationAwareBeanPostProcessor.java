package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.PropertyValues;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:42 AM
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法前，执行此方法
     * 主要作用在于目标对象的实例化过程中需要处理的事情，
     * 包括实例化对象的前后过程以及实例的属性设置
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;


    /**
     * Perform operations after the bean has been instantiated, via a constructor or factory method,
     * but before Spring property population (from explicit properties or autowiring) occurs.
     * <p>This is the ideal callback for performing field injection on the given bean instance.
     * See Spring's own {@link cn.bugstack.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * for a typical example.
     * <p>
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;


    /**
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
