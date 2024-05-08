package io.wf.springframework.aop.framework;

import io.wf.springframework.aop.AdvisedSupport;

/**
 * ProxyFactory
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 3:00 PM
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy(){
        if (advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
