package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.core.io.Resource;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * BeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:37 PM
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource[] resources) throws BeansException;
}
