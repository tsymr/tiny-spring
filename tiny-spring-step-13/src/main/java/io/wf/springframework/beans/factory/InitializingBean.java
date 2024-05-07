package io.wf.springframework.beans.factory;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:23 PM
 */
public interface InitializingBean {

    void afterPropertiesSet();
}
