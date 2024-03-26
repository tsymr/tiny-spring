package io.wf.springframework.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BeanReference
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/26 10:59 AM
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BeanReference {
    private String beanName;
}
