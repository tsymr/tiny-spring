package io.wf.springframework.beans.factory.config;

import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.HierarchicalBeanFactory;
import io.wf.springframework.util.StringValueResolver;

/**
 * ConfigurableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:36 AM
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * 添加 BeanPostProcessor 接口实现类对象
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();


    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);
}
