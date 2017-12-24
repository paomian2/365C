package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

import java.io.Serializable;

/**
 * 描述：积分实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  14:51
 * 版本：3.0
 */

public class PointBean implements Serializable{



    private int Consignor_Id;
    /**商家code*/
    private String ConsignorCode= StringUtils.EMPTY;
    /**商家名称*/
    private String ConsignorName=StringUtils.EMPTY;
    /**商家店铺名称*/
    private String ConsignorImg=StringUtils.EMPTY;
    /**商家店铺类型*/
    private String ConsignorType=StringUtils.EMPTY;
    /**类型*/
    private String RecordType=StringUtils.EMPTY;
    /**单号*/
    private String OrderCode=StringUtils.EMPTY;
    /**积分*/
    private int Point;
    /**日期*/
    private String PointDate=StringUtils.EMPTY;
    /**描述*/
    private String PointDesc=StringUtils.EMPTY;

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

    public String getConsignorImg() {
        return ConsignorImg;
    }

    public void setConsignorImg(String consignorImg) {
        ConsignorImg = consignorImg;
    }

    public String getConsignorType() {
        return ConsignorType;
    }

    public void setConsignorType(String consignorType) {
        ConsignorType = consignorType;
    }

    public String getRecordType() {
        return RecordType;
    }

    public void setRecordType(String recordType) {
        RecordType = recordType;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public String getPointDate() {
        return PointDate;
    }

    public void setPointDate(String pointDate) {
        PointDate = pointDate;
    }

    public String getPointDesc() {
        return PointDesc;
    }

    public void setPointDesc(String pointDesc) {
        PointDesc = pointDesc;
    }
}
