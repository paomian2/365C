package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月04日  12:50
 * 版本：3.0
 */

public class GoosBean {

    private String id= StringUtils.EMPTY;
    private String name=StringUtils.EMPTY;
    private String price=StringUtils.EMPTY;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
