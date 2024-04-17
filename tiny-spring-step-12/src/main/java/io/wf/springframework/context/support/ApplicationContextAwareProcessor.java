package io.wf.springframework.context.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.context.ApplicationContext;
import io.wf.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAwareProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:35 PM
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) throws BeansException {
        return null;
    }
}
