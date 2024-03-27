package io.wf.springframework.context.support;

/**
 * ClassPathXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 11:35 AM
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext(){

    }

    public ClassPathXmlApplicationContext(String location){
        this(new String[]{location});
    }
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
