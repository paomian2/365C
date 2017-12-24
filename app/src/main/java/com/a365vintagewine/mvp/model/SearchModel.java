package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.QueryVendorParams;
import com.a365vintagewine.mvp.model.response.QueryVendorResponse;
import com.a365vintagewine.utils.ProtocolSendParamsUtils;
import com.commsdk.base.retrofit.ApiCallback;
import com.commsdk.base.retrofit.BaseRequesBody;
import com.commsdk.base.retrofit.ModelCallBack;
import com.google.gson.Gson;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SearchModel extends BaseModel2 {

    /**搜索首页附近商家*/
    public void QueryVendor(QueryVendorParams params, final ModelCallBack modelCallBack){
        //ProtocolSendParamsUtils.paramsEdit(params,"QueryVendor");
        String requestBody=new Gson().toJson(params);
        addSubscription(apiStore.QueryVendor(RequestBody.create(MediaType.parse("application/json"),requestBody)), new ApiCallback<QueryVendorResponse>() {
            @Override
            public void onSuccess(QueryVendorResponse model) {
                if(model.getData()!=null){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }





}
