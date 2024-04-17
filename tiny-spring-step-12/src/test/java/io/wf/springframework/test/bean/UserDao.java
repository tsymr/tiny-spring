package io.wf.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "Ts/.");
        hashMap.put("1002", "Ts");
    }

    public String  queryUserName(String id){
        return hashMap.get(id);
    }
}
