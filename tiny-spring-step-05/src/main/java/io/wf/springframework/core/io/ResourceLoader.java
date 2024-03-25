package io.wf.springframework.core.io;

/**
 * ResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:10 AM
 */
public interface ResourceLoader {
    String CLASS_PATH_PREFIX ="classpath:";
    Resource getResource(String location);
}
