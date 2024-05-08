package io.wf.springframework.aop;

/**
 * PointcutAdvisor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 2:55 PM
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut  getPointcut();
}
