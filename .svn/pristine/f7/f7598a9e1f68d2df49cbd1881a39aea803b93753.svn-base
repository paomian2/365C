package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class OrderDetailAdapter extends BaseAdapter2 {
    public OrderDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_order_detail, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return 5;
    }

    static class ViewHolder {
        @Bind(R.id.img_order_detail_goodsImg)
        ImageView imgOrderDetailGoodsImg;
        @Bind(R.id.tv_order_detail_goodsname)
        TextView tvOrderDetailGoodsname;
        @Bind(R.id.tv_order_detail_goodsprice)
        TextView tvOrderDetailGoodsprice;
        @Bind(R.id.tv_order_detail_goodsdnum)
        TextView tvOrderDetailGoodsdnum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
