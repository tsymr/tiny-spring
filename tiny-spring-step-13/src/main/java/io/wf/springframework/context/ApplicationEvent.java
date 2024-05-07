package io.wf.springframework.context;

import java.util.EventObject;

/**
 * ApplicationEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:09 PM
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
