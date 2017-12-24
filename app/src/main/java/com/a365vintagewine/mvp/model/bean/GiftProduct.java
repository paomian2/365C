package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：赠送的商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:14
 * 版本：V1.0
 */
public class GiftProduct {

    private int GiftType;
    private String ContactProductCode;
    private String ProductCode;
    private String ProductName;
    private int ProductNumber;

    public int getGiftType() {
        return GiftType;
    }

    public void setGiftType(int GiftType) {
        this.GiftType = GiftType;
    }

    public String getContactProductCode() {
        return ContactProductCode;
    }

    public void setContactProductCode(String ContactProductCode) {
        this.ContactProductCode = ContactProductCode;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
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
}
