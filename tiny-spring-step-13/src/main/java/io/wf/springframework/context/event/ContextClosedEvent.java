package io.wf.springframework.context.event;

/**
 * ContextClosedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:28 PM
 */
public class ContextClosedEvent extends ApplicationContextEvent{

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
