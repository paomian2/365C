package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.view.AdressEditView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月27日  17:29
 * 版本：3.0
 */

public class AdressEditPresenter extends BasePresenter<AdressEditView,UserModel>{

    public AdressEditPresenter(AdressEditView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**添加收货人地址*/
    public void AddUserAddress(Map<String,Object> params){
          mModel.addUserAddress(params, new ModelCallBack<BaseResponse>() {
              @Override
              public void onSuccess(BaseResponse model) {
                   mView.addUserAddressResult(true,model.getMsg());
              }

              @Override
              public void onFailure(String msg) {
                  mView.addUserAddressResult(false,msg);
              }
          });
    }

    /**编辑地址*/
    public void editUserAddress(Map<String,Object> params){
        mModel.editUserAddress(params, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.editUserAddressResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.editUserAddressResult(false,msg);
            }
        });
    }




}
