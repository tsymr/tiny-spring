package io.wf.springframework.beans.factory;

/**
 * PropertyValue
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/10 10:11 AM
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
