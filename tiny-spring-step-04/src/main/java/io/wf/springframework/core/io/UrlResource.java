package io.wf.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource{

    private URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = url.openConnection();
        try {
            return conn.getInputStream();
        } catch (IOException e) {
            if(conn instanceof HttpURLConnection){
                ((HttpURLConnection) conn).disconnect();
            }
            throw new RuntimeException(e);
        }
    }
}
