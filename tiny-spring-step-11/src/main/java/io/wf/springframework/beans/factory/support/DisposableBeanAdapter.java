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
 * @date 2024/4/2 10:53 AM
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final String beanName;
    private final Object bean;
    private final String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean)) {
            Class<?> beanClass = bean.getClass();
            Method method = beanClass.getMethod(destroyMethodName);
            if (null == method) {
                throw new BeansException("Colud find a destroy method named [" + destroyMethodName + "] on bean with name + [" + beanName + "]");
            }
            method.invoke(bean);
        }
    }
}
