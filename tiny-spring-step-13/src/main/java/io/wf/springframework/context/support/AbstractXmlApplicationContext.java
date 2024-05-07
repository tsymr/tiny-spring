package io.wf.springframework.context.support;

import io.wf.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.wf.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * AbstractXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/7 3:52 PM
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
