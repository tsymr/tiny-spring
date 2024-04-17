package io.wf.springframework.context;

import io.wf.springframework.beans.factory.HierarchicalBeanFactory;
import io.wf.springframework.beans.factory.ListableBeanFactory;
import io.wf.springframework.core.io.ResourceLoader;

/**
 * ApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 11:21 AM
 */
public interface ApplicationContext extends ListableBeanFactory, ResourceLoader, HierarchicalBeanFactory, ApplicationEventPublisher {
}
