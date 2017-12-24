package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：品牌、配送方式
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  18:27
 * 版本：3.0
 */

public class FacetsBean {

    private List<KeyValBean> 品牌;

    private List<KeyValBean> 配送方式;

    public List<KeyValBean> getBranchName() {
        return 品牌;
    }

    public void setBarnchName(List<KeyValBean> barnchName) {
        this.品牌 = barnchName;
    }

    public List<KeyValBean> getDelivryName() {
        return 配送方式;
    }

    public void setDelivryName(List<KeyValBean> delivryName) {
        this.配送方式 = delivryName;
    }
}
