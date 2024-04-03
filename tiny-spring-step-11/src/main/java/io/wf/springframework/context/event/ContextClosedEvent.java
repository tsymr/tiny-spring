package io.wf.springframework.context.event;

/**
 * ContextClosedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 2:30 PM
 */
public class ContextClosedEvent extends ApplicationContextEvent{

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
