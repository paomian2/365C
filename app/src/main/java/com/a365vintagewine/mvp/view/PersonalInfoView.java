package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.UserBean;
import com.commsdk.base.view.BaseView;

/**
 * 个人信息
 */

public interface PersonalInfoView extends BaseView {

    //获取用户基本信息
    void getBaseUserInfo(String Client_Id);
    //获取用户信息结果
    void  getBaseUserInfoResult(boolean success, UserBean user, String msg);
    /**修改用户头像*/
    void updateUserHeadImage(String Client_Id,String Base64UserHeadImgUrl,String UpLoadFileStr);
    /**修改用户头像结果*/
    void updateUserHeadImageResult(boolean success,String msg);
}
