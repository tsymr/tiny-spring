package io.wf.springframework.aop.framework;

/**
 * AopProxy
 * <p>
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy objects.
 * <p>
 * Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by DefaultAopProxyFactory
 * <p>
 * AOP 代理的抽象
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:47 AM
 */
public interface AopProxy {

    Object getProxy();
}
