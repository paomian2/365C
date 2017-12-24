package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public interface SettingPaymentPwdView extends BaseView {
     /**验证原始支付密码是否正确*/
     void verifyOldPayPwd(String Client_Id,String PayPwd);
    /**验证原始支付密码是否正确结果*/
    void verifyOldPayPwdResult(boolean success,String msg);
    /**校验验证码支付密码是否正确*/
    void verifyCodeAndMoblie(String Client_Id,String Mobile,String VerificationCode);
    /**校验验证码支付密码是否正确 结果回调*/
    void verifyCodeAndMoblieResult(boolean success,String msg);
    /**设置密码（修改密码）*/
    void setPayPwd(String Client_Id,String Mobile,String VerificationCode,String PayPwd,String ConfirmPayPwd);
    /**设置密码结果（修改密码）*/
    void setPayPwdResult(boolean success,String msg);
    /**支付密码设置发送验证码*/
    void sendPayPwdVerificationCode(String Client_Id,String Mobile);
    /**支付密码设置发送验证码结果*/
    void sendPayPwdVerificationCodeResult(boolean success,String msg);

}
