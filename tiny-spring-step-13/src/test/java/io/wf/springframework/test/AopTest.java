package io.wf.springframework.test;


import io.wf.springframework.aop.AdvisedSupport;
import io.wf.springframework.aop.MethodMatcher;
import io.wf.springframework.aop.TargetSource;
import io.wf.springframework.aop.appectj.AspectJExpressionPointcut;
import io.wf.springframework.aop.framework.Cglib2AopProxy;
import io.wf.springframework.aop.framework.JdkDynamicAopProxy;
import io.wf.springframework.aop.framework.ReflectiveMethodInvocation;
import io.wf.springframework.test.proxy.IProxyService;
import io.wf.springframework.test.proxy.ProxyService;
import io.wf.springframework.test.proxy.ProxyServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AopTest
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 3:22 PM
 */
public class AopTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.ProxyService.*(..))");
        Class<ProxyService> clazz = ProxyService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));

        // true、true
    }

    @Test
    public void test_proxy_method() {
        Object targetObj = new ProxyService();
        IProxyService proxy = (IProxyService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {

            // 方法匹配
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.IProxyService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin by AOP");
                            System.out.println("方法名称: " + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_dynamic() {
        IProxyService proxyService = new ProxyService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(proxyService));
        advisedSupport.setMethodInterceptor(new ProxyServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* io.wf.springframework.test.proxy.IProxyService.*(..))"));

        IProxyService proxy_jdk = (IProxyService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo() + "\r\n");

        // 代理对象(Cglib2AopProxy)
        IProxyService proxy_cglib = (IProxyService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
