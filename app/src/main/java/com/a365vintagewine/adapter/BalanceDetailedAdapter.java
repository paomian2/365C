package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.BalanceDetaileBean;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  19:52
 * 版本：3.0
 */

public class BalanceDetailedAdapter extends BaseAdapter2<BalanceDetaileBean> {

    public BalanceDetailedAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_balance_detailed, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        BalanceDetaileBean balanceDetaileBean=getItem(position);
        viewHolder.tvTittle.setText(balanceDetaileBean.getBalanceType());
        viewHolder.tvOrderNO.setText("订单号："+balanceDetaileBean.getOrderId());
        viewHolder.tvBalancePrice.setText(balanceDetaileBean.getBalancePrice());
        viewHolder.tvTime.setText(balanceDetaileBean.getTime());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tvTittle)
        TextView tvTittle;
        @Bind(R.id.tvOrderNO)
        TextView tvOrderNO;
        @Bind(R.id.tvBalancePrice)
        TextView tvBalancePrice;
        @Bind(R.id.tvTime)
        TextView tvTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
