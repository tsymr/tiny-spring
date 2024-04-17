package io.wf.springframework.context;

import java.util.EventListener;

/**
 * ApplicationListener
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 11:34 AM
 */
public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
