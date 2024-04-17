package io.wf.springframework.beans;

/**
 * BeansException
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/10 10:03 AM
 */
public class BeansException extends RuntimeException{
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
