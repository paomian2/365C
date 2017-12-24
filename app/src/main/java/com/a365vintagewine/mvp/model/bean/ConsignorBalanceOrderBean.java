package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：商家余额明显
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  17:44
 * 版本：V1.0
 */
public class ConsignorBalanceOrderBean {

    private int Client_Id;
    private int Consignor_Id;
    private String ConsignorCode;
    private String ConsignorName;
    private String ConsignorImg;
    private String ConsignorType;
    private double Balance;

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

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

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
