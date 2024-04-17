package io.wf.springframework.context.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanFactoryPostProcessor;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.context.ApplicationContextAware;
import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;
import io.wf.springframework.context.ConfigurableApplicationContext;
import io.wf.springframework.context.event.ApplicationEventMulticaster;
import io.wf.springframework.context.event.ContextCloseEvent;
import io.wf.springframework.context.event.ContextRefreshEvent;
import io.wf.springframework.context.event.SimpleApplicationEventMulticaster;
import io.wf.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * AbstractApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 11:30 AM
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public final static  String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 创建 BeanFactory 并加载 BeanDefinition
        refreshBeanFactory();
        // 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 提前添加ApplicationContextAwareProcessor
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 在bean实例化前执行BeanFactoryPostProcessor修改bean定义
        invokeBeanFactoryPostProcessors(beanFactory);
        // 提前实例化BeanPostProcessor
        registerBeanPostProcessors(beanFactory);
        // 6. 初始化事件发布者
        initApplicationEventMulticaster();
        // 7. 注册事件监听器
        registerListeners();

        // 提前实例化单例bean
        beanFactory.preInstantiateSingletons();

        // 发送Application Context 刷新完毕事件
        finishRefresh();
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
       applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
       beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners(){
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh(){
        publishEvent(new ContextRefreshEvent(this));
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(beanName, requireType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public void close() {
        publishEvent(new ContextCloseEvent(this));
        getBeanFactory().destroySingletons();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }
}
