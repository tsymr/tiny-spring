package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;

/**
 * ApplicationEventMulticaster
 *
 * Application 事件组播器
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 2:39 PM
 */
public interface ApplicationEventMulticaster {


    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
