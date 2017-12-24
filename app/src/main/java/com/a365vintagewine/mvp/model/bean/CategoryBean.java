package com.a365vintagewine.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：分类实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月18日  9:50
 * 版本：V1.0
 */
public class CategoryBean implements Serializable{

    /**分类Id*/
    private int Id;
    /**名称*/
    private String Name;
    /**父类Id*/
    private int ParentId;
    /**品牌列表*/
    private List<BranchBen> Brands;
    /**子类*/
    private List<CategoryBean> Children;

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

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int parentId) {
        ParentId = parentId;
    }

    public List<BranchBen> getBrands() {
        return Brands;
    }

    public void setBrands(List<BranchBen> brands) {
        Brands = brands;
    }

    public List<CategoryBean> getChildren() {
        return Children;
    }

    public void setChildren(List<CategoryBean> children) {
        Children = children;
    }
}
