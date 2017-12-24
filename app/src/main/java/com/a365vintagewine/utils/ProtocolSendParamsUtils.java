package com.a365vintagewine.utils;
import com.a365vintagewine.AppApplication;
import com.a365vintagewine.mvp.model.bean.QueryParams;
import com.commsdk.common.PhoneUtil;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.common.TimeUtil;

import java.util.Map;

/**
 * 描述：添加默认的参数
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月27日  16:35
 * 版本：3.0
 */

public class ProtocolSendParamsUtils {

    /**普通参数*/
    public static void paramsEdit(Map<String,Object> params,String Method){
        String signKey= SharedPreferenceUtil.getInstance(AppApplication.getInstance()).getString(SharedPreferenceUtil.GetSignKey);
        params.put("FromClient", "android");
        params.put("PlatformAccount", "android");
        params.put("AccessToken", "");
        params.put("TimeStamp", TimeUtil.getNowTime("yyyy-MM-dd hh:mm:ss"));
        params.put("Ver", "v1.0");
        params.put("DeviceIMEINumber", PhoneUtil.getInstance(AppApplication.getInstance()).getIMEI());
        String sigh = StringUtils.signTopRequest(params,signKey);
        params.put("Sign", sigh);
        params.put("Method",Method);
        params.put("SignKeyToken", signKey);
    }

}
