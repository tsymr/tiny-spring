package io.wf.springframework.context;

import java.util.EventListener;

/**
 * ApplicationEventListener
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 2:26 PM
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
