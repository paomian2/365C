package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class MyIntegral {
    private int sumIntegral;
    private String platformImg;
    private String platformName;
    private int platformIntegral;
    private List<ShopIntegral> shopList;

    public int getSumIntegral() {
        return sumIntegral;
    }

    public void setSumIntegral(int sumIntegral) {
        this.sumIntegral = sumIntegral;
    }

    public String getPlatformImg() {
        return platformImg;
    }

    public void setPlatformImg(String platformImg) {
        this.platformImg = platformImg;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public int getPlatformIntegral() {
        return platformIntegral;
    }

    public void setPlatformIntegral(int platformIntegral) {
        this.platformIntegral = platformIntegral;
    }

    public List<ShopIntegral> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopIntegral> shopList) {
        this.shopList = shopList;
    }

    public static class ShopIntegral{
        private String shopImg;
        private String shopName;
        private int shopIntegral;

        public String getShopImg() {
            return shopImg;
        }

        public void setShopImg(String shopImg) {
            this.shopImg = shopImg;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getShopIntegral() {
            return shopIntegral;
        }

        public void setShopIntegral(int shopIntegral) {
            this.shopIntegral = shopIntegral;
        }

        public ShopIntegral(String shopImg, String shopName, int shopIntegral) {
            this.shopImg = shopImg;
            this.shopName = shopName;
            this.shopIntegral = shopIntegral;
        }

        public ShopIntegral() {
        }
    }
}
