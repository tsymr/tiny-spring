package io.wf.springframework.context.event;

import io.wf.springframework.context.ApplicationContext;
import io.wf.springframework.context.ApplicationEvent;

/**
 * ApplicationContextEvent
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 9:32 AM
 */
public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
