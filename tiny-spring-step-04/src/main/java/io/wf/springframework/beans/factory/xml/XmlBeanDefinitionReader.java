package io.wf.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.PropertyValue;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanReference;
import io.wf.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import io.wf.springframework.beans.factory.support.BeanDefinitionRegistry;
import io.wf.springframework.core.io.Resource;
import io.wf.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinition(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    private void doLoadBeanDefinition(InputStream inputStream) throws ClassNotFoundException {

        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            Element bean = (Element) childNodes.item(i);

            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isBlank(id) ? name : id;
            if (StrUtil.isBlank(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)){
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())){
                    continue;
                }
                Element property = (Element) bean.getChildNodes().item(j);

                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef  = property.getAttribute("ref");

                Object value = StrUtil.isBlank(attrRef) ? attrValue : new BeanReference(attrRef);
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
