package io.wf.springframework.beans.factory.support;

import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * AbstractBeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:40 PM
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return null;
    }
}
