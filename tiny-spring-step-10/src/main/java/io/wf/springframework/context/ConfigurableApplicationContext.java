package io.wf.springframework.context;

/**
 * ConfigurableApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 10:43 AM
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh();

    void registerShutdownHook();

    void close();
}
