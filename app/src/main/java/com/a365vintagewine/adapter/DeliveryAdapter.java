package com.a365vintagewine.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.DeliveryBean;
import com.commsdk.base.BaseAdapter2;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：配送方式适配器
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月19日  18:20
 * 版本：V1.0
 */
public class DeliveryAdapter extends BaseAdapter2<DeliveryBean> {

    public DeliveryAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_delivery, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        DeliveryBean deliveryBean=getItem(position);
        viewHolder.tvDelivery.setText(deliveryBean.getName());
        if (deliveryBean.isSelect()){
            viewHolder.tvDelivery.setBackgroundResource(R.drawable.screen_seletor_checked);
            viewHolder.tvDelivery.setTextColor(ContextCompat.getColor(context,R.color.red));
        }else{
            viewHolder.tvDelivery.setBackgroundResource(R.drawable.btn_background_f4);
            viewHolder.tvDelivery.setTextColor(ContextCompat.getColor(context,R.color.black));
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tvDelivery)
        TextView tvDelivery;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
