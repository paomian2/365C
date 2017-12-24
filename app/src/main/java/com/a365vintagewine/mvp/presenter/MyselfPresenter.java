package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.view.MyselfView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.google.gson.Gson;

/**
 * 我的主页
 */

public class MyselfPresenter extends BasePresenter<MyselfView,UserModel> {
    public MyselfPresenter(MyselfView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }


    /**获取用户基本信息*/
    public void getBaseUserInfo(String Client_Id){
        mModel.getBaseUserInfo(Client_Id, new ModelCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean model) {
                String userInfo=new Gson().toJson(model);
                SharedPreferenceUtil.getInstance(mView.getMyContext()).putString(SharedPreferenceUtil.USERINFO,userInfo);
                mView.getBaseUserInfoResult(true,model,"获取用户信息成功！");
            }

            @Override
            public void onFailure(String msg) {
                mView.getBaseUserInfoResult(false,null,msg);
            }
        });
    }
}
