package io.wf.springframework.aop;

/**
 * TargetSource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 3:43 PM
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 获取目标类的所有接口
     * @return
     */
    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
