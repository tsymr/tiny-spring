package io.wf.springframework.test.bean.event;

import io.wf.springframework.context.ApplicationListener;
import io.wf.springframework.context.event.ContextCloseEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextCloseEvent> {

    @Override
    public void onApplicationEvent(ContextCloseEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
