package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：B2C订单商品
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  12:26
 * 版本：V1.0
 */
public class B2COrderGoodsBean {

    /**销售明细ID*/
    private int OrderList_Id;
    /**销售ID*/
    private int Order_Id;
    /**产品ID*/
    private int Product_Id;
    /**编号*/
    private String ProductCode;
    /**产品名称*/
    private String ProductName;
    /**商品图片*/
    private String ProductImgUrl;
    /**订购数量*/
    private int QuantityOrder;
    /**销售售价 （单价）*/
    private double SalePrice;
    /**商品金额(合计)*/
    private double SubTotal;
    /**使用积分 （单价）*/
    private int UsedPoint;
    /**使用积分(合计)*/
    private  int TotalUsedPoint;

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

    public int getUsedPoint() {
        return UsedPoint;
    }

    public void setUsedPoint(int usedPoint) {
        UsedPoint = usedPoint;
    }

    public int getTotalUsedPoint() {
        return TotalUsedPoint;
    }

    public void setTotalUsedPoint(int totalUsedPoint) {
        TotalUsedPoint = totalUsedPoint;
    }
}
