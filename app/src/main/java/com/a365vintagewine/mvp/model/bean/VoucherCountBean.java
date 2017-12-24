package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  14:49
 * 版本：V1.0
 */
public class VoucherCountBean {


    /**未使用*/
    private String NotUsedCouponNum;
    /**y已使用*/
    private String UsedCouponNum;
    /**已过期*/
    private String ExpiredCouponNum;

    public String getNotUsedCouponNum() {
        return NotUsedCouponNum;
    }

    public void setNotUsedCouponNum(String notUsedCouponNum) {
        NotUsedCouponNum = notUsedCouponNum;
    }

    public String getUsedCouponNum() {
        return UsedCouponNum;
    }

    public void setUsedCouponNum(String usedCouponNum) {
        UsedCouponNum = usedCouponNum;
    }

    public String getExpiredCouponNum() {
        return ExpiredCouponNum;
    }

    public void setExpiredCouponNum(String expiredCouponNum) {
        ExpiredCouponNum = expiredCouponNum;
    }
}
