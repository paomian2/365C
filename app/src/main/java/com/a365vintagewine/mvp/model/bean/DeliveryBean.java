package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月19日  15:53
 * 版本：V1.0
 */
public class DeliveryBean {

    private String id= StringUtils.EMPTY;
    private String name=StringUtils.EMPTY;
    //前端使用，是否选中
    private boolean isSelect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
