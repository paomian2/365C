package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class ProfitDetail {
    private String profitType;
    private String profitTime;
    private double profitPrice;

    public String getProfitType() {
        return profitType;
    }

    public void setProfitType(String profitType) {
        this.profitType = profitType;
    }

    public String getProfitTime() {
        return profitTime;
    }

    public void setProfitTime(String profitTime) {
        this.profitTime = profitTime;
    }

    public double getProfitPrice() {
        return profitPrice;
    }

    public void setProfitPrice(double profitPrice) {
        this.profitPrice = profitPrice;
    }

    public ProfitDetail(String profitType, String profitTime, double profitPrice) {
        this.profitType = profitType;
        this.profitTime = profitTime;
        this.profitPrice = profitPrice;
    }

    public ProfitDetail() {
    }
}
