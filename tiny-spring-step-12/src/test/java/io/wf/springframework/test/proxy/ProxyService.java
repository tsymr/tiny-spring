package io.wf.springframework.test.proxy;

import java.util.Random;

/**
 * ProxyService
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/4/8 10:32 AM
 */
public class ProxyService implements IProxyService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Ts, 1001,杭州";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
