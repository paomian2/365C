package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  9:47
 * 版本：3.0
 */

public interface MyFollowView extends BaseView{
    /**获取商品关注列表*/
    public void getFavoriteProductList(Map<String,String> params);
    /**获取商品关注列表结果*/
    public void getFavoriteProductListResult(boolean success,String msg);
    /**获取店铺关注列表*/
    public void getFavoriteShopList(Map<String,String> params);
    /**获取店铺关注列表*/
    public void getFavoriteShopListResult(boolean success,String msg);
}
