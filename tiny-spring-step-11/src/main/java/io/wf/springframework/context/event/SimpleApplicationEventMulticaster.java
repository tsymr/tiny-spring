package io.wf.springframework.context.event;

import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;

/**
 * SimpleApplicationEventMulticaster
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/3 10:54 AM
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
