package io.wf.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Value
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/21 10:16 AM
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
