package io.wf.springframework.beans;

/**
 * PropertyValue
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:20 AM
 */
public class PropertyValue {

    private final String name;

    private final Object value;

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
