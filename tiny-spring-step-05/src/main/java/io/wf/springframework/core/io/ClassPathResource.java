package io.wf.springframework.core.io;

import io.wf.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassPathResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:06 AM
 */
public class ClassPathResource implements Resource{

    private ClassLoader classLoader;
    private String path;

    public ClassPathResource(String path) {
        this(null, path);

    }

    public ClassPathResource(ClassLoader classLoader, String path) {
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classLoader.getResourceAsStream(path);
    }
}
