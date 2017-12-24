package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.view.MyFollowView;
import com.commsdk.base.presenter.BasePresenter;

import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  9:48
 * 版本：3.0
 */

public class MyFollowPresenter extends BasePresenter<MyFollowView,UserModel>{

    public MyFollowPresenter(MyFollowView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**获取商品关注列表*/
    public void getFavoriteProductList(Map<String,String> params){

    }

    /**获取店铺关注列表*/
    public void getFavoriteShopList(Map<String,String> params){

    }
}
