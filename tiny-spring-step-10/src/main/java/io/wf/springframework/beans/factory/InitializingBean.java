package io.wf.springframework.beans.factory;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 9:42 AM
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
