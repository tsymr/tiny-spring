package io.wf.springframework.context.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanFactoryPostProcessor;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.context.ApplicationEvent;
import io.wf.springframework.context.ApplicationListener;
import io.wf.springframework.context.ConfigurableApplicationContext;
import io.wf.springframework.context.event.ApplicationEventMulticaster;
import io.wf.springframework.context.event.ContextClosedEvent;
import io.wf.springframework.context.event.ContextRefreshedEvent;
import io.wf.springframework.context.event.SimpleApplicationEventMulticaster;
import io.wf.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * AbstractApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 3:02 PM
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    private static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;


    @Override
    public void refresh() throws BeansException {
        // 创建 BeanFactory， 并加载 BeanDefinition
        refreshBeanFactory();
        // 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 在 Bean 实例化之前，执行 BeanFactoryPostProcessor 修改 BeanDefinition
        invokeBeanFactoryPostProcessors(beanFactory);
        // 提前注册 BeanPostProcessor
        registerBeanPostProcessors(beanFactory);
        // 初始化事件发布者
        initApplicationEventMulticaster();
        // 注册事件监听器
        registerListeners();
        // 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();
        // 发布容器刷新事件
        finishRefresh();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();


    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Collection<BeanFactoryPostProcessor> beanFactoryPostProcessors = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values();
        beanFactoryPostProcessors.forEach(beanFactoryPostProcessor -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
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
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        // 执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }
}
