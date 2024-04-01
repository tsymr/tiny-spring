package io.wf.springframework.context.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * AbstractRefreshableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 10:51 AM
 */
public abstract class AbstractRefreshableBeanFactory extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory factory = createBeanFactory();
        loadBeanDefinitions(factory);
        this.beanFactory = factory;
    }

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
