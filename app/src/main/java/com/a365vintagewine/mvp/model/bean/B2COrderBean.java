package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：B2C订单实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  12:22
 * 版本：V1.0
 */
public class B2COrderBean {

    /**订单Id*/
    private int Order_Id;
    /**订单号*/
    private String OrderCode;
    /**货主ID*/
    private int Consignor_Id;
    /**货主编号*/
    private String ConsignorCode;
    /**货主名称*/
    private String ConsignorName;
    /**货主头像*/
    private String StoreLogo;
    /**合计数量*/
    private int TotalQuantityOrder;
    /**合计（实收金额）*/
    private double GrandTotal;
    /**客户订单状态*/
    private String ClientStatus;
    /**付款完成*/
    private String FinStatusText;
    /**支付方式*/
    private String PayMode;
    /**支付名称*/
    private String PayModeName;
    /**待付款倒计时*/
    private int CountDownPayTime;
    /**是否可以评价 1:可以 0：不可以*/
    private int IsComment;
    /**使用积分合计*/
    private int TotalUsedPoint;
    /**商家电话*/
    private String Tel;
    /**期望送达时间*/
    private String ExpectedTime;
    /**收货人姓名*/
    private String ShippingName;
    /**收货人手机号*/
    private String Mobile;
    /**配送地址*/
    private String ShippingAddress;
    /**配送方式*/
    private String Delivery_Name;
    /**下单时间*/
    private String CreateDate;
    /**商品总金额*/
    private double SubTotal;
    /**配送费*/
    private double ShippingAmount;
    /**平台使用额*/
    private double UsedBalance;
    /**商家余额*/
    private double UsedDealerBalance;
    /**代金券*/
    private double CouponPrice;
    /**折扣金额*/
    private double DiscountAmount;
    /**优惠金额*/
    private double PreferentialAmount;
    /**奖励*/
    private String Reward;
    /**发票*/
    private String Invoice;
    /**备注*/
    private String Remark;
    /**控件点击事件*/
    private List<B2COrderBean> ButtonList;
    /**商品列表*/
    private List<B2COrderGoodsBean> Items;


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

    public int getTotalQuantityOrder() {
        return TotalQuantityOrder;
    }

    public void setTotalQuantityOrder(int totalQuantityOrder) {
        TotalQuantityOrder = totalQuantityOrder;
    }

    public double getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        GrandTotal = grandTotal;
    }

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public String getFinStatusText() {
        return FinStatusText;
    }

    public void setFinStatusText(String finStatusText) {
        FinStatusText = finStatusText;
    }

    public String getPayMode() {
        return PayMode;
    }

    public void setPayMode(String payMode) {
        PayMode = payMode;
    }

    public String getPayModeName() {
        return PayModeName;
    }

    public void setPayModeName(String payModeName) {
        PayModeName = payModeName;
    }

    public int getCountDownPayTime() {
        return CountDownPayTime;
    }

    public void setCountDownPayTime(int countDownPayTime) {
        CountDownPayTime = countDownPayTime;
    }

    public int getIsComment() {
        return IsComment;
    }

    public void setIsComment(int isComment) {
        IsComment = isComment;
    }

    public int getTotalUsedPoint() {
        return TotalUsedPoint;
    }

    public void setTotalUsedPoint(int totalUsedPoint) {
        TotalUsedPoint = totalUsedPoint;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getExpectedTime() {
        return ExpectedTime;
    }

    public void setExpectedTime(String expectedTime) {
        ExpectedTime = expectedTime;
    }

    public String getShippingName() {
        return ShippingName;
    }

    public void setShippingName(String shippingName) {
        ShippingName = shippingName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public String getDelivery_Name() {
        return Delivery_Name;
    }

    public void setDelivery_Name(String delivery_Name) {
        Delivery_Name = delivery_Name;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double subTotal) {
        SubTotal = subTotal;
    }

    public double getShippingAmount() {
        return ShippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        ShippingAmount = shippingAmount;
    }

    public double getUsedBalance() {
        return UsedBalance;
    }

    public void setUsedBalance(double usedBalance) {
        UsedBalance = usedBalance;
    }

    public double getUsedDealerBalance() {
        return UsedDealerBalance;
    }

    public void setUsedDealerBalance(double usedDealerBalance) {
        UsedDealerBalance = usedDealerBalance;
    }

    public double getCouponPrice() {
        return CouponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        CouponPrice = couponPrice;
    }

    public double getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        DiscountAmount = discountAmount;
    }

    public double getPreferentialAmount() {
        return PreferentialAmount;
    }

    public void setPreferentialAmount(double preferentialAmount) {
        PreferentialAmount = preferentialAmount;
    }

    public String getReward() {
        return Reward;
    }

    public void setReward(String reward) {
        Reward = reward;
    }

    public String getInvoice() {
        return Invoice;
    }

    public void setInvoice(String invoice) {
        Invoice = invoice;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public List<B2COrderBean> getButtonList() {
        return ButtonList;
    }

    public void setButtonList(List<B2COrderBean> buttonList) {
        ButtonList = buttonList;
    }

    public List<B2COrderGoodsBean> getItems() {
        return Items;
    }

    public void setItems(List<B2COrderGoodsBean> items) {
        Items = items;
    }
}
