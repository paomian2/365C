package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1 0001.
 */

public class ShopGoods {
    private FollowShop shop;
    private List<FollowGoods> goodsList;

    public FollowShop getShop() {
        return shop;
    }

    public void setShop(FollowShop shop) {
        this.shop = shop;
    }

    public List<FollowGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<FollowGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public ShopGoods(FollowShop shop, List<FollowGoods> goodsList) {
        this.shop = shop;
        this.goodsList = goodsList;
    }

    public ShopGoods() {
    }
}
