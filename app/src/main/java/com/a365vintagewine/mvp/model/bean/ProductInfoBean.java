package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：商品详情
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  11:57
 * 版本：V1.0
 */
public class ProductInfoBean {


    /**商品Id*/
    private int Id;
    private int Lid;
    /**商品编号*/
    private String Code;
    /**商品名称*/
    private String Name;
    /**商品图片*/
    private String Image;
    /**商品价格*/
    private double VipPrice;
    /**商品市场价*/
    private double SalePrice;
    /**品牌Id*/
    private int BrandId;
    /**品牌名称*/
    private String BrandName;
    /**类目Id*/
    private String TypeIdPath;
    /**类目图片*/
    private String TypeNamePath;
    /**卖家Id*/
    private int VendorId;
    /**买家编号*/
    private String VendorCode;
    /**卖家名称*/
    private String VendorName;
    /**卖家创建时间*/
    private String CreatedOn;
    /**商品详情*/
    private String Description;
    /**销量*/
    private int SaleCount;
    /**是否已收藏*/
    private boolean Favorite;
    /**积分*/
    private int PointNumber;
    /**活动Id*/
    private int ActivityId;
    /**h活动*/
    private int ActionID;
    private Object Ext;
    /**商品属性*/
    private List<String> PropTexts;
    /**商品详情图*/
    private List<String> Images;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getLid() {
        return Lid;
    }

    public void setLid(int Lid) {
        this.Lid = Lid;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public double getVipPrice() {
        return VipPrice;
    }

    public void setVipPrice(double VipPrice) {
        this.VipPrice = VipPrice;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double SalePrice) {
        this.SalePrice = SalePrice;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int BrandId) {
        this.BrandId = BrandId;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getTypeIdPath() {
        return TypeIdPath;
    }

    public void setTypeIdPath(String TypeIdPath) {
        this.TypeIdPath = TypeIdPath;
    }

    public String getTypeNamePath() {
        return TypeNamePath;
    }

    public void setTypeNamePath(String TypeNamePath) {
        this.TypeNamePath = TypeNamePath;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int VendorId) {
        this.VendorId = VendorId;
    }

    public String getVendorCode() {
        return VendorCode;
    }

    public void setVendorCode(String VendorCode) {
        this.VendorCode = VendorCode;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getSaleCount() {
        return SaleCount;
    }

    public void setSaleCount(int SaleCount) {
        this.SaleCount = SaleCount;
    }

    public boolean isFavorite() {
        return Favorite;
    }

    public void setFavorite(boolean Favorite) {
        this.Favorite = Favorite;
    }

    public int getPointNumber() {
        return PointNumber;
    }

    public void setPointNumber(int PointNumber) {
        this.PointNumber = PointNumber;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int ActivityId) {
        this.ActivityId = ActivityId;
    }

    public int getActionID() {
        return ActionID;
    }

    public void setActionID(int ActionID) {
        this.ActionID = ActionID;
    }

    public Object getExt() {
        return Ext;
    }

    public void setExt(Object Ext) {
        this.Ext = Ext;
    }

    public List<String> getPropTexts() {
        return PropTexts;
    }

    public void setPropTexts(List<String> PropTexts) {
        this.PropTexts = PropTexts;
    }

    public List<String> getImages() {
        return Images;
    }

    public void setImages(List<String> Images) {
        this.Images = Images;
    }
}
