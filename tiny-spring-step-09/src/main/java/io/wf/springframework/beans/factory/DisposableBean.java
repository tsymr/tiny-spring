package io.wf.springframework.beans.factory;

/**
 * DisposableBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 3:15 PM
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
