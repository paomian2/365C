package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.view.MyWalletView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

/**
 * 我的钱包
 */

public class MyWalletPresenter extends BasePresenter<MyWalletView,UserModel> {

    public MyWalletPresenter(MyWalletView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }


    public void GetUserBasicInfo(String Client_Id){
        mModel.getBaseUserInfo(Client_Id, new ModelCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean model) {
                mView.GetUserBasicInfoResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetUserBasicInfoResult(false,msg,null);
            }
        });
    }
}
