package io.wf.springframework.beans.factory;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.PropertyValue;
import io.wf.springframework.beans.PropertyValues;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.beans.factory.config.BeanFactoryPostProcessor;
import io.wf.springframework.core.io.DefaultResourceLoader;
import io.wf.springframework.core.io.Resource;
import io.wf.springframework.util.StringValueResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertyPlaceholderConfigurer
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 3:32 PM
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    private static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    private static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();

                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    value = resolvePlaceholder((String) value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            // 向容器中添加字符串解析器，供解析@Value注解使用
            StringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
            beanFactory.addEmbeddedValueResolver(valueResolver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuilder buffer = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
        }
        return buffer.toString();
    }


    public void setLocation(String location) {
        this.location = location;
    }

    private  class PlaceholderResolvingStringValueResolver implements StringValueResolver {
        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
