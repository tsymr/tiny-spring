package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.Resource;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * AbstractBeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 11:26 AM
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

}
