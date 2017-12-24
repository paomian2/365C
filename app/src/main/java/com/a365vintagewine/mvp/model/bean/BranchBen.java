package com.a365vintagewine.mvp.model.bean;

import java.io.Serializable;

/**
 * 描述：品牌
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月18日  10:03
 * 版本：V1.0
 */
public class BranchBen implements Serializable{

    /**品牌ID*/
    private int Brand_Id;
    /**品牌名称*/
    private String BrandNameCn;
    /**品牌Logo*/
    private String Logo;
    /**类别ID*/
    private int Type_Id;
    /**前端筛选专用*/
    private boolean isSelect;

    public int getBrand_Id() {
        return Brand_Id;
    }

    public void setBrand_Id(int brand_Id) {
        Brand_Id = brand_Id;
    }

    public String getBrandNameCn() {
        return BrandNameCn;
    }

    public void setBrandNameCn(String brandNameCn) {
        BrandNameCn = brandNameCn;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public int getType_Id() {
        return Type_Id;
    }

    public void setType_Id(int type_Id) {
        Type_Id = type_Id;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
