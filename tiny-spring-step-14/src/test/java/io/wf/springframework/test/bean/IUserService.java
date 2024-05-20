package io.wf.springframework.test.bean;

/**
 * bean.IUserService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/5/20 3:30 PM
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);
}
