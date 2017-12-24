package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.view.PersonalInfoView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.module.response.base.BaseResponse;
import com.google.gson.Gson;

public class PersonalInfoPresenter extends BasePresenter<PersonalInfoView,UserModel> {
    public PersonalInfoPresenter(PersonalInfoView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**修改用户头像*/
    public void updateUserHeadImage(String Client_Id,String Base64UserHeadImgUrl,String UpLoadFileStr){
          mModel.updateHeadImage(Client_Id, Base64UserHeadImgUrl, UpLoadFileStr, new ModelCallBack<BaseResponse>() {
              @Override
              public void onSuccess(BaseResponse model) {
                  mView.updateUserHeadImageResult(true,"修改成功！");
              }

              @Override
              public void onFailure(String msg) {
                  mView.updateUserHeadImageResult(false,msg);
              }
          });
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
