package com.commsdk.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Destription:关于实体类的工具
 * @auther:lstreamlet
 * @date:2016/12/20
 */
public class BeanUtils {

    public static Map<String,String> beanToMap(Object object){
        Class c=object.getClass();
        Field[] fields=c.getDeclaredFields();
        Map<String,String> map=new HashMap<>();
        for (Field field : fields) {
            String name=field.getName();
            String value=getValue(object,name)+"";
            map.put(name,value);
        }
        return map;
    }
    public static Object getValue(Object object,String key) {
        String name="get"+key.substring(0,1).toUpperCase()+key.substring(1);
        try {
            Method method = object.getClass().getDeclaredMethod(name, new Class[0]);
            return method.invoke(object, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
