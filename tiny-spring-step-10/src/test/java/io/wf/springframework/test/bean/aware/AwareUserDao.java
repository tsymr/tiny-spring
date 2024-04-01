package io.wf.springframework.test.bean.aware;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/28 2:27 PM
 */
public class AwareUserDao {


    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("1001", "Ts/.");
        hashMap.put("1002", "Ts");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String id) {
        return hashMap.get(id);
    }
}
