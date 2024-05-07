package io.wf.springframework.core.io;

/**
 * ResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 10:10 AM
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
