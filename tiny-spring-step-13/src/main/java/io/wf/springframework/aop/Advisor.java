package io.wf.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * Advisor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 2:54 PM
 */
public interface Advisor {

    Advice getAdvice();
}
