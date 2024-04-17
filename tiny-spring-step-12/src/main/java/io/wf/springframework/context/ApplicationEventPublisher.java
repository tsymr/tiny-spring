package io.wf.springframework.context;

/**
 * ApplicationEventPublisher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 11:33 AM
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
