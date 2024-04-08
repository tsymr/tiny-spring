package io.wf.springframework.beans.factory;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 11:15 AM
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
