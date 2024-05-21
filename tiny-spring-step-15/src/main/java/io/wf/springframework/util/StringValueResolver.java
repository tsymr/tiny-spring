package io.wf.springframework.util;

import io.wf.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link ConfigurableBeanFactory}.
 * <p>
 *
 *
 *
 *
 *
 * 
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
