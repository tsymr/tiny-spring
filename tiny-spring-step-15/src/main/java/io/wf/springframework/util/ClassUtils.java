package io.wf.springframework.util;

/**
 * ClassUtils
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 9:20 AM
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    /**
     * 检查指定的类是否为cglib生成的类。
     * @param clazz
     * @return
     */
    public static  boolean isCglibProxyClass(Class<?> clazz){
        return  clazz != null && isCglibProxyClassName(clazz.getName());
    }

    /**
     * 检查指定的类名是否为cglib生成的类。
     * @param className
     * @return
     */
    public static boolean isCglibProxyClassName(String className) {
        return className != null && className.contains("$$");
    }
}
