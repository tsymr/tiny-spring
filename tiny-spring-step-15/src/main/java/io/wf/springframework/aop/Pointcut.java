package io.wf.springframework.aop;

/**
 * Pointcut
 *
* <p>
 * 切入点由{@link ClassFilter}和{@link MethodMatcher}组成。
 * 这些基本术语和切入点本身都可以组合起来构建组合
 * <p>
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:03 AM
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
