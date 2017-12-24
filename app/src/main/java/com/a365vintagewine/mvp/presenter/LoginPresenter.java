package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.model.LoginModel;
import com.a365vintagewine.mvp.view.LoginView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.google.gson.Gson;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月11日  9:36
 * 版本：3.0
 */

public class LoginPresenter extends BasePresenter<LoginView, UserModel> {

    public LoginPresenter(LoginView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 用户登录：
     * 从服务器获取该用户注册的环信信息，如果没有则注册环信信息，然后更新到服务器上
     * 如果有则用该用户信息进行环信登录
     */
    public void login() {
        mModel.login(mView.getUserName(), mView.getUserPwd(), new ModelCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean model) {
                String userInfo = new Gson().toJson(model);
                SharedPreferenceUtil.getInstance(mView.getMyContext()).putString(SharedPreferenceUtil.USERINFO, userInfo);
                mView.loginSuccess();
            }

            @Override
            public void onFailure(String msg) {
                mView.loginFailuer(msg);
            }
        });
    }

}
