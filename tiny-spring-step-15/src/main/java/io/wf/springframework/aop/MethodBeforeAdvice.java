package io.wf.springframework.aop;

import java.lang.reflect.Method;

/**
 * MethodBeforeAdvice
 * <p>
 * Advice invoked before a method is invoked. Such advices cannot
 * prevent the method call proceeding, unless they throw a Throwable.
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:17 AM
 */
public interface MethodBeforeAdvice {

    /**
     * 调用给定方法之前的回调。
     *
     * @param method 被调用的方法
     * @param args   方法的参数
     * @param target 方法调用的目标。可能为<code>null</code>。
     * @throws Throwable 如果此对象希望中止调用，任何抛出的异常将会返回给调用者，
     *                   如果方法签名允许的话。否则，异常将会被包装为一个运行时异常。
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
