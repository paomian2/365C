package com.a365vintagewine.mvp.activity.order;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.OrderDetailAdapter;
import com.a365vintagewine.mvp.presenter.order.OrderDetailPresenter;
import com.a365vintagewine.mvp.view.order.OrderDetailView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseMVPActivity<OrderDetailPresenter> implements OrderDetailView {

    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.tv_orderDetail_orderstatus)
    TextView tvOrderDetailOrderstatus; //订单状态
    @Bind(R.id.tv_orderDetail_orderdescribe)
    TextView tvOrderDetailOrderdescribe; //订单状态描述
    @Bind(R.id.btn_order_detail_cancleOrder)
    Button btnOrderDetailCancleOrder; //取消订单按钮
    @Bind(R.id.btn_order_detail_payment)
    Button btnOrderDetailPayment; //待支付订单支付按钮
    @Bind(R.id.ll_order_detail_payment)
    LinearLayout llOrderDetailPayment; //待支付订单状态模块
    @Bind(R.id.btn_order_detail_shipment_pending_cancleOrder)
    Button btnOrderDetailShipmentPendingCancleOrder; //待发货状态取消订单
    @Bind(R.id.btn_order_detail_reminder)
    Button btnOrderDetailReminder; //订单待发货状态催单
    @Bind(R.id.ll_order_detail_shipment_pending)
    LinearLayout llOrderDetailShipmentPending; //待发货状态模块
    @Bind(R.id.btn_order_detail_apply_refund)
    Button btnOrderDetailApplyRefund; //订单申请退款
    @Bind(R.id.btn_order_detail_cancle_refund)
    Button btnOrderDetailCancleRefund; //订单取消退款
    @Bind(R.id.btn_order_detail_confirm_receipt)
    Button btnOrderDetailConfirmReceipt; //确认收货
    @Bind(R.id.ll_order_detail_shipment)
    LinearLayout llOrderDetailShipment; //
    @Bind(R.id.btn_order_detail_again_single)
    Button btnOrderDetailAgainSingle;
    @Bind(R.id.btn_order_detail_evaluate)
    Button btnOrderDetailEvaluate;
    @Bind(R.id.ll_order_detail_evaluate)
    LinearLayout llOrderDetailEvaluate;
    @Bind(R.id.btn_order_detail_again_single2)
    Button btnOrderDetailAgainSingle2;
    @Bind(R.id.ll_order_detail_again_single)
    LinearLayout llOrderDetailAgainSingle;
    @Bind(R.id.img_order_detail_shopimg)
    CircleImageView imgOrderDetailShopimg;
    @Bind(R.id.tv_order_detail_shopname)
    TextView tvOrderDetailShopname;
    @Bind(R.id.lv_order_detail)
    ListView lvOrderDetail;
    @Bind(R.id.tv_order_detail_deliveryfee)
    TextView tvOrderDetailDeliveryfee;
    @Bind(R.id.tv_order_detail_orderprice)
    TextView tvOrderDetailOrderprice;
    @Bind(R.id.btn_order_detail_contact_shop)
    Button btnOrderDetailContactShop;
    @Bind(R.id.tv_order_detail_buyers_name)
    TextView tvOrderDetailBuyersName;
    @Bind(R.id.tv_order_detail_buyers_phone)
    TextView tvOrderDetailBuyersPhone;
    @Bind(R.id.tv_order_detail_distribution)
    TextView tvOrderDetailDistribution;
    @Bind(R.id.order_detail_orderNo)
    TextView orderDetailOrderNo;
    @Bind(R.id.order_detail_orderTime)
    TextView orderDetailOrderTime;
    @Bind(R.id.order_detail_payStatus)
    TextView orderDetailPayStatus;
    @Bind(R.id.order_detail_remarks)
    TextView orderDetailRemarks;


    private OrderDetailAdapter adapter;
    @Override
    protected OrderDetailPresenter createPresenter() {
        return new OrderDetailPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_order_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("订单详情");
        adapter = new OrderDetailAdapter(activity);
        lvOrderDetail.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lvOrderDetail);
    }

    //解决ScrollView嵌套ListView只显示一行
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        if (adapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = adapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = adapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

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

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

}
