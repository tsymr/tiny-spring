package io.wf.springframework.context;

/**
 * ApplicationEventPublish
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 2:25 PM
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
