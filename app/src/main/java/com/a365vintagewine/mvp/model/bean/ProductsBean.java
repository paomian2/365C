package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.NumberUtils;
import com.commsdk.common.StringUtils;

/**
 * 描述：商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  13:33
 * 版本：3.0
 */

public class ProductsBean {


    /**商品编号*/
    private String Code;
    /**商品售价*/
    private String VipPrice;
    /**商品价*/
    private String SalePrice;
    /**关键字*/
    private String Keyword;
    /**品牌Id*/
    private int BrandId;
    /**品牌名称*/
    private String BrandName;
    /**分类Id：一级->二级->三级*/
    private String TypeIdPath;
    /**分类名称*/
    private String TypeNamePath;
    /**支持的配送方式1,2,3 上门自取,商家自送,第三方配送*/
    private String DeliveryIdPath;
    /**支持的配送方式1,2,3 上门自取,商家自送,第三方配送*/
    private String DeliveryNamePath;
    /**商家Id*/
    private int VendorId;
    /**商家名称*/
    private String VendorName;
    /**入驻时间*/
    private String CreatedOn;
    /**最后编辑时间*/
    private String ModifiedOn;
    /**商品Id*/
    private int Id;
    /**商品名称*/
    private String Name;
    /**商品图片*/
    private String Image;
    /**经度*/
    private double Lng;
    /**纬度*/
    private double Lat;
    /**距离*/
    private String Distance;
    /**已售数量*/
    private int SaleCount;
    /**评论数量*/
    private int CommentCount;
    /**配送范围 单位km*/
    private double DisScope;
    /**商品或店铺扩展信息*/
    private Object Ext;

    //热销推荐商品属性

    /**商品Id*/
    private String Product_Id;
    /**商品编号*/
    private String ProductCode;
    /**商品名称*/
    private String ProductName;
    /**图片地址*/
    private String PicURL;

    /**商品活动类型(1:普通商品，2：限制折扣，3：满减活动，8：积分兑换活动)*/
    private int ActivityId=1;
    /**活动ID*/
    private int ActionID=0;



    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getVipPrice() {
        if (StringUtils.isEmpty(VipPrice))
            return "0.00";
        VipPrice=VipPrice.replace(",","");
        return NumberUtils.sacleNumber2(VipPrice,2);
    }

    public void setVipPrice(String vipPrice) {
        VipPrice = vipPrice;
    }

    public String getSalePrice() {
        if (StringUtils.isEmpty(SalePrice))
            return "0.00";
        SalePrice=SalePrice.replace(",","");
        return NumberUtils.sacleNumber2(SalePrice,2);
    }

    public void setSalePrice(String salePrice) {
        SalePrice = salePrice;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getTypeIdPath() {
        return TypeIdPath;
    }

    public void setTypeIdPath(String typeIdPath) {
        TypeIdPath = typeIdPath;
    }

    public String getTypeNamePath() {
        return TypeNamePath;
    }

    public void setTypeNamePath(String typeNamePath) {
        TypeNamePath = typeNamePath;
    }

    public String getDeliveryIdPath() {
        return DeliveryIdPath;
    }

    public void setDeliveryIdPath(String deliveryIdPath) {
        DeliveryIdPath = deliveryIdPath;
    }

    public String getDeliveryNamePath() {
        return DeliveryNamePath;
    }

    public void setDeliveryNamePath(String deliveryNamePath) {
        DeliveryNamePath = deliveryNamePath;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getModifiedOn() {
        return ModifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        ModifiedOn = modifiedOn;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double lng) {
        Lng = lng;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public int getSaleCount() {
        return SaleCount;
    }

    public void setSaleCount(int saleCount) {
        SaleCount = saleCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public double getDisScope() {
        return DisScope;
    }

    public void setDisScope(double disScope) {
        DisScope = disScope;
    }

    public Object getExt() {
        return Ext;
    }

    public void setExt(Object ext) {
        Ext = ext;
    }

    public String getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(String product_Id) {
        Product_Id = product_Id;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPicURL() {
        return PicURL;
    }

    public void setPicURL(String picURL) {
        PicURL = picURL;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public int getActionID() {
        return ActionID;
    }

    public void setActionID(int actionID) {
        ActionID = actionID;
    }
}
