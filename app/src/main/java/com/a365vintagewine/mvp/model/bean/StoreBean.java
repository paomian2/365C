package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：余额充值列表，商店实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  17:45
 * 版本：3.0
 */

public class StoreBean {

    /**商家id*/
    private String custId= StringUtils.EMPTY;
    /**商家名称*/
    private String custName=StringUtils.EMPTY;
    /**商家门店图片*/
    private String custImg=StringUtils.EMPTY;
    /**商家余额*/
    private String banlancePrice=StringUtils.EMPTY;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustImg() {
        return custImg;
    }

    public void setCustImg(String custImg) {
        this.custImg = custImg;
    }

    public String getBanlancePrice() {
        return banlancePrice;
    }

    public void setBanlancePrice(String banlancePrice) {
        this.banlancePrice = banlancePrice;
    }
}
