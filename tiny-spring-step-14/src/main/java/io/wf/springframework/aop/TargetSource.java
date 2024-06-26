package io.wf.springframework.aop;

/**
 * TargetSource
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 10:04 AM
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 获取类所实现的所有就饿口
     * @return
     */
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }


    public Object getTarget(){
        return this.target;
    }
}
