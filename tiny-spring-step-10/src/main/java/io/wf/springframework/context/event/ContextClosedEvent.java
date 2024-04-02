package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationEvent;

/**
 * ContextClosedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 9:33 AM
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
