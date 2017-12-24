package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class IntegralDetail {
    private String integralSource;
    private String integralNum;
    private String orderNo;
    private String orderTime;

    public String getIntegralSource() {
        return integralSource;
    }

    public void setIntegralSource(String integralSource) {
        this.integralSource = integralSource;
    }

    public String getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(String integralNum) {
        this.integralNum = integralNum;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public IntegralDetail(String integralSource, String integralNum, String orderNo, String orderTime) {
        this.integralSource = integralSource;
        this.integralNum = integralNum;
        this.orderNo = orderNo;
        this.orderTime = orderTime;
    }

    public IntegralDetail() {
    }
}
