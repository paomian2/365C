package com.a365vintagewine.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.B2CButton;
import com.a365vintagewine.mvp.model.bean.B2COrderBean;
import com.a365vintagewine.mvp.model.bean.B2COrderGoodsBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 订单列表
 */

public class OrderListAdapter extends BaseAdapter2<B2COrderBean> {

    public OrderListAdapter(Context context) {
        super(context);
    }


    private OnB2COrderClickListener onB2COrderClickListener;

    public void setOnB2COrderClickListener(OnB2COrderClickListener onB2COrderClickListener) {
        this.onB2COrderClickListener = onB2COrderClickListener;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_order_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        B2COrderBean b2COrderBean = getItem(position);
        viewHolder.tvShopName.setText(b2COrderBean.getConsignorName());
        //活动标签
        viewHolder.tvActLable.setText("活动标签~~~");
        viewHolder.tvOrderStatus.setText(b2COrderBean.getClientStatus());
        viewHolder.tvTime.setText(b2COrderBean.getCountDownPayTime());
        //设置商品
        setOrderGoodsList(viewHolder, b2COrderBean);
        //设置状态
        setOrderStatus(viewHolder, b2COrderBean);
        return convertView;
    }


    /**
     * 设置商品
     */
    private void setOrderGoodsList(final ViewHolder viewHolder, final B2COrderBean b2COrderBean) {
        if (b2COrderBean.getItems() == null || b2COrderBean.getItems().size() == 0) {
            return;
        }
        viewHolder.layoutGoodsList.removeAllViews();
        for (B2COrderGoodsBean b2COrderGoodsBean : b2COrderBean.getItems()) {
            View goodsView = inflater.inflate(R.layout.item_b2c_order_goods, null);
            ImageView imgGoods = (ImageView) goodsView.findViewById(R.id.imgGoods);
            TextView tvGoodsName = (TextView) goodsView.findViewById(R.id.tvGoodsName);
            TextView tvGoodsPrice = (TextView) goodsView.findViewById(R.id.tvGoodsPrice);
            TextView tvGoodsQuantity = (TextView) goodsView.findViewById(R.id.tvGoodsQuantity);
            UIHelper.imageNet(context, b2COrderGoodsBean.getProductImgUrl(), imgGoods, false, R.mipmap.img_def);
            tvGoodsName.setText(b2COrderGoodsBean.getProductName());
            tvGoodsPrice.setText("￥" + b2COrderGoodsBean.getSalePrice());
            tvGoodsQuantity.setText("X" + b2COrderGoodsBean.getQuantityOrder());
            viewHolder.layoutGoodsList.addView(goodsView);
        }
    }

    /**
     * 设置状态
     */
    private void setOrderStatus(final ViewHolder viewHolder, final B2COrderBean b2COrderBean) {

        if (b2COrderBean.getButtonList()!=null || b2COrderBean.getButtonList().size()==0){
            viewHolder.layoutButtonView.setVisibility(View.GONE);
        }else{
            viewHolder.layoutButtonView.setVisibility(View.VISIBLE);
        }

        for (final B2CButton b2CButton:b2COrderBean.getButtonList()){
            View buttonView=inflater.inflate(R.layout.item_b2c_order_button,null);
            Button btnOperator= (Button) buttonView.findViewById(R.id.btnOperation);
            btnOperator.setText(b2CButton.getButton());
            btnOperator.setTag(b2CButton.getButton());
            btnOperator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onB2COrderClickListener==null){
                        return;
                    }
                    String operation= (String) v.getTag();
                    switch (operation){
                        case "order_cancel":
                            onB2COrderClickListener.onOrderCancel(b2COrderBean);
                            break;
                        case "order_pay":
                            onB2COrderClickListener.onOrderPay(b2COrderBean);
                            break;
                        case "order_reminder":
                            onB2COrderClickListener.onOrderRemand(b2COrderBean);
                            break;
                        case "order_confirm":
                            onB2COrderClickListener.onConfirmRecive(b2COrderBean);
                            break;
                        case "order_refund":
                            onB2COrderClickListener.onOrderApplayRefund(b2COrderBean);
                            break;
                        case "order_refunddetails":
                            onB2COrderClickListener.onRefundDetail(b2COrderBean);
                            break;
                        case "order_comment":
                            onB2COrderClickListener.onEvaluation(b2COrderBean);
                            break;
                        case "order_buyagain":
                            onB2COrderClickListener.onBuyAgain(b2COrderBean);
                            break;
                        case "order_logistics":
                            onB2COrderClickListener.onLookShipped(b2COrderBean);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        //订单详情
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onB2COrderClickListener != null) {
                    onB2COrderClickListener.onOrderDetail(b2COrderBean);
                }
            }
        });
    }


    /**
     * 订单点击事件
     */
    public interface OnB2COrderClickListener {
        /**
         * 取消订单
         */
        void onOrderCancel(B2COrderBean b2COrderBean);

        /**
         * 付款
         */
        void onOrderPay(B2COrderBean b2COrderBean);

        /**
         * 催单
         */
        void onOrderRemand(B2COrderBean b2COrderBean);

        /**
         * 申请退款
         */
        void onOrderApplayRefund(B2COrderBean b2COrderBean);

        /**
         * 查看物流
         */
        void onLookShipped(B2COrderBean b2COrderBean);

        /**
         * 确认收货
         */
        void onConfirmRecive(B2COrderBean b2COrderBean);

        /**
         * 再来一单
         */
        void onBuyAgain(B2COrderBean b2COrderBean);

        /**
         * 评价
         */
        void onEvaluation(B2COrderBean b2COrderBean);

        /**
         * 退款详情
         */
        void onRefundDetail(B2COrderBean b2COrderBean);

        /**
         * 查看订单详情
         */
        void onOrderDetail(B2COrderBean b2COrderBean);
    }


    static class ViewHolder {
        /**
         * 店铺名称
         */
        @Bind(R.id.tvShopName)
        TextView tvShopName;
        /**
         * 活动标签
         */
        @Bind(R.id.tvActLable)
        TextView tvActLable;
        /**
         * 订单状态
         */
        @Bind(R.id.tvOrderStatus)
        TextView tvOrderStatus;
        /**
         * 订单时间
         */
        @Bind(R.id.tvTime)
        TextView tvTime;


        /**
         * 商品列表
         */
        @Bind(R.id.layoutGoodsList)
        LinearLayout layoutGoodsList;
        /**
         * 商品数量/商品价格
         */
        @Bind(R.id.tv_order_list_orderInfo)
        TextView tvOrderListOrderInfo;

        /**
         * 订单操作控件
         */
        @Bind(R.id.layoutButtonView)
        LinearLayout layoutButtonView;

        /**
         * 整个控件
         */
        View itemView;

        ViewHolder(View view) {
            this.itemView = view;
            ButterKnife.bind(this, view);
        }
    }
}
