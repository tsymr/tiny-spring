package io.wf.springframework.beans.factory.support;

import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * Abstract base class for bean definition readers which implement
 * the {@link BeanDefinitionReader} interface.
 * <p>
 *
 *
 *
 *
 *
 * 
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
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
