package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：购物车商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:11
 * 版本：V1.0
 */
public class ShopCarProductBean {


    /**
     * ProductCode : PI4530
     * ActivityID : 1
     * ProductName : 心心相印纸巾
     * ProductNumber : 8
     * ProductModel : 6950677000572
     * LimitStock : 0
     * ProductImg :
     * ProductShowType : 1
     * ProductMarkPrice : 4
     * ProductPrice : 2
     * ProductJFPrice : 0
     * ProductUrl :
     * PromotionID : 0
     * ProductStatus : 0
     * IsSelect : 1
     * IsPackage : 0
     * PackageProducts : null
     */


    private String ProductCode;
    private int ActivityID;
    private String ProductName;
    private int ProductNumber;
    private String ProductModel;
    private int LimitStock;
    private String ProductImg;
    private int ProductShowType;
    private int ProductMarkPrice;
    private int ProductPrice;
    private int ProductJFPrice;
    private String ProductUrl;
    private int PromotionID;
    private int ProductStatus;
    private int IsSelect;
    private int IsPackage;
    private List<PackageProductBean> PackageProducts;

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public int getActivityID() {
        return ActivityID;
    }

    public void setActivityID(int ActivityID) {
        this.ActivityID = ActivityID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(int ProductNumber) {
        this.ProductNumber = ProductNumber;
    }

    public String getProductModel() {
        return ProductModel;
    }

    public void setProductModel(String ProductModel) {
        this.ProductModel = ProductModel;
    }

    public int getLimitStock() {
        return LimitStock;
    }

    public void setLimitStock(int LimitStock) {
        this.LimitStock = LimitStock;
    }

    public String getProductImg() {
        return ProductImg;
    }

    public void setProductImg(String ProductImg) {
        this.ProductImg = ProductImg;
    }

    public int getProductShowType() {
        return ProductShowType;
    }

    public void setProductShowType(int ProductShowType) {
        this.ProductShowType = ProductShowType;
    }

    public int getProductMarkPrice() {
        return ProductMarkPrice;
    }

    public void setProductMarkPrice(int ProductMarkPrice) {
        this.ProductMarkPrice = ProductMarkPrice;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductJFPrice() {
        return ProductJFPrice;
    }

    public void setProductJFPrice(int ProductJFPrice) {
        this.ProductJFPrice = ProductJFPrice;
    }

    public String getProductUrl() {
        return ProductUrl;
    }

    public void setProductUrl(String ProductUrl) {
        this.ProductUrl = ProductUrl;
    }

    public int getPromotionID() {
        return PromotionID;
    }

    public void setPromotionID(int PromotionID) {
        this.PromotionID = PromotionID;
    }

    public int getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(int ProductStatus) {
        this.ProductStatus = ProductStatus;
    }

    public int getIsSelect() {
        return IsSelect;
    }

    public void setIsSelect(int IsSelect) {
        this.IsSelect = IsSelect;
    }

    public int getIsPackage() {
        return IsPackage;
    }

    public void setIsPackage(int IsPackage) {
        this.IsPackage = IsPackage;
    }

    public List<PackageProductBean> getPackageProducts() {
        return PackageProducts;
    }

    public void setPackageProducts(List<PackageProductBean> PackageProducts) {
        this.PackageProducts = PackageProducts;
    }
}
