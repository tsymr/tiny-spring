package io.wf.springframework.beans.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PropertyValue
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 10:55 AM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue {

    private String name;
    private Object value;
}
