package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class ExchangeRecord {
    private int orderstatus;
    private String shopname;
    private String orderTime;
    private String imgUrl;
    private String goodsName;
    private int goodsIntegral;
    private int goodsnum;
    private int sumGoodsnum;
    private long sumGoodsIntegral;

    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsIntegral() {
        return goodsIntegral;
    }

    public void setGoodsIntegral(int goodsIntegral) {
        this.goodsIntegral = goodsIntegral;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public int getSumGoodsnum() {
        return sumGoodsnum;
    }

    public void setSumGoodsnum(int sumGoodsnum) {
        this.sumGoodsnum = sumGoodsnum;
    }

    public long getSumGoodsIntegral() {
        return sumGoodsIntegral;
    }

    public void setSumGoodsIntegral(long sumGoodsIntegral) {
        this.sumGoodsIntegral = sumGoodsIntegral;
    }
}
