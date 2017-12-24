package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月11日  9:37
 * 版本：3.0
 */

public interface LoginView extends BaseView {

    /**获取用户名*/
    public String getUserName();
    /**获取密码*/
    public String getUserPwd();
    /**用户登录成功结果回调*/
    public void loginSuccess();
    /**用户登录失败结果回调*/
    public void loginFailuer(String msg);

}
