package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：产品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月20日  0:39
 * 版本：V1.0
 */
public class ProductLibBean {

    /**产品Id*/
    private int ProductLib_Id;
    /**产品编号*/
    private String ProductLibCode;
    /**产品名称*/
    private String ProductLibName;
    /**产品图片*/
    private String ProductLibUrl;

    public int getProductLib_Id() {
        return ProductLib_Id;
    }

    public void setProductLib_Id(int ProductLib_Id) {
        this.ProductLib_Id = ProductLib_Id;
    }

    public String getProductLibCode() {
        return ProductLibCode;
    }

    public void setProductLibCode(String ProductLibCode) {
        this.ProductLibCode = ProductLibCode;
    }

    public String getProductLibName() {
        return ProductLibName;
    }

    public void setProductLibName(String ProductLibName) {
        this.ProductLibName = ProductLibName;
    }

    public String getProductLibUrl() {
        return ProductLibUrl;
    }

    public void setProductLibUrl(String ProductLibUrl) {
        this.ProductLibUrl = ProductLibUrl;
    }
}
