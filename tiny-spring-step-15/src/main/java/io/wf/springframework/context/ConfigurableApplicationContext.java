package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 2:35 PM
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 向虚拟机注入关闭容器钩子
     */
    void registerShutdownHook();

    /**
     * 关闭容器
     */
    void close();
}
