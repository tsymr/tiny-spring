package io.wf.springframework.beans.factory.support;

import io.wf.springframework.core.io.Resource;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * BeanDefinitionReader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:13 AM
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void  loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(Resource[] resources);

    void loadBeanDefinitions(String location);

    void loadBeanDefinitions(String[] locations);
}
