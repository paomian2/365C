package com.a365vintagewine.mvp.fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.OrderListAdapter;
import com.a365vintagewine.mvp.model.bean.B2COrderBean;
import com.a365vintagewine.mvp.model.bean.PayMentByAppBean;
import com.a365vintagewine.mvp.presenter.order.OrderListPresenter;
import com.a365vintagewine.mvp.view.order.OrderListView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 订单列表
 */
public class OrderListFragment extends BaseMVPFragment<OrderListPresenter> implements OrderListView {

    @Bind(R.id.lv_orderlist)
    ListView lvOrderlist;
    @Bind(R.id.sf_orderlist)
    SwipeRefreshLayout sfOrderlist;

    private OrderListAdapter adapter;


    private String orderStatus;

    @Override
    protected OrderListPresenter createPresenter() {
        return new OrderListPresenter(this);
    }


    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        if (bundle!=null){
            orderStatus=bundle.getString("orderStatus");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_order_list, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        adapter = new OrderListAdapter(activity);
        lvOrderlist.setAdapter(adapter);
        adapter.setOnB2COrderClickListener(mOnB2COrderClickListener);
    }

    @Override
    public void initData() {

    }

    @Override
    public BaseActivity getMyContext() {
        return activity;
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void GetUserOrderList() {
        Map<String,Object> params=new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Status", orderStatus);

    }

    @Override
    public void GetUserOrderListResult(boolean success, String msg, List<B2COrderBean> list) {

    }

    @Override
    public void CanceledOrder(String Order_Id) {

    }

    @Override
    public void CanceledOrderResult(boolean success, String msg) {

    }

    @Override
    public void ConfirmOrder(String Order_Id) {

    }

    @Override
    public void ConfirmOrderResult(boolean success, String msg) {

    }

    @Override
    public void OrderBuyAgain(String Order_Id) {

    }

    @Override
    public void OrderBuyAgainResult(boolean success, String msg) {

    }

    @Override
    public void onOrderPay(String Order_Id) {

    }

    @Override
    public void onOrderPayResult(boolean success, String msg, PayMentByAppBean payMentByAppBean) {

    }

    @Override
    public void onOrderRemand(String Order_Id) {

    }

    @Override
    public void onOrderRemandResult(boolean success, String msg) {

    }

    @Override
    public void onOrderApplayRefund() {

    }

    @Override
    public void onOrderApplayRefundResult(boolean success, String msg) {

    }



    /**订单点击事件监听*/
    private OrderListAdapter.OnB2COrderClickListener mOnB2COrderClickListener=new OrderListAdapter.OnB2COrderClickListener(){


        //取消订单
        @Override
        public void onOrderCancel(B2COrderBean b2COrderBean) {

        }

        //付款
        @Override
        public void onOrderPay(B2COrderBean b2COrderBean) {

        }

        //催单
        @Override
        public void onOrderRemand(B2COrderBean b2COrderBean) {

        }

        //申请退款
        @Override
        public void onOrderApplayRefund(B2COrderBean b2COrderBean) {

        }

        //查看物流
        @Override
        public void onLookShipped(B2COrderBean b2COrderBean) {

        }

        //确认收货
        @Override
        public void onConfirmRecive(B2COrderBean b2COrderBean) {

        }

        //再次购买
        @Override
        public void onBuyAgain(B2COrderBean b2COrderBean) {

        }

        //评论
        @Override
        public void onEvaluation(B2COrderBean b2COrderBean) {

        }

        //退款详情
        @Override
        public void onRefundDetail(B2COrderBean b2COrderBean) {

        }

        //订单详情
        @Override
        public void onOrderDetail(B2COrderBean b2COrderBean) {

        }
    };
}
