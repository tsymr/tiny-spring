package io.wf.springframework.test.bean;

import io.wf.springframework.beans.factory.annotation.Autowired;
import io.wf.springframework.beans.factory.annotation.Value;
import io.wf.springframework.stereotype.Component;

import java.util.Random;

/**
 * bean.UserService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 3:30 PM
 */
@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;


    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + "，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
