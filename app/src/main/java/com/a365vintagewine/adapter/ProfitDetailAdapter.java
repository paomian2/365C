package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProfitDetail;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class ProfitDetailAdapter extends BaseAdapter2<ProfitDetail> {
    public ProfitDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_profit_detail, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ProfitDetail detail = getItem(position);
        viewHolder.tvProfitDetailPrice.setText("+   ¥"+detail.getProfitPrice());
        viewHolder.tvProfitDetailTime.setText(detail.getProfitTime());
        viewHolder.tvProfitDetailType.setText(detail.getProfitTime());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_profit_detail_type)
        TextView tvProfitDetailType;
        @Bind(R.id.tv_profit_detail_time)
        TextView tvProfitDetailTime;
        @Bind(R.id.tv_profit_detail_price)
        TextView tvProfitDetailPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
