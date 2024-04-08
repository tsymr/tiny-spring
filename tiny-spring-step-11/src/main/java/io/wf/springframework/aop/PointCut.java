package io.wf.springframework.aop;


/**
 * PointCut
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 10:35 AM
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
