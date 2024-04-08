package io.wf.springframework.aop;

/**
 * ClassFilter
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 10:37 AM
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
