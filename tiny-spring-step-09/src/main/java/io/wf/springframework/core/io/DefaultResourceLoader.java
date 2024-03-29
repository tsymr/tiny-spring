package io.wf.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DefaultResourceLoader
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 10:38 AM
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASS_PATH_PREFIX)){
            return new ClassPathResource(location.substring(CLASS_PATH_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
