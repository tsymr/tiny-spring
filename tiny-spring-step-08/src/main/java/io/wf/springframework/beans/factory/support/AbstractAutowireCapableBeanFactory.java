package io.wf.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.*;
import io.wf.springframework.beans.factory.config.AutowireCapableBeanFactory;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanPostProcessor;
import io.wf.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * AbstractAutowireCapableBeanFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 3:53 PM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassInstantiationStrategy();

    /**
     * 实例化，设置属性，执行前置后置处理器，执行初始化方法，注册销毁方法
     *
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {
        Object bean;
        try {
            // 1.实例化Bean
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 2.设置Bean属性和依赖注入
            applyPropertyValues(beanName, bean, beanDefinition);
            // 3.执行前置处理器、初始化方法、后置处理器
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 4.注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
        // 5.添加单例bean到单例池
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 实例化 Bean 对象
     *
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object... args) {
        Class beanClass = beanDefinition.getBeanClass();
        Constructor constructorToUse = null;
        for (Constructor declaredConstructor : beanClass.getDeclaredConstructors()) {
            if (null != args && args.length == declaredConstructor.getParameterTypes().length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructorToUse, args);
    }

    /**
     * 设置 Bean 属性以及依赖注入
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference beanReference) {
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting bean property values: " + beanName, e);
        }
    }

    /**
     * 执行前置处理器方法、初始化方法、后置处理器方法
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @return
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        if (bean instanceof Aware){
            if (bean instanceof BeanFactoryAware beanFactoryAware){
                beanFactoryAware.setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware beanClassLoaderAware){
                beanClassLoaderAware.setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware beanNameAware){
                beanNameAware.setBeanName(beanName);
            }
        }

        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean [" + beanName + "]", e);
        }
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    /**
     * 执行初始化方法
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof InitializingBean initializingBean) {
            initializingBean.afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            Method method = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == method) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


    /**
     * 注册实现了 DisposableBean 接口的 或 定义了销毁方法的 Bean 对象
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(beanName, bean, beanDefinition));
        }
    }

    /**
     * 执行前置处理器
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 执行后置处理器
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }
}
