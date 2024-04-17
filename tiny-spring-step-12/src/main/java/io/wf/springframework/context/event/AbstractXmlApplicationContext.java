package io.wf.springframework.context.event;

import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import io.wf.springframework.context.support.AbstractRefreshableApplicationContext;

/**
 * AbstractXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:49 PM
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    protected abstract String[] getConfigLocations();

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
}
