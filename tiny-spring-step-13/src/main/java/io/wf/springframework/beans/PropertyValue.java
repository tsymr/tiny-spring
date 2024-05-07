package io.wf.springframework.beans;

/**
 * PropertyValue
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:12 PM
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

    public Object getValue() {
        return value;
    }
}
