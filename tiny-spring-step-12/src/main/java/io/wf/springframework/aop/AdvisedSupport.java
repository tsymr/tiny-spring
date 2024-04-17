package io.wf.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * AdvisedSupport
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 3:44 PM
 */
public class AdvisedSupport {

    // 被代理的对象
    private TargetSource targetSource;

    // 方法拦截器
    private MethodInterceptor methodInterceptor;

    // 方法匹配器(检查目标方法是否符合通知条件)
    private MethodMatcher methodMatcher;


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
