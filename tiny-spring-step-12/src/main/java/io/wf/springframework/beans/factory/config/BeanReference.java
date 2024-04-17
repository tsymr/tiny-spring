package io.wf.springframework.beans.factory.config;

import lombok.Getter;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/10 10:18 AM
 */
@Getter
public class BeanReference {
    private final String benName;

    public BeanReference(String benName) {
        this.benName = benName;
    }
}
