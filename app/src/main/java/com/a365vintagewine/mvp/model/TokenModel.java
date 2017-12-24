package com.a365vintagewine.mvp.model;

import com.a365vintagewine.AppApplication;
import com.a365vintagewine.mvp.model.response.SignKeyResponse;
import com.commsdk.base.retrofit.ApiCallback;
import com.commsdk.base.retrofit.BaseRequesBody;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月26日  17:52
 * 版本：3.0
 */

public class TokenModel extends BaseModel2{

    /**获取signKey*/
    public void getSignKey(final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("PlatformName","苹果");
        params.put("PlatformAccount","ios");
        params.put("PlatformAccountPwd","wENU3g7v7KLQsgih");
        params.put("InterfaceVersion","v1.0");
        addSubscription(apiStore.getSignKey(BaseRequesBody.setJsonString(params)), new ApiCallback<SignKeyResponse>() {
            @Override
            public void onSuccess(SignKeyResponse model) {
                if (model.isResult() && model.getData()!=null){
                    //将signkey存本地
                    SharedPreferenceUtil.getInstance(AppApplication.getInstance()).putString(SharedPreferenceUtil.GetSignKey,model.getData().getSignKey_Token());
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
