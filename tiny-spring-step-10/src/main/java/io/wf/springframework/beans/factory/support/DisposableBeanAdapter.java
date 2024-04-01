package io.wf.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * DisposableBeanAdapter
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:42 AM
 */
public class DisposableBeanAdapter implements DisposableBean {

    private String beanName;
    private Object bean;
    private String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, BeanDefinition beanDefinition){
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }
        if (!(bean instanceof DisposableBean) && StrUtil.isNotEmpty(destroyMethodName)){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method){
                throw new BeansException("Could not find a destroy method named " + destroyMethodName + " on bean with named " + beanName);
            }
            method.invoke(bean);
        }
    }
}
