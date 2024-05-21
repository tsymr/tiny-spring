package io.wf.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Qualifier
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/21 10:15 AM
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
