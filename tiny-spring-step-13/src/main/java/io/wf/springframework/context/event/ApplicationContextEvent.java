package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationContext;
import io.wf.springframework.context.ApplicationEvent;

/**
 * ApplicationContextEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:14 PM
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
