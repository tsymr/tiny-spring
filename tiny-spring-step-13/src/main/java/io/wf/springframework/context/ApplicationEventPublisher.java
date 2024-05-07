package io.wf.springframework.context;

/**
 * ApplicationEventPublisher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:10 PM
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
