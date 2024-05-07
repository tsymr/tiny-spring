package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:12 PM
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
