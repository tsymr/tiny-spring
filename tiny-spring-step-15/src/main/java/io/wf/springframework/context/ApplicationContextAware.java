package io.wf.springframework.context;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.Aware;

/**
 * Interface to be implemented by any object that wishes to be notified
 * of the {@link ApplicationContext} that it runs in.
 *
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 *
 *
 *
 *
 *
 * 
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
    