package io.wf.springframework.beans.factory.support;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * CglibSubClassInstantiationStrategy
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:19 AM
 */
public class CglibSubClassInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null != constructor) {
            return enhancer.create(constructor.getParameterTypes(), args);
        }
        return enhancer.create();
    }
}
