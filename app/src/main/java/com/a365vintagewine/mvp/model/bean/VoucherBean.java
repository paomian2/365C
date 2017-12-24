package com.a365vintagewine.mvp.model.bean;
/**
 * 功能描述:
 * 作者：Linxz
 * E-mail：lin_xiao_zhang@13.com
 * 版本信息：V1.0.0
 * 时间：2017年04月11日  11:47.
 **/
public class VoucherBean {


     /**优惠券Id*/
     private String MemberCoupons_Id;
     /**优惠券名称*/
     private String CouponName;
     /**优惠券号*/
     private String CouponNo;
     /**满额限制*/
     private String ConditionValue;
     /**优惠券金额*/
     private String CouponValue;
     /**优惠券描述*/
     private String CouponDesc;
     /**开始日期*/
     private String BeginDate;
     /**结束日期*/
     private String EndDate;
     /**商家id*/
     private String Consignor_Id;
     /**商家类型*/
     private String ConsignorType;
     /**是否可使用*/
     private int IsEnable;


    public String getMemberCoupons_Id() {
        return MemberCoupons_Id;
    }

    public void setMemberCoupons_Id(String memberCoupons_Id) {
        MemberCoupons_Id = memberCoupons_Id;
    }

    public String getCouponName() {
        return CouponName;
    }

    public void setCouponName(String couponName) {
        CouponName = couponName;
    }

    public String getCouponNo() {
        return CouponNo;
    }

    public void setCouponNo(String couponNo) {
        CouponNo = couponNo;
    }

    public String getConditionValue() {
        return ConditionValue;
    }

    public void setConditionValue(String conditionValue) {
        ConditionValue = conditionValue;
    }

    public String getCouponValue() {
        return CouponValue;
    }

    public void setCouponValue(String couponValue) {
        CouponValue = couponValue;
    }

    public String getCouponDesc() {
        return CouponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        CouponDesc = couponDesc;
    }

    public String getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(String beginDate) {
        BeginDate = beginDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getConsignor_Id() {
        return Consignor_Id;
    }

    public void setConsignor_Id(String consignor_Id) {
        Consignor_Id = consignor_Id;
    }

    public String getConsignorType() {
        return ConsignorType;
    }

    public void setConsignorType(String consignorType) {
        ConsignorType = consignorType;
    }

    public int getIsEnable() {
        return IsEnable;
    }

    public void setIsEnable(int isEnable) {
        IsEnable = isEnable;
    }
}
