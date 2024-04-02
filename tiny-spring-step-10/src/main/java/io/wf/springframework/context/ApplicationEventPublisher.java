package io.wf.springframework.context;

/**
 * ApplicationEventPublisher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 9:48 AM
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
