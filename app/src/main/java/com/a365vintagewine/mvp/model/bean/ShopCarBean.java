package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：购物车实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:03
 * 版本：V1.0
 */
public class ShopCarBean {


    /**卖家Id*/
    private int DealerID;
    /**商品列表*/
    private List<ShopCarProductBean> Products;
    /**商品数量*/
    private int ProductCount;
    /**优惠价格*/
    private double DiscountTotal;
    /**商品总金额*/
    private double BalanceTotal;
    /**赠送商品*/
    private List<GiftProduct> GiftProducts;
    /**优惠券*/
    private String CouponTitle;

    public int getDealerID() {
        return DealerID;
    }

    public void setDealerID(int dealerID) {
        DealerID = dealerID;
    }

    public List<ShopCarProductBean> getProducts() {
        return Products;
    }

    public void setProducts(List<ShopCarProductBean> products) {
        Products = products;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }

    public double getDiscountTotal() {
        return DiscountTotal;
    }

    public void setDiscountTotal(double discountTotal) {
        DiscountTotal = discountTotal;
    }

    public double getBalanceTotal() {
        return BalanceTotal;
    }

    public void setBalanceTotal(double balanceTotal) {
        BalanceTotal = balanceTotal;
    }

    public List<GiftProduct> getGiftProducts() {
        return GiftProducts;
    }

    public void setGiftProducts(List<GiftProduct> giftProducts) {
        GiftProducts = giftProducts;
    }

    public String getCouponTitle() {
        return CouponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        CouponTitle = couponTitle;
    }
}
