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
 * @date 2024/4/1 10:44 AM
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
