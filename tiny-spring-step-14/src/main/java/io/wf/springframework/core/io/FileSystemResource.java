package io.wf.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileSystemResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:14 AM
 */
public class FileSystemResource implements Resource{

    private final File file;
    private final String path;

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
        return new FileInputStream(file);
    }

    public String getPath() {
        return path;
    }
}
