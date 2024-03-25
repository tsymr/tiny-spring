package io.wf.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * UrlResource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/25 10:09 AM
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = url.openConnection();

        try {
            return conn.getInputStream();
        } catch (IOException e) {
            if (conn instanceof HttpURLConnection httpURLConnection) {
                httpURLConnection.disconnect();
            }
            throw new RuntimeException(e);
        }
    }
}
