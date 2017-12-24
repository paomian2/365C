package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.model.response.AddProductResponse;
import com.a365vintagewine.mvp.model.response.CategoryResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorBannerResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorBasicInfoResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorHotProductsResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorUserBalanceResponse;
import com.a365vintagewine.mvp.model.response.GetHotSearchKeyResponse;
import com.a365vintagewine.mvp.model.response.GetIndexBannerResponse;
import com.a365vintagewine.mvp.model.response.GetProductCountResponse;
import com.a365vintagewine.mvp.model.response.GetProductInfoResponse;
import com.a365vintagewine.mvp.model.response.GetProductLibListResponse;
import com.a365vintagewine.mvp.model.response.GetUserBaseBalanceResponse;
import com.a365vintagewine.mvp.model.response.GetUserCommentProductResponse;
import com.a365vintagewine.mvp.model.response.GetUserCouponListResponse;
import com.a365vintagewine.mvp.model.response.GetUserCouponNumResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderDetailsResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderListResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderTrackingResponse;
import com.a365vintagewine.mvp.model.response.QueryGroupResponse;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.model.response.QueryStoreGoodsResponse;
import com.a365vintagewine.utils.ProtocolSendParamsUtils;
import com.commsdk.base.retrofit.ApiCallback;
import com.commsdk.base.retrofit.BaseRequesBody;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：信息关联平台model
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月30日  9:33
 * 版本：3.0
 */

public class CmsContentModel extends BaseModel2{



    /**获取用户基本信息*/
    public void getBaseUserInfo(String Client_Id, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id", Client_Id);
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserBasicInfo");
        addSubscription(apiStore.getBaseUserInfo(BaseRequesBody.setJsonString(params)), new ApiCallback<UserData>() {
            @Override
            public void onSuccess(UserData model) {
                if (model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {
            }
        });
    }

    /**获取首页banner图*/
    public void GetIndexBanner(final ModelCallBack modelCallBack){
        Map<String,Object> params=new HashMap<>();
        ProtocolSendParamsUtils.paramsEdit(params,"GetIndexBanner");
        addSubscription(apiStore.GetIndexBanner(BaseRequesBody.setJsonString(params)), new ApiCallback<GetIndexBannerResponse>() {
            @Override
            public void onSuccess(GetIndexBannerResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**获取首页四个活动图*/
    public void GetIndexIcon(final ModelCallBack modelCallBack){
        Map<String,Object> params=new HashMap<>();
        ProtocolSendParamsUtils.paramsEdit(params,"GetIndexIcon");
        addSubscription(apiStore.GetIndexIcon(BaseRequesBody.setJsonString(params)), new ApiCallback<GetIndexBannerResponse>() {
            @Override
            public void onSuccess(GetIndexBannerResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**获取首页广告位*/
    public void GetIndexAd(final ModelCallBack modelCallBack){
        Map<String,Object> params=new HashMap<>();
        ProtocolSendParamsUtils.paramsEdit(params,"GetIndexAd");
        addSubscription(apiStore.GetIndexAd(BaseRequesBody.setJsonString(params)), new ApiCallback<GetIndexBannerResponse>() {
            @Override
            public void onSuccess(GetIndexBannerResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**获取首页热卖产品*/
    public void GetProductLibList(final ModelCallBack modelCallBack){
        Map<String,Object> params=new HashMap<>();
        ProtocolSendParamsUtils.paramsEdit(params,"GetProductLibList");
        addSubscription(apiStore.GetProductLibList(BaseRequesBody.setJsonString(params)), new ApiCallback<GetProductLibListResponse>() {
            @Override
            public void onSuccess(GetProductLibListResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**获取搜索热门关键字*/
    public void GetHotSearchKey(final ModelCallBack modelCallBack){
        Map<String,Object> params=new HashMap<>();
        ProtocolSendParamsUtils.paramsEdit(params,"GetHotSearchKey");
        addSubscription(apiStore.getHotSearchKey(BaseRequesBody.setJsonString(params)), new ApiCallback<GetHotSearchKeyResponse>() {
            @Override
            public void onSuccess(GetHotSearchKeyResponse model) {
                  if(model.isResult()){
                      modelCallBack.onSuccess(model.getData());
                  }else{
                      modelCallBack.onFailure(model.getMsg());
                  }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**商家基本信息*/
    public void GetConsignorBasicInfo(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetConsignorBasicInfo");
        addSubscription(apiStore.GetConsignorBasicInfo(BaseRequesBody.setJsonString(params)), new ApiCallback<GetConsignorBasicInfoResponse>() {
            @Override
            public void onSuccess(GetConsignorBasicInfoResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }




    /**获取商家轮播图*/
    public void GetConsignorBanner(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetConsignorBanner");
        addSubscription(apiStore.GetConsignorBanner(BaseRequesBody.setJsonString(params)), new ApiCallback<GetConsignorBannerResponse>() {
            @Override
            public void onSuccess(GetConsignorBannerResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**获取商家热销商品数据*/
    public void GetConsignorHotProducts(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetConsignorHotProducts");
        addSubscription(apiStore.GetConsignorHotProducts(BaseRequesBody.setJsonString(params)), new ApiCallback<GetConsignorHotProductsResponse>() {
            @Override
            public void onSuccess(GetConsignorHotProductsResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**商家商品列表排行*/
    public void Query(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"Query");
        addSubscription(apiStore.Query(BaseRequesBody.setJsonString(params)), new ApiCallback<QueryResponse>() {
            @Override
            public void onSuccess(QueryResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model);
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**商家商品列表*/
    public void QueryProductList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"Query");
        addSubscription(apiStore.QueryProductList(BaseRequesBody.setJsonString(params)), new ApiCallback<QueryGroupResponse>() {
            @Override
            public void onSuccess(QueryGroupResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**添加用户关注店铺*/
    public void AddFavoriteShopList (Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"AddFavoriteShopList ");
        addSubscription(apiStore.AddFavoriteShopList(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**用户取消关注店铺*/
    public void DelFavoriteShopList  (Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"DelFavoriteShopList  ");
        addSubscription(apiStore.DelFavoriteShopList (BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**商品详情*/
    public void GetProductInfo(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetProductInfo");
        addSubscription(apiStore.GetProductInfo(BaseRequesBody.setJsonString(params)), new ApiCallback<GetProductInfoResponse>() {
            @Override
            public void onSuccess(GetProductInfoResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**关注商品*/
    public void AddFavoriteProductList (Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"AddFavoriteProductList ");
        addSubscription(apiStore.AddFavoriteProductList(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**取消用户关注商品*/
    public void DelFavoriteProductList  (Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"DelFavoriteProductList ");
        addSubscription(apiStore.DelFavoriteProductList(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**加入购物车*/
    public void AddProduct(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"AddProduct");
        addSubscription(apiStore.AddProduct(BaseRequesBody.setJsonString(params)), new ApiCallback<AddProductResponse>() {
            @Override
            public void onSuccess(AddProductResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**获取购物车商品总数量*/
    public void GetProductCount(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetProductCount");
        addSubscription(apiStore.GetProductCount(BaseRequesBody.setJsonString(params)), new ApiCallback<GetProductCountResponse>() {
            @Override
            public void onSuccess(GetProductCountResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**分类首页*/
    public void Category(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"Category");
        addSubscription(apiStore.Category(BaseRequesBody.setJsonString(params)), new ApiCallback<CategoryResponse>() {
            @Override
            public void onSuccess(CategoryResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**店铺商品搜索*/
    public void StoreGoodsQuery(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"Query");
        addSubscription(apiStore.StoreGoodsQuery(BaseRequesBody.setJsonString(params)), new ApiCallback<QueryResponse>() {
            @Override
            public void onSuccess(QueryResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model);
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**获取优惠券数量*/
    public void GetUserCouponNum(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserCouponNum");
        addSubscription(apiStore.GetUserCouponNum(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserCouponNumResponse>() {
            @Override
            public void onSuccess(GetUserCouponNumResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**获取优惠券列表*/
    public void GetUserCouponList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserCouponList");
        addSubscription(apiStore.GetUserCouponNum(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserCouponListResponse>() {
            @Override
            public void onSuccess(GetUserCouponListResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**我的余额*/
    public void GetUserBaseBalance(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserBaseBalance");
        addSubscription(apiStore.GetUserBaseBalance(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserBaseBalanceResponse>() {
            @Override
            public void onSuccess(GetUserBaseBalanceResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**平台余额列表*/
    public void GetPlatformUserBalance(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetPlatformUserBalance");
        addSubscription(apiStore.GetUserBaseBalance(BaseRequesBody.setJsonString(params)), new ApiCallback<GetConsignorUserBalanceResponse>() {
            @Override
            public void onSuccess(GetConsignorUserBalanceResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**充值余额*/
    public void GetConsignorUserBalance(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetConsignorUserBalance");
        addSubscription(apiStore.GetConsignorUserBalance(BaseRequesBody.setJsonString(params)), new ApiCallback<GetConsignorUserBalanceResponse>() {
            @Override
            public void onSuccess(GetConsignorUserBalanceResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**申请开店*/
    public void ApplyShop(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"ApplyShop ");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**订单列表*/
    public void GetUserOrderList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserOrderList");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserOrderListResponse>() {
            @Override
            public void onSuccess(GetUserOrderListResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**订单详情*/
    public void GetUserOrderDetails(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserOrderDetails");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserOrderDetailsResponse>() {
            @Override
            public void onSuccess(GetUserOrderDetailsResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**取消*/
    public void CanceledOrder(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"CanceledOrder");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**订单确认*/
    public void ConfirmOrder(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"ConfirmOrder");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**再次购买*/
    public void OrderBuyAgain(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"OrderBuyAgain");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**订单跟踪*/
    public void GetUserOrderTracking(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserOrderTracking");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserOrderTrackingResponse>() {
            @Override
            public void onSuccess(GetUserOrderTrackingResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }



    /**获取用户可评价商品*/
    public void GetUserCommentProduct(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserCommentProduct");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserCommentProductResponse>() {
            @Override
            public void onSuccess(GetUserCommentProductResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getData());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }


    /**订单评论*/
    public void SubUserCommentProduct(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"SubUserCommentProduct");
        addSubscription(apiStore.ApplyShop(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if(model.isResult()){
                    modelCallBack.onSuccess(model.getMsg());
                }else{
                    modelCallBack.onFailure(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                modelCallBack.onFailure(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }




}
