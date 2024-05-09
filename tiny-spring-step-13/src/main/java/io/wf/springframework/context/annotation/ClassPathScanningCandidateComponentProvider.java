package io.wf.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import io.wf.springframework.beans.factory.config.BeanDefinition;
import io.wf.springframework.stereotype.Component;
import io.wf.springframework.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ClassPathScanningCandidateComponentProvider
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/9 9:51 AM
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
