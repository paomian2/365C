package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：充值余额明细实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  19:27
 * 版本：3.0
 */

public class BalanceDetaileBean {

    /**订单id*/
    private String orderId= StringUtils.EMPTY;
    /**订单介绍：消费、充值、退款*/
    private String balanceType=StringUtils.EMPTY;
    /**余额大小*/
    private String balancePrice=StringUtils.EMPTY;
    /**订单时间*/
    private String time=StringUtils.EMPTY;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
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
