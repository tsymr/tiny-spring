package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.Aware;

/**
 * ApplicationContextAware
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/2 2:03 PM
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
