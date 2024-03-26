package io.wf.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 10:56 AM
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    public PropertyValue getPropertyValue(String name){
        for (PropertyValue propertyValue : this.propertyValues) {
            if (propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValues.toArray(new PropertyValue[0]);
    }
}
