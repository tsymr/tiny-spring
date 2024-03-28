package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;

/**
 * InitializingBean
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 4:01 PM
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
