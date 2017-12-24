package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  17:37
 * 版本：V1.0
 */
public class BanlanceOrderBean {

    /**用户ID*/
    private int Client_Id;
    /**头像*/
    private String HeadImgUrl;
    /**金额*/
    private double Balance;
    /**日期*/
    private String BalanceDate;
    /**主标题*/
    private String MainTitle;
    /**副标题*/
    private String Subtitle;

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

    public String getHeadImgUrl() {
        return HeadImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        HeadImgUrl = headImgUrl;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getBalanceDate() {
        return BalanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        BalanceDate = balanceDate;
    }

    public String getMainTitle() {
        return MainTitle;
    }

    public void setMainTitle(String mainTitle) {
        MainTitle = mainTitle;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }
}
