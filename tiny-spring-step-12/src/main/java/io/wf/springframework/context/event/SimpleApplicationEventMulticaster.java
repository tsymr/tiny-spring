package io.wf.springframework.context.event;

import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;

/**
 * SimpleApplicationEventMulticaster
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:29 PM
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
