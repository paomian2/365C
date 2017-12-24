package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.IntegralDetail;
import com.a365vintagewine.mvp.model.bean.PointBean;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 积分明细
 */

public class IntegralDetailAdapter extends BaseAdapter2<PointBean> {
    public IntegralDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_integral_detail, null,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PointBean pointBean = getItem(position);
        viewHolder.tvIntegralDetailSource.setText(pointBean.getPointDesc());
        viewHolder.tvIntegralDetailItemNum.setText(pointBean.getPoint());
        viewHolder.tvIntegralDetailOrderNo.setText(pointBean.getOrderCode());
        viewHolder.tvIntegralDetailOrderTime.setText(pointBean.getPointDate());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_integral_detail_source)
        TextView tvIntegralDetailSource;
        @Bind(R.id.tv_integral_detail_item_num)
        TextView tvIntegralDetailItemNum;
        @Bind(R.id.tv_integral_detail_orderNo)
        TextView tvIntegralDetailOrderNo;
        @Bind(R.id.tv_integral_detail_orderTime)
        TextView tvIntegralDetailOrderTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
