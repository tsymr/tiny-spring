package io.wf.springframework.beans.factory;

/**
 * DisposableBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:27 PM
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
