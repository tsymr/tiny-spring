package io.wf.springframework.beans.factory;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:24 AM
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
