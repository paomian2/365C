package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProductLibBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月13日  15:00
 * 版本：3.0
 */

public class IndexHotProductsAdapter extends BaseAdapter2<ProductLibBean>{


    public IndexHotProductsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_index_hot_product, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        ProductLibBean productLibBean=getItem(position);
        UIHelper.imageNet(context,productLibBean.getProductLibUrl(),viewHolder.imgGoods,false,R.mipmap.img_def);
        viewHolder.tvGoodsName.setText(productLibBean.getProductLibName());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.imgGoods)
        ImageView imgGoods;
        @Bind(R.id.tvGoodsName)
        TextView tvGoodsName;
        @Bind(R.id.tvGoodsPrice)
        TextView tvGoodsPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
