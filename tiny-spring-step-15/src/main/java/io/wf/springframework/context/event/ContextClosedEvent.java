package io.wf.springframework.context.event;

/**
 * ContextClosedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 2:59 PM
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
