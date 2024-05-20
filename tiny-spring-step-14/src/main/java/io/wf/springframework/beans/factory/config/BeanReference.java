package io.wf.springframework.beans.factory.config;

import lombok.Getter;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/16 10:32 AM
 */
@Getter
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

}
