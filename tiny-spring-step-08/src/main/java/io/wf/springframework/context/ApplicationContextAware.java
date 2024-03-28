package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.Aware;

/**
 * AppilcationContextAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 2:19 PM
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
