package io.wf.springframework.util;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (cl == null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
