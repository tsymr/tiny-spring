package io.wf.springframework.aop.aspectj;

import io.wf.springframework.aop.Pointcut;
import io.wf.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * AspectJExpressionPointcutAdvisor
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/18 2:56 PM
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut){
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
