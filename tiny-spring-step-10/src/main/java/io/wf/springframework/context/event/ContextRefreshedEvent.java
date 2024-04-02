package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationEvent;

/**
 * ContextRefreshedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 9:33 AM
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
