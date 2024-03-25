package io.wf.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * FileSystemResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:08 AM
 */
public class FileSystemResource implements Resource{

    private String path;
    private File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(file.toPath());
    }
}
