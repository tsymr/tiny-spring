package io.wf.springframework.aop;

import java.lang.reflect.Method;

/**
 * MethodMatcher
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 2:16 PM
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
