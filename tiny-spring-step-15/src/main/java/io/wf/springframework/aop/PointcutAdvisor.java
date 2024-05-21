package io.wf.springframework.aop;

/**
 * PointcutAdvisor
 * <p>
 * 由切入点驱动的所有 Advisor 的超级接口。
 * 这涵盖了除介绍顾问之外的几乎所有顾问，
 * 方法级匹配不适用。
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:15 AM
 */
public interface PointcutAdvisor extends Advisor {


    Pointcut getPointcut();
}
