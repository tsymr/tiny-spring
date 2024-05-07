package io.wf.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:12 PM
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues = new ArrayList<>();


    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }
}
