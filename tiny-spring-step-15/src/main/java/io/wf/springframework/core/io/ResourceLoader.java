package io.wf.springframework.core.io;

/**
 * ResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:17 AM
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
