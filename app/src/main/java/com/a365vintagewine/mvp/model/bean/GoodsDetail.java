package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class GoodsDetail {
    private List<String> goodsImgUrls; //商品详情轮播图
    private boolean isCollect; //是否收藏商品
    private String goodsName; //商品名称
    private double goodsPrice; //商品价格
    private double recommendedPrice; //建议零售价
    private int monthSell; //月销
    private List<String> goodsAttribute; //商品属性
    private int goodsCartNum; //购物车数量
    private double goodsTotalPrice; //购物车商品总价
    private int shippingfee; //配送费

    public List<String> getGoodsImgUrls() {
        return goodsImgUrls;
    }

    public void setGoodsImgUrls(List<String> goodsImgUrls) {
        this.goodsImgUrls = goodsImgUrls;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(double recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }

    public int getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(int monthSell) {
        this.monthSell = monthSell;
    }

    public List<String> getGoodsAttribute() {
        return goodsAttribute;
    }

    public void setGoodsAttribute(List<String> goodsAttribute) {
        this.goodsAttribute = goodsAttribute;
    }

    public int getGoodsCartNum() {
        return goodsCartNum;
    }

    public void setGoodsCartNum(int goodsCartNum) {
        this.goodsCartNum = goodsCartNum;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public int getShippingfee() {
        return shippingfee;
    }

    public void setShippingfee(int shippingfee) {
        this.shippingfee = shippingfee;
    }
}
