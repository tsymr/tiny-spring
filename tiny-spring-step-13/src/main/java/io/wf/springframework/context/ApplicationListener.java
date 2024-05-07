package io.wf.springframework.context;

import java.util.EventListener;

/**
 * ApplicationListener
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:11 PM
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
