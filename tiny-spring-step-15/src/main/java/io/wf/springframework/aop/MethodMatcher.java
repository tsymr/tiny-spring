package io.wf.springframework.aop;

import java.lang.reflect.Method;

/**
 * MethodMatcher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 9:51 AM
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
