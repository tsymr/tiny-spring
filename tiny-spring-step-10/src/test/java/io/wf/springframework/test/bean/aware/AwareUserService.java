package io.wf.springframework.test.bean.aware;

import io.wf.springframework.beans.BeansException;
import io.wf.springframework.beans.factory.BeanClassLoaderAware;
import io.wf.springframework.beans.factory.BeanFactory;
import io.wf.springframework.beans.factory.BeanFactoryAware;
import io.wf.springframework.beans.factory.BeanNameAware;
import io.wf.springframework.context.ApplicationContext;
import io.wf.springframework.context.ApplicationContextAware;
import lombok.Getter;
import lombok.Setter;

/**
 * AwareUserService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 2:27 PM
 */
@Setter
@Getter
public class AwareUserService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String id;
    private String company;
    private String location;
    private AwareUserDao awareUserDao;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);

    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String queryUserInfo() {
        return awareUserDao.queryUserName(id) + ", 公司：" + company + ", 地点：" + location;
    }

}
