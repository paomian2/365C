package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.view.ForgetPasswordView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

/**
 * Created by Administrator on 2017/8/22 0022.
 */

public class ForgetPasswordPresenter extends BasePresenter<ForgetPasswordView, UserModel> {

    public ForgetPasswordPresenter(ForgetPasswordView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 忘记密码发送验证码
     * */
    public void sendForgotPwdVerificationCode(String Mobile){
        mModel.sendForgotPwdVerificationCode(Mobile, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                 mView.sendForgotPwdVerificationCodeResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                 mView.sendForgotPwdVerificationCodeResult(false,msg);
            }
        });
    }

    /**忘记密码第一步*/
    public void forgotPwdStepOne(String Mobile,String VerificationCode){
        mModel.forgotPwdStepOne(Mobile, VerificationCode, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.forgotPwdStepOneResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.forgotPwdStepOneResult(false,msg);
            }
        });
    }

    /**忘记密码第二步*/
    public void forgotPwdStepTwo(String Mobile,String NewPwd,String ConfirmPwd){
        mModel.forgotPwdStepTwo(Mobile, NewPwd, ConfirmPwd, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.forgotPwdStepTwoResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.forgotPwdStepTwoResult(false,msg);
            }
        });
    }
}
