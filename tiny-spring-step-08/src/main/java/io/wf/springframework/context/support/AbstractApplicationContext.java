package io.wf.springframework.context.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanFactoryPostProcessor;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * AbstractApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 9:30 AM
 */
public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory并加载BeanDefinition
        refreshBeanFactory();
        // 2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4.执行BeanFactoryPostProcessor修改BeanDefinition
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5.提前注册BeanPostProcessor
        registerBeanPostProcessors(beanFactory);
        // 6.提前实例化单例Bean
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 创建 BeanFactory 并加载 BeanDefinition
     *
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取 BeanFactory
     *
     * @return
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     *  执行 BeanFactoryPostProcessor 修改 BeanDefinition
     * @param beanFactory
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 提前实例化 BeanPostProcessor
     * @param beanFactory
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object[] args) throws BeansException {
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
}
