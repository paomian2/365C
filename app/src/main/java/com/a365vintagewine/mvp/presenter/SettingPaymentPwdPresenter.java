package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.VerifyCodeBean;
import com.a365vintagewine.mvp.view.SettingPaymentPwdView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

public class SettingPaymentPwdPresenter extends BasePresenter<SettingPaymentPwdView,UserModel> {
    public SettingPaymentPwdPresenter(SettingPaymentPwdView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**判断原始支付密码是否正确*/
    public void verifyOldPayPwd(String Client_Id,String PayPwd){
         mModel.verifyOldPayPwd(Client_Id, PayPwd, new ModelCallBack<BaseResponse>() {
             @Override
             public void onSuccess(BaseResponse model) {
                  mView.verifyOldPayPwdResult(true,model.getMsg());
             }

             @Override
             public void onFailure(String msg) {
                 mView.verifyOldPayPwdResult(false,msg);
             }
         });
    }

    /**修改支付密码发送验证码*/
    public void sendPayPwdVerificationCode(String Client_Id,String Mobile){
        mModel.sendPayPwdVerificationCode(Client_Id, Mobile, new ModelCallBack<VerifyCodeBean>() {
            @Override
            public void onSuccess(VerifyCodeBean model) {
                mView.sendPayPwdVerificationCodeResult(true,"验证码已发送!");
            }

            @Override
            public void onFailure(String msg) {
                mView.sendPayPwdVerificationCodeResult(false,msg);
            }
        });
    }

    /**
     * 修改支付密码：校验验证码手机号是否正确
     * 修改密码发送验证码后第一步
     * */
    public void verifyCodeAndMoblie(String Client_Id,String Mobile,String VerificationCode){
        mModel.verifyCodeAndMoblie(Client_Id, Mobile, VerificationCode, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.verifyCodeAndMoblieResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.verifyCodeAndMoblieResult(false,msg);
            }
        });
    }

    /**设置支付密码或者修改支付密码，有原始支付密码的为修改密码*/
    public void setPayPwd(String Client_Id,String Mobile,String VerificationCode,String PayPwd,String ConfirmPayPwd){
         mModel.setPayPwd(Client_Id, Mobile, VerificationCode, PayPwd, ConfirmPayPwd, new ModelCallBack<BaseResponse>() {
             @Override
             public void onSuccess(BaseResponse model) {
                 mView.setPayPwdResult(true,model.getMsg());
             }

             @Override
             public void onFailure(String msg) {
                 mView.setPayPwdResult(false,msg);
             }
         });
    }
}
