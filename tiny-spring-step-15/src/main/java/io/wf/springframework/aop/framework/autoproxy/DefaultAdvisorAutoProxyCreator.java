package io.wf.springframework.aop.framework.autoproxy;

import io.wf.springframework.aop.*;
import io.wf.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import io.wf.springframework.aop.framework.ProxyFactory;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.PropertyValues;
import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.BeanFactoryAware;
import io.wf.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * DefaultAdvisorAutoProxyCreator
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 11:09 AM
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    private boolean isInfrastructureClass(Class<?> clazz) {
        return Advice.class.isAssignableFrom(clazz)
                || Pointcut.class.isAssignableFrom(clazz)
                || Advisor.class.isAssignableFrom(clazz);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isInfrastructureClass(bean.getClass())){
            return bean;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // 过滤匹配类
            if (!classFilter.matches(bean.getClass())) {
                continue;
            }

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            // 返回代理对象
            return new ProxyFactory(advisedSupport).getProxy();
        }

        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
