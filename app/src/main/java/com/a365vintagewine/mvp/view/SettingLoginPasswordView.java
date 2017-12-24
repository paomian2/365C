package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public interface SettingLoginPasswordView extends BaseView {

    /**修改登录密码*/
    public void updateUserPwd(String Client_Id, String OrgPwd, String NewPwd, String ConfirmPwd);
    /**修改登录密码结果*/
    public void updateUserPwdResult(boolean success,String msg);
}
