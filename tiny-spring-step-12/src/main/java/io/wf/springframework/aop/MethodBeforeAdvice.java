package io.wf.springframework.aop;

import java.lang.reflect.Method;

/**
 * MethodBeforeAdvice
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 2:53 PM
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
