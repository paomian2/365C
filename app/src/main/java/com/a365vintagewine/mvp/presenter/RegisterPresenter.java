package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.model.bean.VerifyCodeBean;
import com.a365vintagewine.mvp.view.RegisterView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.module.response.base.BaseResponse;
import com.google.gson.Gson;

public class RegisterPresenter extends BasePresenter<RegisterView, UserModel> {

    public RegisterPresenter(RegisterView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 发送验证码
     */
    public void sendVerifyCode(String phoneNo) {
        mModel.sendVerifyCode(phoneNo, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.sendVerificationCodeResult(true, model);
            }

            @Override
            public void onFailure(String msg) {
                mView.sendVerificationCodeResult(false, msg);
            }
        });
    }

    /**
     * 校验验证码用户信息
     * */
    public void verifyCodeAndUserMobile(String Mobile,String VerificationCode){
        mModel.verifyCodeAndUserMobile(Mobile, VerificationCode, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                 mView.verifyCodeAndUserMobileResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.verifyCodeAndUserMobileResult(false,msg);
            }
        });
    }


    /**
     * 用户注册
     */
    public void register(String phoneNo, String VerificationCode, String InvitationCode, String Pwd) {
        mModel.register(phoneNo, VerificationCode, InvitationCode, Pwd, new ModelCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean model) {
                SharedPreferenceUtil.getInstance(mView.getMyContext()).putString(SharedPreferenceUtil.USERINFO, new Gson().toJson(model));
                mView.registerResult(true, "注册成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.registerResult(false, "注册失败！");
            }
        });
    }

}
