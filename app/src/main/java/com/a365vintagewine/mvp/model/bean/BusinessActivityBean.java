package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：活动实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  11:45
 * 版本：3.0
 */

public class BusinessActivityBean {

    /**活动图片*/
    private String ActivityIco;
    /**活动描述*/
    private String ActivityDesc;

    public String getActivityIco() {
        return ActivityIco;
    }

    public void setActivityIco(String ActivityIco) {
        this.ActivityIco = ActivityIco;
    }

    public String getActivityDesc() {
        return ActivityDesc;
    }

    public void setActivityDesc(String ActivityDesc) {
        this.ActivityDesc = ActivityDesc;
    }
}
