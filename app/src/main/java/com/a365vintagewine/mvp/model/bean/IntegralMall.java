package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class IntegralMall {
    private String goodsname;
    private String goodsimg;
    private int goodsIntegral;

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public int getGoodsIntegral() {
        return goodsIntegral;
    }

    public void setGoodsIntegral(int goodsIntegral) {
        this.goodsIntegral = goodsIntegral;
    }

    public IntegralMall(String goodsname, String goodsimg, int goodsIntegral) {
        this.goodsname = goodsname;
        this.goodsimg = goodsimg;
        this.goodsIntegral = goodsIntegral;
    }

    public IntegralMall() {
    }
}
