package io.wf.springframework.context;

import java.util.EventObject;

/**
 * ApplicationEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 9:31 AM
 */
public class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
