package io.wf.springframework.context.event;

/**
 * ContextRefreshedEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 3:00 PM
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
