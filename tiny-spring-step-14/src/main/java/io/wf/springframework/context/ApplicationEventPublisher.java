package io.wf.springframework.context;

/**
 * ApplicationEventPublisher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 2:29 PM
 */
public interface ApplicationEventPublisher {

    /**
     * 通知所有在此应用程序中注册的application事件
     * 事件可以是框架事件(如RequestHandledEvent)
     * 或特定于应用程序的事件。
     *
     * @param event 要发布的事件
     */
    void publishEvent(ApplicationEvent event);
}
