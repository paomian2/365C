package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.commsdk.base.view.BaseView;

/**
 * 我的主页
 */

public interface MyselfView extends BaseView {

    //获取用户基本信息
    void getBaseUserInfo(String Client_Id);
    //获取用户信息结果
    void  getBaseUserInfoResult(boolean success, UserBean user, String msg);
}
