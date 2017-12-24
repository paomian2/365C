package com.a365vintagewine.mvp.presenter.order;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.OrderListViewModel;
import com.a365vintagewine.mvp.view.order.OrderListView;
import com.commsdk.base.presenter.BasePresenter;

import java.util.Map;

/**
 * B2C订单列表
 */

public class OrderListPresenter extends BasePresenter<OrderListView,CmsContentModel>{


    public OrderListPresenter(OrderListView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }


    /**订单列表*/
    public void GetUserOrderList(Map<String,Object> params){

    }


    /**取消订单*/
    public void CanceledOrder(Map<String,Object> params){

    }


    /**确认收货*/
    public void ConfirmOrder(Map<String,Object> params){

    }


    /**再来一单*/
    public void OrderBuyAgain(Map<String,Object> params){

    }


    /**预支付*/
    public void onOrderPay(Map<String,Object> params){

    }


    /**催单*/
    public void onOrderRemand(Map<String,Object> params){

    }


    /**申请退款*/
    public void onOrderApplayRefund(Map<String,Object> params){

    }
}
