package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.a365vintagewine.mvp.model.AdressModel;
import com.a365vintagewine.mvp.view.AdressHomeView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  2:48
 * 版本：3.0
 */

public class AdressHomePresenter extends BasePresenter<AdressHomeView,UserModel>{

    public AdressHomePresenter(AdressHomeView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**获取地址列表*/
    public void getAdressList(String userId,int page,int size){
        mModel.getUserAddress(userId,page+"",size+"", new ModelCallBack<List<AdressBean>>() {
            @Override
            public void onSuccess(List<AdressBean> model) {
                mView.onGetAdressListResult(true,model,"加载成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.onGetAdressListResult(false,null,msg);
            }
        });
    }

    /**删除地址*/
    public void delUserAddress(Map<String,Object> params){
        mModel.delUserAddress(params, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.onDeleteAdressRecordResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.onDeleteAdressRecordResult(false,msg);
            }
        });
    }

}
