package io.wf.springframework.context;

import java.util.EventListener;

/**
 * ApplicationListener
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 2:36 PM
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理 application 事件。
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
