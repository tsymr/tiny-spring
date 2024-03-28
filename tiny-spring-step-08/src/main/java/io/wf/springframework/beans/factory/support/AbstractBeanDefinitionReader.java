package io.wf.springframework.beans.factory.support;

import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * AbstractBeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 10:39 AM
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader == null ? new DefaultResourceLoader() : resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
