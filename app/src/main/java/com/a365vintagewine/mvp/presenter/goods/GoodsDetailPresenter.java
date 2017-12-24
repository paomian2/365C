package com.a365vintagewine.mvp.presenter.goods;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.ProductInfoBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.a365vintagewine.mvp.model.response.GetProductCountResponse;
import com.a365vintagewine.mvp.view.goods.GoodsDetailView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;
import java.util.Map;


public class GoodsDetailPresenter extends BasePresenter<GoodsDetailView,CmsContentModel> {
    public GoodsDetailPresenter(GoodsDetailView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }



    /**获取商品基本信息*/
    public void GetProductInfo(Map<String,Object> params){
       mModel.GetProductInfo(params, new ModelCallBack<ProductInfoBean>() {
           @Override
           public void onSuccess(ProductInfoBean model) {
               mView.GetProductInfoResult(true,"success",model);
           }

           @Override
           public void onFailure(String msg) {
               mView.GetProductInfoResult(false,msg,null);
           }
       });
    }

    /**添加用户关注商品*/
    public void AddFavoriteProductList(Map<String,Object> params){
        mModel.AddFavoriteProductList(params, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.AddFavoriteProductListResult(true,model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetProductInfoResult(false,msg,null);
            }
        });
    }


    /**取消用户关注商品*/
    public void DelFavoriteProductList (Map<String,Object> params){
        mModel.DelFavoriteProductList (params, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.DelFavoriteProductListResult(true,model);
            }

            @Override
            public void onFailure(String msg) {
                mView.DelFavoriteProductListResult(false,msg);
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
}
