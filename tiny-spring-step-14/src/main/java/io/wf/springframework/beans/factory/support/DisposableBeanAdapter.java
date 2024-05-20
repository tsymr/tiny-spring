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
 * @date 2024/5/16 2:14 PM
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private  String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 实现 DisposableBean 接口的
        if(bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if(!(bean instanceof DisposableBean) && StrUtil.isNotEmpty(destroyMethodName)) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if(null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named [" + destroyMethodName + "] on bean with name + [" + beanName + "]");
            }
            destroyMethod.invoke(bean);
        }
    }
}
