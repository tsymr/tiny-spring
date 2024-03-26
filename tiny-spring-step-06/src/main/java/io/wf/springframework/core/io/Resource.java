package io.wf.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 11:29 AM
 */
public interface Resource {
     InputStream getInputStream() throws IOException;
}
