package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：经纬度
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月12日  11:58
 * 版本：3.0
 */

public class Geo {

    private double Lng;
    private double Lat;

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
}
