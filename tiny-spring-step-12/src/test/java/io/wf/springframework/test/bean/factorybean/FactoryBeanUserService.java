package io.wf.springframework.test.bean.factorybean;

import lombok.Getter;
import lombok.Setter;

/**
 * UserService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/29 2:20 PM
 */
@Getter
@Setter
public class FactoryBeanUserService {

    private String id;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryUserInfo(){
        return  userDao.queryUserName(id) + ", " + company + ", " + location;
    }
}
