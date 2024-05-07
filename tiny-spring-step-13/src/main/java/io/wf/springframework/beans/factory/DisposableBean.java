package io.wf.springframework.beans.factory;

/**
 * DisposableBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:23 PM
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
