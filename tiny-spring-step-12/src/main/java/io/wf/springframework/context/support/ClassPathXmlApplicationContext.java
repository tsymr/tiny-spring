package io.wf.springframework.context.support;

import io.wf.springframework.context.event.AbstractXmlApplicationContext;

/**
 * ClassPathXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/17 2:51 PM
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String location) {
        this(new String[]{location});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    public String[] getConfigLocations() {
        return configLocations;
    }
}
