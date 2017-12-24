package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：可评论的商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:09
 * 版本：V1.0
 */
public class CommentProductBean {

    /**明细Id*/
     private int OrderList_Id;
     /**订单Id*/
     private int Order_Id;
     /**商品Id*/
     private int Product_Id;
     /**商品编号*/
     private String ProductCode;
     /**商品名称*/
     private String ProductName;
     /**商品图片*/
     private String ProductImgUrl;
     /**数量*/
     private int QuantityOrder;
     /**单价*/
     private double SalePrice;
     /**合计*/
     private double SubTotal;


    public int getOrderList_Id() {
        return OrderList_Id;
    }

    public void setOrderList_Id(int orderList_Id) {
        OrderList_Id = orderList_Id;
    }

    public int getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(int order_Id) {
        Order_Id = order_Id;
    }

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int product_Id) {
        Product_Id = product_Id;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductImgUrl() {
        return ProductImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        ProductImgUrl = productImgUrl;
    }

    public int getQuantityOrder() {
        return QuantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        QuantityOrder = quantityOrder;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double subTotal) {
        SubTotal = subTotal;
    }
}
