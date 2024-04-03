package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;

/**
 * ApplicationEventMulticaster
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 2:31 PM
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationContext(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
