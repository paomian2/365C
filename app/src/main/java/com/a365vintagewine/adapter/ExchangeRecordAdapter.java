package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ExchangeRecord;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class ExchangeRecordAdapter extends BaseAdapter2<ExchangeRecord> {
    public ExchangeRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_exchange_record, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ExchangeRecord order = getItem(position);
        viewHolder.tvExchangeRecordGoodsdnum.setText("X"+order.getGoodsnum());
        viewHolder.tvExchangeRecordGoodsname.setText(order.getGoodsName());
        viewHolder.tvExchangeRecordIntegral.setText(order.getGoodsIntegral()+"积分");
        viewHolder.tvExchangeRecordShopname.setText(order.getShopname());
        viewHolder.tvExchangeRecordOrderInfo.setText("共"+order.getSumGoodsnum()+"件，实付"+order.getSumGoodsIntegral()+"积分");
        UIHelper.imageNet(context,order.getImgUrl(),viewHolder.imgExchangeRecordGoodsImg,true);
        switch(order.getOrderstatus()){
            case 1:  //待付款状态订单
                viewHolder.tvExchangeRecordOrderstatus.setText("待付款");
                viewHolder.llExchangeRecordPayment.setVisibility(View.VISIBLE);
                viewHolder.llExchangeRecordGoodsreceipt.setVisibility(View.GONE);
                viewHolder.btnExchangeRecordEvaluate.setVisibility(View.GONE);
                break;
            case 2: //配送中状态订单
                viewHolder.tvExchangeRecordOrderstatus.setText("配送中");
                viewHolder.llExchangeRecordPayment.setVisibility(View.GONE);
                viewHolder.llExchangeRecordGoodsreceipt.setVisibility(View.VISIBLE);
                viewHolder.btnExchangeRecordEvaluate.setVisibility(View.GONE);
                break;
            case 3: //订单已完成状态订单
                viewHolder.tvExchangeRecordOrderstatus.setText("订单已完成");
                viewHolder.llExchangeRecordPayment.setVisibility(View.GONE);
                viewHolder.llExchangeRecordGoodsreceipt.setVisibility(View.GONE);
                viewHolder.btnExchangeRecordEvaluate.setVisibility(View.VISIBLE);
                break;
            default :
                break;
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_exchange_record_shopname)
        TextView tvExchangeRecordShopname;
        @Bind(R.id.tv_exchange_record_orderstatus)
        TextView tvExchangeRecordOrderstatus;
        @Bind(R.id.tv_exchange_record_orderCountDown)
        TextView tvExchangeRecordOrderCountDown;
        @Bind(R.id.img_exchange_record_goodsImg)
        ImageView imgExchangeRecordGoodsImg;
        @Bind(R.id.tv_exchange_record_goodsname)
        TextView tvExchangeRecordGoodsname;
        @Bind(R.id.tv_exchange_record_integral)
        TextView tvExchangeRecordIntegral;
        @Bind(R.id.tv_exchange_record_goodsdnum)
        TextView tvExchangeRecordGoodsdnum;
        @Bind(R.id.tv_exchange_record_orderInfo)
        TextView tvExchangeRecordOrderInfo;
        @Bind(R.id.btn_exchange_record_ordercancle)
        Button btnExchangeRecordOrdercancle;
        @Bind(R.id.btn_exchange_record_payment)
        Button btnExchangeRecordPayment;
        @Bind(R.id.ll_exchange_record_payment)
        LinearLayout llExchangeRecordPayment;
        @Bind(R.id.btn_exchange_record_reminder)
        Button btnExchangeRecordReminder;
        @Bind(R.id.btn_exchange_record_logistics)
        Button btnExchangeRecordLogistics;
        @Bind(R.id.btn_exchange_record_confirm)
        Button btnExchangeRecordConfirm;
        @Bind(R.id.ll_exchange_record_Goodsreceipt)
        LinearLayout llExchangeRecordGoodsreceipt;
        @Bind(R.id.btn_exchange_record_evaluate)
        Button btnExchangeRecordEvaluate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
