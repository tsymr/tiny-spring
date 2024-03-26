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
 * @date 2024/3/26 11:31 AM
 */
public class FileSystemResource implements Resource{

    private File file;

    private String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(file.toPath());
    }
}
