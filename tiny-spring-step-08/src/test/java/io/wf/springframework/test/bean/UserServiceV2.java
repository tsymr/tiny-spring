package io.wf.springframework.test.bean;

import io.wf.springframework.beans.factory.DisposableBean;
import io.wf.springframework.beans.factory.InitializingBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserServiceV2
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 2:36 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceV2 implements InitializingBean, DisposableBean {
    private String id;
    private String company;
    private String location;
    private UserDaoV2 userDaoV2;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String queryUserInfo() {
        return userDaoV2.queryUserName(id) + ", 公司：" + company + ", 地点：" + location;
    }

}
