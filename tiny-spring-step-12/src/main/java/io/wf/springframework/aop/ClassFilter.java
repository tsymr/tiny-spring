package io.wf.springframework.aop;

/**
 * ClassFilter
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 3:38 PM
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
