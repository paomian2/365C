package com.commsdk.base.retrofit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class BaseRequesBody {

    /**
     * 将map集合转化为json串
     */
    public static RequestBody setJsonString(Map<String,Object> body){
        Set keys = body.keySet( );
        JSONObject requestData = new JSONObject();
        if(keys != null) {
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                Object value = body.get(key);
                try {
                    requestData.put((String) key,value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return RequestBody.create(MediaType.parse("application/json"),requestData.toString());
    }
}
