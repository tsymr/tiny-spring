package io.wf.springframework.context.event;

/**
 * ContextCloseEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:21 PM
 */
public class ContextCloseEvent extends ApplicationContextEvent{
    public ContextCloseEvent(Object source) {
        super(source);
    }
}
