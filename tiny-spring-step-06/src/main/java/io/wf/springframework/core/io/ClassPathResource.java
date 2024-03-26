package io.wf.springframework.core.io;

import io.wf.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassPathResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 11:30 AM
 */
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classLoader.getResourceAsStream(path);
    }
}
