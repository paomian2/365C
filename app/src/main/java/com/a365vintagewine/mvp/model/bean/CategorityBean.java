package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：商品类目
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月13日  22:45
 * 版本：3.0
 */

public class CategorityBean {

    /**分类Id*/
    private Integer Id;
    /**上级Id*/
    private Integer Pid;
    /**分类级别*/
    private Integer Level;
    /**分类名称*/
    private String Name;

    /**商家分类选择专用*/
    private boolean isSelect;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
