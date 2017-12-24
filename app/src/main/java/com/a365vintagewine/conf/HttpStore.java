package com.a365vintagewine.conf;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.model.bean.VerifyCodeBean;
import com.a365vintagewine.mvp.model.response.AddProductResponse;
import com.a365vintagewine.mvp.model.response.AdressListResponse;
import com.a365vintagewine.mvp.model.response.CategoryResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorBannerResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorBasicInfoResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorHotProductsResponse;
import com.a365vintagewine.mvp.model.response.GetConsignorUserBalanceResponse;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.a365vintagewine.mvp.model.response.GetHotSearchKeyResponse;
import com.a365vintagewine.mvp.model.response.GetIndexBannerResponse;
import com.a365vintagewine.mvp.model.response.GetProductCountResponse;
import com.a365vintagewine.mvp.model.response.GetProductInfoResponse;
import com.a365vintagewine.mvp.model.response.GetProductLibListResponse;
import com.a365vintagewine.mvp.model.response.GetUserBaseBalanceResponse;
import com.a365vintagewine.mvp.model.response.GetUserCommentProductResponse;
import com.a365vintagewine.mvp.model.response.GetUserConsignorPointListResponse;
import com.a365vintagewine.mvp.model.response.GetUserCouponListResponse;
import com.a365vintagewine.mvp.model.response.GetUserCouponNumResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderDetailsResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderListResponse;
import com.a365vintagewine.mvp.model.response.GetUserOrderTrackingResponse;
import com.a365vintagewine.mvp.model.response.GetUserPointResponse;
import com.a365vintagewine.mvp.model.response.QueryGroupResponse;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.model.response.QueryVendorResponse;
import com.a365vintagewine.mvp.model.response.SignKeyResponse;
import com.commsdk.module.response.base.BaseResponse;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月12日  22:25
 * 版本：3.0
 */

public interface HttpStore {
     /**=================================User(用户基础信息)====================================*/
    //获取signKey
    @POST("api/Token/GetSignKey")
    Observable<SignKeyResponse> getSignKey(@Body RequestBody requestBody);
    //发送验证码
    @POST("/api/User/SendRegVerificationCode")
    Observable<VerifyCodeBean> sendVerifyCode(@Body RequestBody requestBody);
    //发送验证码
    @POST("/api/User/RegStepOne")
    Observable<BaseResponse> verifyCodeAndUserMobile(@Body RequestBody requestBody);
    //注册
    @POST("api/User/RegStepTwo")
    Observable<UserData>  register(@Body RequestBody requestBody);
    //登录
    @POST("api/User/Login")
    Observable<UserData> getLoginInfo(@Body RequestBody requestBody);
    //获取用户的基本信息
    @POST("api/User/GetUserBasicInfo")
    Observable<UserData> getBaseUserInfo(@Body RequestBody requestBody);
    //修改用户昵称
    @POST("api/User/EditNickName")
    Observable<BaseResponse> updateNickName(@Body RequestBody requestBody);
    //修改用户头像
    @POST("api/User/EditUserHeadImg")
    Observable<BaseResponse> updateUserHeadImage(@Body RequestBody requestBody);
    //登录状态下修改登录密码
    @POST("api/User/EditUserPwd")
    Observable<BaseResponse> updateUserPwd(@Body RequestBody requestBody);
    //修改支付密码发送验证码
    @POST("api/User/SendPayPwdVerificationCode")
    Observable<VerifyCodeBean> SendPayPwdVerificationCode(@Body RequestBody requestBody);
    //原始支付密码是否正确
    @POST("api/User/EditUserPayPwdOne")
    Observable<BaseResponse> verifyOldPayPwd(@Body RequestBody requestBody);
    //校验验证码手机号是否正确
    @POST("api/User/SetUserPayPwdOne")
    Observable<BaseResponse> verifyCodeAndMoblie(@Body RequestBody requestBody);
    //设置支付密码
    @POST("api/User/SetUserPayPwdTwo")
    Observable<BaseResponse> setPayPwd(@Body RequestBody requestBody);
    //忘记登录密码发送验证码
    @POST("api/User/SendForgotPwdVerificationCode")
    Observable<BaseResponse> sendForgotPwdVerificationCode(@Body RequestBody requestBody);
    //忘记登录密码第一步
    @POST("api/User/ForgotPwdStepOne")
    Observable<BaseResponse> forgotPwdStepOne(@Body RequestBody requestBody);
    //忘记登录密码第二步
    @POST("api/User/ForgotPwdStepTwo")
    Observable<BaseResponse> forgotPwdStepTwo(@Body RequestBody requestBody);
    //收货人地址列表
    @POST("api/User/GetUserAddress")
    Observable<AdressListResponse> getUserAddress(@Body RequestBody requestBody);
    //添加收货人地址
    @POST("api/User/AddUserAddress")
    Observable<AdressListResponse> addUserAddress(@Body RequestBody requestBody);
    //编辑收货人地址
    @POST("api/User/EditUserAddress")
    Observable<BaseResponse> editUserAddress(@Body RequestBody requestBody);
    //删除收货人地址
    @POST("api/User/DelUserAddress")
    Observable<BaseResponse> delUserAddress(@Body RequestBody requestBody);
    //获取商品关注列表
    @POST("api/User/GetFavoriteProductList")
    Observable<GetFavoriteProductListResponse> getFavoriteProductList(@Body RequestBody requestBody);
    //取消商品关注列表
    @POST("api/User/DelFavoriteProductList")
    Observable<AdressListResponse> delFavoriteProductList(@Body RequestBody requestBody);
    //获取店铺关注列表
    @POST("api/User/GetFavoriteShopList")
    Observable<GetFavoriteShopListReponse> getFavoriteShopList(@Body RequestBody requestBody);
    //取消店铺关注
    @POST("api/User/DelFavoriteShopList")
    Observable<BaseResponse> delFavoriteShopList(@Body RequestBody requestBody);
    //取消积分列表
    @POST("api/User/GetUserPoint")
    Observable<GetUserPointResponse> getUserPoint(@Body RequestBody requestBody);
    //会员商家积分明细
    @POST("api/User/GetUserConsignorPointList")
    Observable<GetUserConsignorPointListResponse> getUserConsignorPointList(@Body RequestBody requestBody);
    //关注商品
    @POST("api/User/AddFavoriteProductList  ")
    Observable<BaseResponse> AddFavoriteProductList(@Body RequestBody requestBody);
    //取消用户关注商品
    @POST("api/User/DelFavoriteProductList   ")
    Observable<BaseResponse> DelFavoriteProductList(@Body RequestBody requestBody);
    //添加用户关注店铺
    @POST("api/User/AddFavoriteShopList ")
    Observable<BaseResponse> AddFavoriteShopList (@Body RequestBody requestBody);
    //取消用户关注商品
    @POST("api/User/DelFavoriteShopList ")
    Observable<BaseResponse> DelFavoriteShopList   (@Body RequestBody requestBody);



    /**===============================CmsContent(信息关联平台)======================================*/
    //获取首页banner图
    @POST("api/CmsContent/GetIndexBanner")
    Observable<GetIndexBannerResponse> GetIndexBanner(@Body RequestBody requestBody);
    //获取首页四个活动主题
    @POST("api/CmsContent/GetIndexIcon")
    Observable<GetIndexBannerResponse> GetIndexIcon(@Body RequestBody requestBody);
    //获取首页广告位
    @POST("api/CmsContent/GetIndexAd")
    Observable<GetIndexBannerResponse> GetIndexAd(@Body RequestBody requestBody);
    //获取搜索热门产品
    @POST("api/HotSaleProductLib/GetProductLibList")
    Observable<GetProductLibListResponse> GetProductLibList(@Body RequestBody requestBody);
    //获取搜索热门关键字
    @POST("api/CmsContent/GetHotSearchKey")
    Observable<GetHotSearchKeyResponse> getHotSearchKey(@Body RequestBody requestBody);

    /**===============================Search(搜索相关)======================================*/

    //附近的商家
    @POST("api/Search/QueryVendor")
    Observable<QueryVendorResponse> QueryVendor(@Body RequestBody requestBody);
    //分类首页
    @POST("api/Search/Category")
    Observable<CategoryResponse> Category(@Body RequestBody requestBody);
    //店铺商品搜索
    @POST("api/Search/Query")
    Observable<QueryResponse> StoreGoodsQuery(@Body RequestBody requestBody);



    //商家基本信息
    @POST("api/B2CConsignor/GetConsignorBasicInfo")
    Observable<GetConsignorBasicInfoResponse> GetConsignorBasicInfo(@Body RequestBody requestBody);
    //商家基本信息
    @POST("api/CmsContent/GetConsignorBanner")
    Observable<GetConsignorBannerResponse> GetConsignorBanner(@Body RequestBody requestBody);
    //获取热销商品数据
    @POST("api/CmsContent/GetConsignorHotProducts")
    Observable<GetConsignorHotProductsResponse> GetConsignorHotProducts(@Body RequestBody requestBody);
    //商家商品列表
    @POST("api/Search/Query")
    Observable<QueryResponse> Query(@Body RequestBody requestBody);
    //商家商品列表
    @POST("api/Search/Query")
    Observable<QueryGroupResponse> QueryProductList(@Body RequestBody requestBody);
    //商品详情
    @POST("api/Product/GetProductInfo")
    Observable<GetProductInfoResponse> GetProductInfo(@Body RequestBody requestBody);



    /**===============================ShopCart(购物车相关)======================================*/
    //加入购物车
    @POST("api/ShopCart/AddProduct")
    Observable<AddProductResponse> AddProduct (@Body RequestBody requestBody);
    //加入购物车
    @POST("api/ShopCart/GetProductCount")
    Observable<GetProductCountResponse> GetProductCount(@Body RequestBody requestBody);




    /**===============================营销相关======================================*/

    //优惠券数量
    @POST("api/Promotion/GetUserCouponNum")
    Observable<GetUserCouponNumResponse> GetUserCouponNum(@Body RequestBody requestBody);
    //优惠券列表
    @POST("api/Promotion/GetUserCouponList")
    Observable<GetUserCouponListResponse> GetUserCouponList(@Body RequestBody requestBody);



    /**===============================用户基本信息======================================*/

    //优惠券列表
    @POST("api/User/GetUserBaseBalance")
    Observable<GetUserBaseBalanceResponse> GetUserBaseBalance(@Body RequestBody requestBody);
    //平台余额列表
    @POST("api/User/GetConsignorUserBalance")
    Observable<GetConsignorUserBalanceResponse> GetConsignorUserBalance(@Body RequestBody requestBody);
    //申请开店
    @POST("api/User/ApplyShop ")
    Observable<BaseResponse> ApplyShop(@Body RequestBody requestBody);




    /**===============================B2C订单======================================*/

    //订单列表
    @POST("api/B2COrder/GetUserOrderList")
    Observable<GetUserOrderListResponse> GetUserOrderList(@Body RequestBody requestBody);
    //订单详情
    @POST("api/B2COrder/GetUserOrderDetails")
    Observable<GetUserOrderDetailsResponse> GetUserOrderDetails(@Body RequestBody requestBody);
    //取消订单
    @POST("api/B2COrder/CanceledOrder")
    Observable<BaseResponse> CanceledOrder(@Body RequestBody requestBody);
    //订单确认
    @POST("api/B2COrder/ConfirmOrder")
    Observable<BaseResponse> ConfirmOrder(@Body RequestBody requestBody);
    //再来一单
    @POST("api/B2COrder/OrderBuyAgain")
    Observable<BaseResponse> OrderBuyAgain(@Body RequestBody requestBody);
    //订单跟踪
    @POST("api/B2COrder/GetUserOrderTracking")
    Observable<GetUserOrderTrackingResponse> GetUserOrderTracking(@Body RequestBody requestBody);
    //获取用户可评价商品
    @POST("api/B2COrder/GetUserCommentProduct")
    Observable<GetUserCommentProductResponse> GetUserCommentProduct(@Body RequestBody requestBody);
    //订单评论
    @POST("api/B2COrder/SubUserCommentProduct")
    Observable<BaseResponse> SubUserCommentProduct(@Body RequestBody requestBody);


}
