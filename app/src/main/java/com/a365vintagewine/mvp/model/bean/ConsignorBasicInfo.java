package com.a365vintagewine.mvp.model.bean;
import java.util.List;

/**
 * 描述：商家基本信息
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  11:48
 * 版本：3.0
 */

public class ConsignorBasicInfo {

    /**商家Id*/
    private int Consignor_Id;
    /**商家编号*/
    private String ConsignorCode;
    /**商家名称*/
    private String ConsignorName;
    /**门店LOGO*/
    private String StoreLogo;
    /**店铺地址*/
    private String Address;
    /**店铺分数*/
    private String ServiceScore;
    /**商家电话*/
    private String Tel;
    /**营业开始时间*/
    private String BeginBusinessTime;
    /**营业结束时间*/
    private String EndBusinessTime;
    /**配送开始时间*/
    private String BeginDeliveryTime;
    /**配送结束时间*/
    private String EndDeliveryTime;
    /**最小运费*/
    private double LimitFreight;
    /**运费*/
    private double Freight;
    /**是否已收藏*/
    private boolean IsFav;
    /**活动数量*/
    private int ActivityCount;
    /**活动列表*/
    private List<BusinessActivityBean> ActivityList;

    public int getConsignor_Id() {
        return Consignor_Id;
    }

    public void setConsignor_Id(int consignor_Id) {
        Consignor_Id = consignor_Id;
    }

    public String getConsignorCode() {
        return ConsignorCode;
    }

    public void setConsignorCode(String consignorCode) {
        ConsignorCode = consignorCode;
    }

    public String getConsignorName() {
        return ConsignorName;
    }

    public void setConsignorName(String consignorName) {
        ConsignorName = consignorName;
    }

    public String getStoreLogo() {
        return StoreLogo;
    }

    public void setStoreLogo(String storeLogo) {
        StoreLogo = storeLogo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getServiceScore() {
        return ServiceScore;
    }

    public void setServiceScore(String serviceScore) {
        ServiceScore = serviceScore;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getBeginBusinessTime() {
        return BeginBusinessTime;
    }

    public void setBeginBusinessTime(String beginBusinessTime) {
        BeginBusinessTime = beginBusinessTime;
    }

    public String getEndBusinessTime() {
        return EndBusinessTime;
    }

    public void setEndBusinessTime(String endBusinessTime) {
        EndBusinessTime = endBusinessTime;
    }

    public String getBeginDeliveryTime() {
        return BeginDeliveryTime;
    }

    public void setBeginDeliveryTime(String beginDeliveryTime) {
        BeginDeliveryTime = beginDeliveryTime;
    }

    public String getEndDeliveryTime() {
        return EndDeliveryTime;
    }

    public void setEndDeliveryTime(String endDeliveryTime) {
        EndDeliveryTime = endDeliveryTime;
    }

    public double getLimitFreight() {
        return LimitFreight;
    }

    public void setLimitFreight(double limitFreight) {
        LimitFreight = limitFreight;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    public boolean isFav() {
        return IsFav;
    }

    public void setFav(boolean fav) {
        IsFav = fav;
    }

    public int getActivityCount() {
        return ActivityCount;
    }

    public void setActivityCount(int activityCount) {
        ActivityCount = activityCount;
    }

    public List<BusinessActivityBean> getActivityList() {
        return ActivityList;
    }

    public void setActivityList(List<BusinessActivityBean> activityList) {
        ActivityList = activityList;
    }
}
