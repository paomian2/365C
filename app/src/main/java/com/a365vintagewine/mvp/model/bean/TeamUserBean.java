package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：我的团队队员消费情况
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  15:49
 * 版本：3.0
 */

public class TeamUserBean {

    /**用户id*/
    private String userId= StringUtils.EMPTY;
    /**用户昵称*/
    private String userName=StringUtils.EMPTY;
    /**用户头像*/
    private String userHeadUrl=StringUtils.EMPTY;
    /**产生余额介绍*/
    private String balanceDesc=StringUtils.EMPTY;
    /**产生的余额*/
    private String balancePrice=StringUtils.EMPTY;
    /**产生余额的时间*/
    private String time=StringUtils.EMPTY;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public String getBalanceDesc() {
        return balanceDesc;
    }

    public void setBalanceDesc(String balanceDesc) {
        this.balanceDesc = balanceDesc;
    }

    public String getBalancePrice() {
        return balancePrice;
    }

    public void setBalancePrice(String balancePrice) {
        this.balancePrice = balancePrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
