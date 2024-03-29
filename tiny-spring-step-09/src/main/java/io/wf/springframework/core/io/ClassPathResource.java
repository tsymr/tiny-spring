package io.wf.springframework.core.io;

import cn.hutool.core.lang.Assert;
import io.wf.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassPathResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 10:34 AM
 */
public class ClassPathResource implements Resource{


    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classLoader.getResourceAsStream(path);
    }
}
