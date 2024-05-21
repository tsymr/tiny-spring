package io.wf.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.PropertyValues;
import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.BeanFactoryAware;
import io.wf.springframework.beans.factory.ConfigurableListableBeanFactory;
import io.wf.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import io.wf.springframework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * AutowireAnnotationBeanPostProcessor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/21 10:16 AM
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 处理 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if(null != valueAnnotation){
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 处理 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if(null != autowiredAnnotation){
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if(null != qualifierAnnotation){
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName);
                }else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }

        }
        return pvs;
    }


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Bug: 返回null会影响代理对象的创建
        // return null;
        return bean;
    }
}
