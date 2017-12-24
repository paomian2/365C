package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;


public interface ForgetPasswordView extends BaseView {

    //忘记密码发送验证码
    void sendForgotPwdVerificationCode(String Mobile);
    //忘记密码发送验证码结果回调
    void sendForgotPwdVerificationCodeResult(boolean success,String msg);
    //找回密码第一步
    void forgotPwdStepOne(String Mobile,String VerificationCode);
    //找回密码结果
    void forgotPwdStepOneResult(boolean success,String msg);
    //找回密码第二步
    void forgotPwdStepTwo(String Mobile,String NewPwd,String ConfirmPwd);
    //找回密码第二步结果回调
    void forgotPwdStepTwoResult(boolean success,String msg);
}
