package io.wf.springframework.beans;

/**
 * BeansExceptions
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/6 3:11 PM
 */
public class BeansException extends RuntimeException {

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(String message) {
        super(message);
    }
}
