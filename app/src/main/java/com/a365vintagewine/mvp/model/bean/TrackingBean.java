package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：订单跟踪实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:02
 * 版本：V1.0
 */
public class TrackingBean {

    private String TrackingDesc;
    private String TrackingDate;

    public String getTrackingDesc() {
        return TrackingDesc;
    }

    public void setTrackingDesc(String trackingDesc) {
        TrackingDesc = trackingDesc;
    }

    public String getTrackingDate() {
        return TrackingDate;
    }

    public void setTrackingDate(String trackingDate) {
        TrackingDate = trackingDate;
    }
}
