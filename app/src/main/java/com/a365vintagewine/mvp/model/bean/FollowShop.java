package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public class FollowShop {
    private String imgUrl;
    private String shopname;
    private float star;
    private double shopDistance;

    public double getShopDistance() {
        return shopDistance;
    }

    public void setShopDistance(double shopDistance) {
        this.shopDistance = shopDistance;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public FollowShop(String imgUrl, String shopname, float star) {
        this.imgUrl = imgUrl;
        this.shopname = shopname;
        this.star = star;
    }

    public FollowShop() {
    }
}
