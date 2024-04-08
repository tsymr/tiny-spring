package io.wf.springframework.util;

/**
 * ClassUtils
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 10:34 AM
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (null == cl) {
            cl = ClassUtils.class.getClassLoader();
        }

        return cl;
    }
}
