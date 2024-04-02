// package io.wf.springframework.test.bean.event;
//
// import io.wf.springframework.context.event.ApplicationContextEvent;
// import lombok.Getter;
// import lombok.Setter;
//
// /**
//  * CustomEvent
//  *
//  * @author Ts
//  * @version 1.0.0
//  * @date 2024/4/2 10:10 AM
//  */
// @Getter
// @Setter
// public class CustomEvent extends ApplicationContextEvent {
//
//     private Long id;
//     private String message;
//
//     /**
//      * Constructs a prototypical Event.
//      *
//      * @param source The object on which the Event initially occurred.
//      * @throws IllegalArgumentException if source is null.
//      */
//     public CustomEvent(Object source, Long id, String message) {
//         super(source);
//         this.id = id;
//         this.message = message;
//     }
//
// }
//
