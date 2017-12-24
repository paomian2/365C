package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：评论商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:18
 * 版本：V1.0
 */
public class OrderCommentBean {

    private int Order_Id;
    private String OrderCode;
    private int Consignor_Id;
    private String ConsignorCode;
    private String ConsignorName;
    private String StoreLogo;
    private String ClientStatus;
    private List<CommentProductBean> Products;
    private int ConsignorServiceScore;
    private int ConsignorLogisticsServiceScore;

    public int getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(int order_Id) {
        Order_Id = order_Id;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
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

    public String getStoreLogo() {
        return StoreLogo;
    }

    public void setStoreLogo(String storeLogo) {
        StoreLogo = storeLogo;
    }

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public List<CommentProductBean> getProducts() {
        return Products;
    }

    public void setProducts(List<CommentProductBean> products) {
        Products = products;
    }

    public int getConsignorServiceScore() {
        return ConsignorServiceScore;
    }

    public void setConsignorServiceScore(int consignorServiceScore) {
        ConsignorServiceScore = consignorServiceScore;
    }

    public int getConsignorLogisticsServiceScore() {
        return ConsignorLogisticsServiceScore;
    }

    public void setConsignorLogisticsServiceScore(int consignorLogisticsServiceScore) {
        ConsignorLogisticsServiceScore = consignorLogisticsServiceScore;
    }
}
