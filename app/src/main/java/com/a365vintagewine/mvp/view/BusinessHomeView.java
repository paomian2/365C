package com.a365vintagewine.mvp.view;
import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBasicInfo;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.commsdk.base.view.BaseView;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月04日  10:09
 * 版本：3.0
 */

public interface BusinessHomeView extends BaseView{

    /**获取商家的基本信息*/
    void GetConsignorBasicInfo();
    /**获取商家基本信息结果回调*/
    void GetConsignorBasicInfoResult(boolean success, String msg, ConsignorBasicInfo consignorBasicInfo);
    /**获取商家首页Banner*/
    void GetConsignorBanner();
    /**获取商家首页Banner结果回调*/
    void GetConsignorBannerResult(boolean success, String msg, List<BannerBean> bannerBeen);
    /**商家首页热销排行*/
    void GetConsignorHotProducts();
    /**商家首页热销排行结果回调*/
    void GetConsignorHotProductsResult(boolean success, String msg, List<ProductsBean> list);
    /**商家商品列表分类*/
    void QueryCategory();
    /**商家商品分类结果回调*/
    void QueryCategoryResult(boolean success,String msg,QueryResponse queryResponse);
    /**商家商品列表*/
    void QueryProductList();
    /**商家商品列表结果回调*/
    void QueryProductListResult(boolean success,String msg,List<ProductsBean> list);
    /**获取购物车商品总数量*/
    void GetProductCount();
    /**获取购物车商品总数量结果回调*/
    void GetProductCountResult(boolean success, String msg, ShopCarProductCountBean shopCarProductCountBean);
    /**加入购物车*/
    void AddProduct(Map<String,Object> params);
    /**加入购物车结果回调*/
    void AddProductResult(boolean success, String msg, List<ShopCarBean> list);
    /**添加用户关注店铺*/
    void AddFavoriteShopList();
    /**添加用户关注店铺结果回调*/
    void AddFavoriteShopListResult(boolean success,String msg);
    /**用户取消关注店铺*/
    void DelFavoriteShopList();
    /**用户取消关注店铺结果回调*/
    void DelFavoriteShopListResult(boolean success,String msg);
}
