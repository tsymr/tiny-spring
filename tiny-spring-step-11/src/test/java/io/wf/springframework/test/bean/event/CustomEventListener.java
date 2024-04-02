// package io.wf.springframework.test.bean.event;
//
// import io.wf.springframework.context.ApplicationListener;
//
// import java.util.Date;
//
// /**
//  * CustomEventListener
//  *
//  * @author Ts
//  * @version 1.0.0
//  * @date 2024/4/2 10:11 AM
//  */
// public class CustomEventListener implements ApplicationListener<CustomEvent> {
//     @Override
//     public void onApplicationEvent(CustomEvent event) {
//         System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
//         System.out.println("消息：" + event.getId() + ":" + event.getMessage());
//
//     }
// }
