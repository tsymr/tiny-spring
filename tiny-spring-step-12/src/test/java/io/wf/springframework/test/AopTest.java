package io.wf.springframework.test;

import io.wf.springframework.aop.AdvisedSupport;
import io.wf.springframework.aop.ClassFilter;
import io.wf.springframework.aop.MethodMatcher;
import io.wf.springframework.aop.TargetSource;
import io.wf.springframework.aop.aspectj.AspectJExpressionPointcut;
import io.wf.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import io.wf.springframework.aop.framework.ProxyFactory;
import io.wf.springframework.aop.framework.ReflectiveMethodInvocation;
import io.wf.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import io.wf.springframework.context.support.ClassPathXmlApplicationContext;
import io.wf.springframework.test.aop.AopUserService;
import io.wf.springframework.test.aop.AopUserServiceBeforeAdvice;
import io.wf.springframework.test.aop.AopUserServiceInterceptor;
import io.wf.springframework.test.aop.IAopUserService;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
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


    private AdvisedSupport advisedSupport;

    @Before
    public void init() {
        // 目标对象
        IAopUserService userService = new AopUserService();
        // 组装代理信息
        advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new AopUserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* io.wf.springframework.test.aop.IAopUserService.*(..))"));
    }

    @Test
    public void test_proxyFactory() {
        advisedSupport.setProxyTargetClass(false); // false/true，JDK动态代理、CGlib动态代理
        IAopUserService proxy = (IAopUserService) new ProxyFactory(advisedSupport).getProxy();

        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_beforeAdvice() {
        AopUserServiceBeforeAdvice beforeAdvice = new AopUserServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor interceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(interceptor);

        IAopUserService proxy = (IAopUserService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_advisor() {
        // 目标对象
        IAopUserService userService = new AopUserService();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* io.wf.springframework.test.aop.IAopUserService.*(..))");
        advisor.setAdvice(new MethodBeforeAdviceInterceptor(new AopUserServiceBeforeAdvice()));

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(userService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(userService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true); // false/true，JDK动态代理、CGlib动态代理

            IAopUserService proxy = (IAopUserService) new ProxyFactory(advisedSupport).getProxy();
            System.out.println("测试结果：" + proxy.queryUserInfo());
        }
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop.xml");

        IAopUserService userService = applicationContext.getBean("userService", IAopUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new AopUserService();

        // AOP 代理
        IAopUserService proxy = (IAopUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* io.wf.springframework.test.aop.IAopUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

}
