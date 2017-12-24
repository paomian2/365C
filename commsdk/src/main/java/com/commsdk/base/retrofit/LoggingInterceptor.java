package com.commsdk.base.retrofit;
import com.commsdk.common.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

/**
 * 描述：网络请求拦截器,主要用于打印日志调试
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月13日  15:58
 * 版本：3.0
 */

public class LoggingInterceptor implements Interceptor {

    /**
     * 在调用了response.body().string()方法之后，
     * response中的流会被关闭，
     * 我们需要创建出一个新的response给应用层处理
     */

    public static String TAG = "LogInterceptor";

    @Override
    public okhttp3.Response intercept(Chain chain){
        Request originalRequest  = chain.request();
        try{
            //请求url
            String requestURL = originalRequest .url().toString();
            Request request = null;
            long startTime = System.currentTimeMillis();
            LogUtil.d(TAG, "\n");
            LogUtil.d(TAG, "----------Start----------------");
            LogUtil.d(TAG, "| " + requestURL);
            String method = originalRequest .method();
            if ("POST".equals(method)) {
                StringBuilder sb = new StringBuilder();
                if (originalRequest.body() instanceof FormBody) {
                    FormBody body = (FormBody) originalRequest.body();
                    for (int i = 0; i < body.size(); i++) {
                        sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                    LogUtil.d(TAG, "| RequestParams:{" + sb.toString() + "}");
                } else {
                    Buffer buffer = new Buffer();
                    originalRequest.body().writeTo(buffer);
                    String oldParamsJson = buffer.readUtf8();
                    HashMap rootMap = new Gson().fromJson(oldParamsJson, HashMap.class);  //原始参数
                    String[] temp=requestURL.split("/");
                    String methodName=temp[temp.length-1];
//                    if (!"GetSignKey".equals(methodName)){
//                        //------开始添加签名参数
//                        String signKey= SharedPreferenceUtil.getInstance(AppApplication.getInstance()).getString(SharedPreferenceUtil.GetSignKey);
//                        rootMap.put("FromClient", "android");
//                        rootMap.put("PlatformAccount", "android");
//                        rootMap.put("AccessToken", "");
//                        rootMap.put("TimeStamp", TimeUtil.getNowTime("yyyy-MM-dd hh:mm:ss"));
//                        rootMap.put("Ver", "v1.0");
//                        rootMap.put("DeviceIMEINumber", PhoneUtil.getInstance(AppApplication.getInstance()).getIMEI());
//                        String sigh = StringUtils.signTopRequest(rootMap,signKey);
//                        rootMap.put("Sign", sigh);
//                        rootMap.put("Method",methodName);
//                        rootMap.put("SignKeyToken", signKey);
//                        //------添加签名参数结束
//                    }
                    String newJsonParams =new Gson().toJson(rootMap);  //装换成json字符串
                     request = originalRequest.newBuilder().post(RequestBody.create(MediaType.parse("application/json; " +
                            "charset=utf-8"), newJsonParams)).header("Content-Type", "application/json").build();
                    LogUtil.d(TAG, "| RequestParams:" + newJsonParams);
                }
            }else{
                request=originalRequest;
            }
            okhttp3.Response response = chain.proceed(request);//释放拦截，进行网络访问
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            if (false){
                okhttp3.MediaType mediaType = response.body().contentType();
                String content=response.body().string();
                LogUtil.d(TAG, "| Response:" + content);
                LogUtil.d(TAG, "----------End:" + duration + "毫秒----------");
                return response.newBuilder()
                        .body(okhttp3.ResponseBody.create(mediaType, content))
                        .build();
            }else{
                return response;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
