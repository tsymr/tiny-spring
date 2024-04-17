package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationEvent;

/**
 * ContextRefreshEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:22 PM
 */
public class ContextRefreshEvent extends ApplicationEvent {
    public ContextRefreshEvent(Object source) {
        super(source);
    }
}
