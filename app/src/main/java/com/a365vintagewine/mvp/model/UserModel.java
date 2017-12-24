package com.a365vintagewine.mvp.model;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.mvp.model.bean.VerifyCodeBean;
import com.a365vintagewine.mvp.model.response.AdressListResponse;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.a365vintagewine.mvp.model.response.GetUserConsignorPointListResponse;
import com.a365vintagewine.mvp.model.response.GetUserPointResponse;
import com.a365vintagewine.utils.ProtocolSendParamsUtils;
import com.commsdk.base.retrofit.ApiCallback;
import com.commsdk.base.retrofit.BaseRequesBody;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.module.response.base.BaseResponse;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;


/**
 * 描述：用户基本信息model
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月12日  2:05
 * 版本：3.0
 */

public class UserModel extends BaseModel2{

    /**发送验证码*/
    public void sendVerifyCode(String phoneNo, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile", phoneNo);
        ProtocolSendParamsUtils.paramsEdit(params,"SendRegVerificationCode");
        addSubscription(apiStore.sendVerifyCode(BaseRequesBody.setJsonString(params)), new ApiCallback<VerifyCodeBean>() {
            @Override
            public void onSuccess(VerifyCodeBean model) {
                if (model.isResult()){
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

    /**校验验证码用户信息*/
    public void verifyCodeAndUserMobile(String Mobile,String VerificationCode,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile", Mobile);
        params.put("VerificationCode", VerificationCode);
        ProtocolSendParamsUtils.paramsEdit(params,"RegStepOne");
        addSubscription(apiStore.verifyCodeAndUserMobile(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                modelCallBack.onSuccess(model);
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

    /**注册用户*/
    public void register(String phoneNo, String VerificationCode, String InvitationCode, String Pwd, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile",phoneNo);
        params.put("VerificationCode",VerificationCode);
        params.put("Pwd",Pwd);
        if (!StringUtils.isEmpty(InvitationCode)){
            params.put("InvitationCode",InvitationCode);
        }
        ProtocolSendParamsUtils.paramsEdit(params,"RegStepTwo");
        addSubscription(apiStore.register(BaseRequesBody.setJsonString(params)), new ApiCallback<UserData>() {
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


    /**
     * 服务器端登录
     * */
    public void login(String userName, String userPwd, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("UserName", userName);
        params.put("UserPwd", userPwd);
        ProtocolSendParamsUtils.paramsEdit(params,"Login");
        addSubscription(apiStore.getLoginInfo(BaseRequesBody.setJsonString(params)), new ApiCallback<UserData>() {
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

    /**修改用户昵称*/
    public void updateNickName(String Client_Id, String Nickname, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id", Client_Id);
        params.put("Nickname", Nickname);
        ProtocolSendParamsUtils.paramsEdit(params,"EditNickName");
        addSubscription(apiStore.updateNickName(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**修改用户头像*/
    public void updateHeadImage(String Client_Id,String Base64UserHeadImgUrl,String UpLoadFileStr,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id", Client_Id);
        params.put("Base64UserHeadImgUrl", Base64UserHeadImgUrl);
        params.put("UpLoadFileStr", UpLoadFileStr);
        ProtocolSendParamsUtils.paramsEdit(params,"EditUserHeadImg");
        addSubscription(apiStore.updateUserHeadImage(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**用户登录状态下修改密码*/
    public void updateUserPwd(String Client_Id, String OrgPwd, String NewPwd, String ConfirmPwd, final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("OrgPwd",OrgPwd);
        params.put("NewPwd",NewPwd);
        params.put("ConfirmPwd",ConfirmPwd);
        ProtocolSendParamsUtils.paramsEdit(params,"EditUserPwd");
        addSubscription(apiStore.updateUserPwd(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**验证原始支付密码是否正确*/
    public void verifyOldPayPwd(String Client_Id,String PayPwd,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("PayPwd",PayPwd);
        ProtocolSendParamsUtils.paramsEdit(params,"EditUserPayPwdOne");
        addSubscription(apiStore.verifyOldPayPwd(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**修改支付密码发送验证码*/
    public void sendPayPwdVerificationCode(String Client_Id,String Mobile,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("Mobile",Mobile);
        ProtocolSendParamsUtils.paramsEdit(params,"SendPayPwdVerificationCode");
        addSubscription(apiStore.SendPayPwdVerificationCode(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**
     * 修改支付密码：校验验证码手机号是否正确
     * 修改密码发送验证码后第一步
     * */
    public void verifyCodeAndMoblie(String Client_Id,String Mobile,String VerificationCode,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("Mobile",Mobile);
        params.put("VerificationCode",VerificationCode);
        ProtocolSendParamsUtils.paramsEdit(params,"SetUserPayPwdOne");
        addSubscription(apiStore.verifyCodeAndMoblie(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**设置支付密码，修改支付密码*/
    public void setPayPwd(String Client_Id,String Mobile,String VerificationCode,String PayPwd,String ConfirmPayPwd,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("Mobile",Mobile);
        params.put("VerificationCode",VerificationCode);
        params.put("PayPwd",PayPwd);
        params.put("ConfirmPayPwd",ConfirmPayPwd);
        ProtocolSendParamsUtils.paramsEdit(params,"SetUserPayPwdTwo");
        addSubscription(apiStore.setPayPwd(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**
     * 忘记密码发送验证码
     * */
    public void sendForgotPwdVerificationCode(String Mobile,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile",Mobile);
        ProtocolSendParamsUtils.paramsEdit(params,"SendForgotPwdVerificationCode");
        addSubscription(apiStore.sendForgotPwdVerificationCode(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**忘记密码第一步*/
    public void forgotPwdStepOne(String Mobile,String VerificationCode,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile",Mobile);
        params.put("VerificationCode",VerificationCode);
        ProtocolSendParamsUtils.paramsEdit(params,"ForgotPwdStepOne");
        addSubscription(apiStore.forgotPwdStepOne(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**忘记密码第二步*/
    public void forgotPwdStepTwo(String Mobile,String NewPwd,String ConfirmPwd,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Mobile",Mobile);
        params.put("NewPwd",NewPwd);
        params.put("ConfirmPwd",ConfirmPwd);
        ProtocolSendParamsUtils.paramsEdit(params,"ForgotPwdStepTwo");
        addSubscription(apiStore.forgotPwdStepTwo(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**获取收货人地址列表*/
    public void getUserAddress(String Client_Id,String Page,String Take,final ModelCallBack modelCallBack){
        Map<String,Object> params = new HashMap<>();
        params.put("Client_Id",Client_Id);
        params.put("Page",Page);
        params.put("Take",Take);
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserAddress");
        addSubscription(apiStore.getUserAddress(BaseRequesBody.setJsonString(params)), new ApiCallback<AdressListResponse>() {
            @Override
            public void onSuccess(AdressListResponse model) {
                if (model.isResult()){
                    if (model.getData()!=null && model.getData().getPagedData()!=null){
                        modelCallBack.onSuccess(model.getData().getPagedData());
                    }else{
                        modelCallBack.onFailure("已加载完成");
                    }
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

    /**添加收货人地址*/
    public void addUserAddress(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"AddUserAddress");
        addSubscription(apiStore.addUserAddress(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**编辑收货人地址*/
    public void editUserAddress(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"editUserAddress");
        addSubscription(apiStore.editUserAddress(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**删除收货人地址*/
    public void delUserAddress(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"DelUserAddress");
        addSubscription(apiStore.delUserAddress(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**获取商品关注列表*/
    public void getFavoriteProductList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetFavoriteProductList");
        addSubscription(apiStore.getFavoriteProductList(BaseRequesBody.setJsonString(params)), new ApiCallback<GetFavoriteProductListResponse>() {
            @Override
            public void onSuccess(GetFavoriteProductListResponse model) {
                if (model.isResult()){
                    modelCallBack.onSuccess(model.getData().getPagedData());
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

    /**商品取消关注*/
    public void delFavoriteProductList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"DelFavoriteProductList");
        addSubscription(apiStore.delFavoriteProductList(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**获取店铺关注列表*/
    public void getFavoriteShopList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetFavoriteShopList");
        addSubscription(apiStore.getFavoriteShopList(BaseRequesBody.setJsonString(params)), new ApiCallback<GetFavoriteShopListReponse>() {
            @Override
            public void onSuccess(GetFavoriteShopListReponse model) {
                if (model.isResult()){
                    modelCallBack.onSuccess(model.getData().getPagedData());
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


    /**店铺取消关注*/
    public void delFavoriteShopList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"DelFavoriteShopList");
        addSubscription(apiStore.delFavoriteShopList(BaseRequesBody.setJsonString(params)), new ApiCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                if (model.isResult()){
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

    /**获取积分列表*/
    public void getUserPoint(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserPoint");
        addSubscription(apiStore.getUserPoint(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserPointResponse>() {
            @Override
            public void onSuccess(GetUserPointResponse model) {
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

    /**商家积分明细*/
    public void getUserConsignorPointList(Map<String,Object> params,final ModelCallBack modelCallBack){
        ProtocolSendParamsUtils.paramsEdit(params,"GetUserConsignorPointList");
        addSubscription(apiStore.getUserConsignorPointList(BaseRequesBody.setJsonString(params)), new ApiCallback<GetUserConsignorPointListResponse>() {
            @Override
            public void onSuccess(GetUserConsignorPointListResponse model) {
                if (model.isResult() && model!=null){
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


}
