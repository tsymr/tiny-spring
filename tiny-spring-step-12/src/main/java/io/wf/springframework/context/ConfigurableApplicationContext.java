package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 11:25 AM
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeansException;

    void close();

    void registerShutdownHook();
}
