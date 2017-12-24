package com.a365vintagewine.mvp.view.goods;

import com.a365vintagewine.mvp.model.bean.ProductInfoBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.commsdk.base.view.BaseView;

import java.util.List;
import java.util.Map;

public interface GoodsDetailView  extends BaseView {

    /**获取商品基本信息*/
    void GetProductInfo();
    /**获取商品基本信息结果回调*/
    void GetProductInfoResult(boolean success, String msg, ProductInfoBean productInfoBean);
    /**获取购物车商品总数量*/
    void GetProductCount();
    /**获取购物车商品总数量结果回调*/
    void GetProductCountResult(boolean success, String msg, ShopCarProductCountBean shopCarProductCountBean);
    /**添加用户关注商品*/
    void AddFavoriteProductList();
    /**添加用户关注商品结果回调*/
    void AddFavoriteProductListResult(boolean success,String msg);
    /**取消用户关注商品*/
    void DelFavoriteProductList();
    /**取消用户关注商品结果回调*/
    void DelFavoriteProductListResult(boolean success,String msg);
    /**加入购物车*/
    void AddProduct();
    /**加入购物车结果回调*/
    void AddProductResult(boolean success, String msg, List<ShopCarBean> list);

}
