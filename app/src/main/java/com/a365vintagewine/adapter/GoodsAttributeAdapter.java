package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * 商品属性
 *
 */

public class GoodsAttributeAdapter extends BaseAdapter2<String> {

    private boolean moreTag;

    public GoodsAttributeAdapter(Context context) {
        super(context);
    }

    public void setMoreTag(boolean moreTag){
        this.moreTag=moreTag;
    }


    @Override
    public int getCount() {
        if (moreTag){
            return mlist.size();
        }else{
            if (mlist.size()>=4){
                return 4;
            }else{
                return mlist.size();
            }
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_goods_attribute, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvGoodsAttrobute.setText(getItem(position));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_goods_attrobute)
        TextView tvGoodsAttrobute;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
