package com.a365vintagewine.utils;
import android.content.Context;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.google.gson.Gson;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月19日  22:17
 * 版本：3.0
 */

public class SharePreferenceUtils2{


    /**获取Client_Id*/
    public static String getClient_Id(Context context){
        String userInfo=SharedPreferenceUtil.getInstance(context).getString(SharedPreferenceUtil.USERINFO);
        if (!StringUtils.isEmpty(userInfo)){
           UserBean user=new Gson().fromJson(userInfo, UserBean.class);
            return user.getClient_Id()+"";
        }
        return "";
    }

    /**获取Client_Id*/
    public static UserBean getBaseUser(Context context){
        String userInfo=SharedPreferenceUtil.getInstance(context).getString(SharedPreferenceUtil.USERINFO);
        if (!StringUtils.isEmpty(userInfo)){
            UserBean user=new Gson().fromJson(userInfo, UserBean.class);
            return user;
        }
        return null;
    }

    /**获取本地SignKey*/
    public static String getSignKey(Context context){
         return SharedPreferenceUtil.getInstance(context).getString(SharedPreferenceUtil.GetSignKey);
    }

}
