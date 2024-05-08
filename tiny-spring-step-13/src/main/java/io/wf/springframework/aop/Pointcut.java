package io.wf.springframework.aop;

/**
 * PointCut
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 3:37 PM
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
