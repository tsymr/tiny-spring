package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 2:10 PM
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeansException;
}
