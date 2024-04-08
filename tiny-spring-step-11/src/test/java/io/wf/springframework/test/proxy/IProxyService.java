package io.wf.springframework.test.proxy;

/**
 * IProxyService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 10:31 AM
 */
public interface IProxyService {

    String queryUserInfo();

    String register(String userName);
}
