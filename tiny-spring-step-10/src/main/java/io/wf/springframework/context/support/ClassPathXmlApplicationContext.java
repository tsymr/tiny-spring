package io.wf.springframework.context.support;

/**
 * ClassPathXmlApplicationContext
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/1 10:55 AM
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private  String[] configLocations;

    public ClassPathXmlApplicationContext(){

    }

    public ClassPathXmlApplicationContext(String configLocation){
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations){
        this.configLocations = configLocations;
        refresh();
    }




    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}
