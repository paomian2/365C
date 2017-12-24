package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：用户实体信息
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  10:36
 * 版本：V1.0
 */
public class UserBean {

    /**用户Id*/
    private int Client_Id;
    /**用户名称*/
    private String ClientName;
    /**用户昵称*/
    private String NickName;
    /**用户头像*/
    private String UserHeadImgUrl;
    /**用户电话*/
    private String Mobile;
    /**积分*/
    private int Point;
    /**余额*/
    private double AccountBalance;
    /**优惠券数量*/
    private int CouponNum;
    /**分销状态*/
    private int FenXiaoState;
    /**分销等级*/
    private int FenXiaoLevel;
    /**邀请码*/
    private String InvitationCode;
    /**邀请码二维码*/
    private String InvitationCodeImg;
    /**实名制状态*/
    private String IDCardState;
    private String IDCardStateName;
    private String OpenShopState;
    private String PayPwdState;
    private String OpenShopStateName;

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getUserHeadImgUrl() {
        return UserHeadImgUrl;
    }

    public void setUserHeadImgUrl(String userHeadImgUrl) {
        UserHeadImgUrl = userHeadImgUrl;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public int getCouponNum() {
        return CouponNum;
    }

    public void setCouponNum(int couponNum) {
        CouponNum = couponNum;
    }

    public int getFenXiaoState() {
        return FenXiaoState;
    }

    public void setFenXiaoState(int fenXiaoState) {
        FenXiaoState = fenXiaoState;
    }

    public int getFenXiaoLevel() {
        return FenXiaoLevel;
    }

    public void setFenXiaoLevel(int fenXiaoLevel) {
        FenXiaoLevel = fenXiaoLevel;
    }

    public String getInvitationCode() {
        return InvitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        InvitationCode = invitationCode;
    }

    public String getInvitationCodeImg() {
        return InvitationCodeImg;
    }

    public void setInvitationCodeImg(String invitationCodeImg) {
        InvitationCodeImg = invitationCodeImg;
    }

    public String getIDCardState() {
        return IDCardState;
    }

    public void setIDCardState(String IDCardState) {
        this.IDCardState = IDCardState;
    }

    public String getIDCardStateName() {
        return IDCardStateName;
    }

    public void setIDCardStateName(String IDCardStateName) {
        this.IDCardStateName = IDCardStateName;
    }

    public String getOpenShopState() {
        return OpenShopState;
    }

    public void setOpenShopState(String openShopState) {
        OpenShopState = openShopState;
    }

    public String getPayPwdState() {
        return PayPwdState;
    }

    public void setPayPwdState(String payPwdState) {
        PayPwdState = payPwdState;
    }

    public String getOpenShopStateName() {
        return OpenShopStateName;
    }

    public void setOpenShopStateName(String openShopStateName) {
        OpenShopStateName = openShopStateName;
    }
}
