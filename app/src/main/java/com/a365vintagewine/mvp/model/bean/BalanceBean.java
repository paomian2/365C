package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：整体余额信息
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  13:13
 * 版本：3.0
 */

public class BalanceBean {

    /**整体余额*/
    private double TotalBalance;
    /**平台余额*/
    private double PlatformBalance;
    /**充值余额*/
    private double TakeItBalance;
    /**商家余额*/
    private double ConsignorBalance;

    public double getTotalBalance() {
        return TotalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        TotalBalance = totalBalance;
    }

    public double getPlatformBalance() {
        return PlatformBalance;
    }

    public void setPlatformBalance(double platformBalance) {
        PlatformBalance = platformBalance;
    }

    public double getTakeItBalance() {
        return TakeItBalance;
    }

    public void setTakeItBalance(double takeItBalance) {
        TakeItBalance = takeItBalance;
    }

    public double getConsignorBalance() {
        return ConsignorBalance;
    }

    public void setConsignorBalance(double consignorBalance) {
        ConsignorBalance = consignorBalance;
    }
}
