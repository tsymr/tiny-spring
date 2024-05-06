package io.wf.springframework.aop;

/**
 * ClassFilter
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 2:15 PM
 */
public interface ClassFilter {


    boolean matches(Class<?> clazz);
}
