package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：订单跟踪
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:03
 * 版本：V1.0
 */
public class OrderTrackBean {

    private int Order_Id;
    private String OrderCode;
    private int Consignor_Id;
    private String ConsignorCode;
    private String ConsignorName;
    private String StoreLogo;
    private String ClientStatus;
    private String PayModeName;
    private String ExpectedTime;
    private String Delivery_Name;
    private String CreateDate;
    private List<TrackingBean> TrackingList;

    public void setOrder_Id(int order_Id) {
        Order_Id = order_Id;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public void setConsignor_Id(int consignor_Id) {
        Consignor_Id = consignor_Id;
    }

    public void setConsignorCode(String consignorCode) {
        ConsignorCode = consignorCode;
    }

    public void setConsignorName(String consignorName) {
        ConsignorName = consignorName;
    }

    public void setStoreLogo(String storeLogo) {
        StoreLogo = storeLogo;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public void setPayModeName(String payModeName) {
        PayModeName = payModeName;
    }

    public void setExpectedTime(String expectedTime) {
        ExpectedTime = expectedTime;
    }

    public void setDelivery_Name(String delivery_Name) {
        Delivery_Name = delivery_Name;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public void setTrackingList(List<TrackingBean> trackingList) {
        TrackingList = trackingList;
    }
}
