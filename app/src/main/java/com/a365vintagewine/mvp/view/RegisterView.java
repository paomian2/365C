package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;


public interface RegisterView extends BaseView {

    //发送验证码
    public void sendVerificationCode(String phoneNo);
    //获取验证码结果
    public void sendVerificationCodeResult(boolean success,String msg);
    //校验验证码及手机号
    public void verifyCodeAndUserMobile(String Mobile,String VerificationCode);
    //校验验证码及手机号结果
    public void verifyCodeAndUserMobileResult(boolean success,String msg);
    //用户注册
    public void register(String phoneNo, String VerificationCode, String InvitationCode, String Pwd);
    //用户注册结果
    public void registerResult(boolean success,String msg);

}
