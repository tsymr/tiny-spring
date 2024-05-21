package io.wf.springframework.aop;

/**
 * ClassFilter
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 9:50 AM
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
