package io.wf.springframework.test;

import io.wf.springframework.context.support.ClassPathXmlApplicationContext;
import io.wf.springframework.test.bean.IUserService;
import org.junit.Test;

/**
 * ApiTest
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/21 2:23 PM
 */
public class ApiTest {

    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
