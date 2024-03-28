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
 * @date 2024/3/27 5:12 PM
 */
public class DisposableBeanAdapter implements DisposableBean {

    private String beanName;
    private Object bean;
    private String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean disposableBean){
            disposableBean.destroy();
        }
        if (StrUtil.isNotEmpty(destroyMethodName) &&!(bean instanceof DisposableBean)){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method){
                throw new BeansException("Could not find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }
}
