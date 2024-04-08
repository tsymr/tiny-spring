package io.wf.springframework.beans.factory;

/**
 * DisposableBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 11:14 AM
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
