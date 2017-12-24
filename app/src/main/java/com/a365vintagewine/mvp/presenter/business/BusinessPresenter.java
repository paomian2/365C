package com.a365vintagewine.mvp.presenter.business;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBasicInfo;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.view.BusinessHomeView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月04日  10:08
 * 版本：3.0
 */

public class BusinessPresenter extends BasePresenter<BusinessHomeView,CmsContentModel>{

    public BusinessPresenter(BusinessHomeView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**获取商家的基本信息*/
    public void GetConsignorBasicInfo(Map<String,Object> params){
        mModel.GetConsignorBasicInfo(params,new ModelCallBack<ConsignorBasicInfo>(){
            @Override
            public void onSuccess(ConsignorBasicInfo model) {
              mView.GetConsignorBasicInfoResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetConsignorBasicInfoResult(false,msg,null);
            }
        });
    }

    /**获取商家首页Banner*/
    public void GetConsignorBanner(Map<String,Object> params){
        mModel.GetConsignorBanner(params,new ModelCallBack<List<BannerBean>>(){
            @Override
            public void onSuccess(List<BannerBean> model) {
                mView.GetConsignorBannerResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetConsignorBannerResult(false,msg,null);
            }
        });

    }

    /**商家首页热销排行*/
    public void GetConsignorHotProducts(Map<String,Object> params){
        mModel.GetConsignorHotProducts(params,new ModelCallBack<List<ProductsBean>>(){
            @Override
            public void onSuccess(List<ProductsBean> model) {
                mView.GetConsignorHotProductsResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetConsignorHotProductsResult(false,msg,null);
            }
        });
    }

    /**商家商品列表*/
    public void Query(Map<String,Object> params){
        mModel.Query(params,new ModelCallBack<QueryResponse>(){
            @Override
            public void onSuccess(QueryResponse model) {
                mView.QueryCategoryResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.QueryCategoryResult(false,msg,null);
            }
        });
    }

    /**商家商品列表*/
    public void QueryProductList(Map<String,Object> params){
        mModel.QueryProductList(params,new ModelCallBack<List<ProductsBean>>(){
            @Override
            public void onSuccess(List<ProductsBean> model) {
                mView.QueryProductListResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.QueryProductListResult(false,msg,null);
            }
        });
    }

    /**获取购物车商品总数量*/
    public void GetProductCount(Map<String,Object> params){
        mModel.GetProductCount(params, new ModelCallBack<ShopCarProductCountBean>() {
            @Override
            public void onSuccess(ShopCarProductCountBean model) {
                mView.GetProductCountResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetProductCountResult(false,msg,null);
            }
        });
    }


    /**加入购物车*/
    public void AddProduct(Map<String,Object> params){
        mModel.AddProduct(params, new ModelCallBack<List<ShopCarBean>>() {
            @Override
            public void onSuccess(List<ShopCarBean> model) {
                mView.AddProductResult(true,"success",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.AddProductResult(false,msg,null);
            }
        });
    }


    /**添加用户关注店铺*/
    public void AddFavoriteShopList(Map<String,Object> params){
        mModel.AddFavoriteShopList(params, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.AddFavoriteShopListResult(true,model);
            }

            @Override
            public void onFailure(String msg) {
                mView.AddFavoriteShopListResult(false,msg);
            }
        });
    }


    /**用户取消关注店铺*/
    public void DelFavoriteShopList (Map<String,Object> params){
        mModel.DelFavoriteShopList (params, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.DelFavoriteShopListResult(true,model);
            }

            @Override
            public void onFailure(String msg) {
                mView.DelFavoriteShopListResult(false,msg);
            }
        });
    }
}
