package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * DisposableBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 10:52 AM
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
