package io.wf.springframework.aop;

/**
 * Pointcut
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 2:16 PM
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
