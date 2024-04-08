package io.wf.springframework.aop.framework;

/**
 * AopProxy
 *
 * 标准接口，用于获取代理类。因为具体实现代理的方式可以有 JDK 方式，也可以是 Cglib 方式，所以定义接口会更加方便管理实现类。
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 10:53 AM
 */
public interface AopProxy {

    Object getProxy();
}
