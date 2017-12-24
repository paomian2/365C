package com.a365vintagewine.mvp.model;
import com.commsdk.base.retrofit.ModelCallBack;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  2:48
 * 版本：3.0
 */

public class AdressModel extends BaseModel2{

    /**获取地址列表*/
    public void getAdressList(String userId, ModelCallBack modelCallBack){

    }

    /**删除地址*/
    public void deleteAdressRecord(String userId,ModelCallBack modelCallBack){
        modelCallBack.onSuccess(null);
    }
}
