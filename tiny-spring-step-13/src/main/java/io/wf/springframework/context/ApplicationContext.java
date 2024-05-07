package io.wf.springframework.context;

import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.HierarchicalBeanFactory;
import io.wf.springframework.beans.factory.ListableBeanFactory;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * ApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:09 PM
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
