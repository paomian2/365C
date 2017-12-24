package com.a365vintagewine.mvp.view.order;
import com.a365vintagewine.mvp.model.bean.B2COrderBean;
import com.a365vintagewine.mvp.model.bean.PayMentByAppBean;
import com.commsdk.base.view.BaseView;
import java.util.List;

/**
 * B2C订单列表
 */

public interface OrderListView extends BaseView {

    /**订单列表*/
    void GetUserOrderList();
    /**订单列表结果回调*/
    void GetUserOrderListResult(boolean success, String msg, List<B2COrderBean> list);
    /**取消订单*/
    void CanceledOrder(String Order_Id);
    /**取消订单结果回调*/
    void CanceledOrderResult(boolean success,String msg);
    /**确认收货*/
    void ConfirmOrder(String Order_Id);
    /**确认收货结果回调*/
    void ConfirmOrderResult(boolean success,String msg);
    /**再来一单*/
    void OrderBuyAgain(String Order_Id);
    /**再来一单结果回调*/
    void OrderBuyAgainResult(boolean success,String msg);
    /**预支付*/
    void onOrderPay(String Order_Id);
    /**预支付结果回调*/
    void onOrderPayResult(boolean success, String msg, PayMentByAppBean payMentByAppBean);
    /**催单*/
    void onOrderRemand(String Order_Id);
    /**催单结果回调*/
    void onOrderRemandResult(boolean success, String msg);
    /**申请退款*/
    void onOrderApplayRefund();
    /**申请退款结果回调*/
    void onOrderApplayRefundResult(boolean success,String msg);

}
