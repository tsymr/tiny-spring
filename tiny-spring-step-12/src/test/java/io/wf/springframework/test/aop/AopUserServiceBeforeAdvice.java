package io.wf.springframework.test.aop;

import io.wf.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AopUserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
