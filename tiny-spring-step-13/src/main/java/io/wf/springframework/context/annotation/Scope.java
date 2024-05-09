package io.wf.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * Scope
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/9 9:49 AM
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
