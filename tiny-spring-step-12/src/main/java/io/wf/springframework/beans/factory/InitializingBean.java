package io.wf.springframework.beans.factory;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/16 2:27 PM
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
