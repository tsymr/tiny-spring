package io.wf.springframework.stereotype;

import java.lang.annotation.*;

/**
 * Component
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:11 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
