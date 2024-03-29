package io.wf.springframework.context.support;

import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * AbstractXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/29 11:12 AM
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            xmlBeanDefinitionReader.loadBeanDefinitions(getConfigLocations());
        }
    }

    protected abstract String[] getConfigLocations();
}
