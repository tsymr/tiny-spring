package io.wf.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * AdvisedSupport
 * <p>
 * AOP 代理配置管理器的基类。
 * 这些本身不是 AOP 代理，但该类的子类是
 * 通常是直接获取AOP代理实例的工厂。
 * <p>
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:05 AM
 */
public class AdvisedSupport {
    // proxyConfig
    private boolean proxyTargetClass = false;

    // 被代理的目标对象
    private TargetSource targetSource;

    // 方法拦截器
    private MethodInterceptor methodInterceptor;

    // 方法匹配器（检查目标方法是否符合通知条件）
    private  MethodMatcher methodMatcher;


    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
