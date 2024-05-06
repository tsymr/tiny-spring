package io.wf.springframework.aop;

/**
 * TargetSource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 2:17 PM
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
