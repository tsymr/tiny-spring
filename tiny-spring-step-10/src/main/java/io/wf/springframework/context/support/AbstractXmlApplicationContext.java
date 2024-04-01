package io.wf.springframework.context.support;

import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * AbstractXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 10:52 AM
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableBeanFactory{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
