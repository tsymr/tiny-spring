package io.wf.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDaoV2
 *
 * @author Ts
 * @version 1.0.0
 * @date 2024/3/27 2:35 PM
 */
public class UserDaoV2 {

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

    public String  queryUserName(String id){
        return hashMap.get(id);
    }


}
