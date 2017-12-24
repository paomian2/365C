package com.commsdk.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Destription:全局变量，用来传递数据使用
 * @auther:lstreamlet
 * @date:2017/3/6
 */
public class GlobalGuiSeariveUtils {

    private static Map<String, Object> hasp = new HashMap<>();

    public static void setGlobalGuiService(String key, String value) {
        synchronized (hasp) {
            hasp.put(key, value);
        }
    }


    public static Object getGlobalGuiService(String key){
        synchronized (hasp){
            return hasp.get(key);
        }
    }


}
