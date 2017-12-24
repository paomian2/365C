package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

import retrofit2.http.PUT;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月24日  15:28
 * 版本：3.0
 */

public interface LaunchView extends BaseView{

    public static final int GUIDE=0;
    public static final int LOGIN=1;
    public static final int HOME=2;
    public void activityStart(int flag);
    //获取GetSignKey
    public void getSignKey();
    //获取结果
    public void getSignKeyResult(boolean success,String msg);


}
