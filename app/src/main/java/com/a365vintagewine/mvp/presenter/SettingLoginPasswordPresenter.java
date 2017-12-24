package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.SettingLoginPasswordModel;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.view.SettingLoginPasswordView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class SettingLoginPasswordPresenter extends BasePresenter<SettingLoginPasswordView,UserModel> {
    public SettingLoginPasswordPresenter(SettingLoginPasswordView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**更新登录密码*/
    public void updateUserPwd(String Client_Id, String OrgPwd, String NewPwd, String ConfirmPwd){
        mModel.updateUserPwd(Client_Id, OrgPwd, NewPwd, ConfirmPwd, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.updateUserPwdResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
               mView.updateUserPwdResult(false,msg);
            }
        });
    }
}
