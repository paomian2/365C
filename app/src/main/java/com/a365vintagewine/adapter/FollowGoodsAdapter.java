package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;


public class FollowGoodsAdapter extends BaseAdapter2<GetFavoriteProductListResponse.DataBean.PagedDataBean> {

    public FollowGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_follow_goods, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GetFavoriteProductListResponse.DataBean.PagedDataBean goods = getItem(position);
        viewHolder.tvFollowGoodsName.setText(goods.getProductName());
        viewHolder.tvFollowGoodsPrice.setText("¥"+goods.getProductPrice());
        UIHelper.imageNet(context,goods.getProductImg(),viewHolder.imgFollowGoods,true);
        onClicks(viewHolder,position);
        return convertView;
    }

    private void onClicks(final ViewHolder viewHolder, final int position) {
    }

    static class ViewHolder {
        @Bind(R.id.img_follow_goods)
        ImageView imgFollowGoods;
        @Bind(R.id.tv_follow_goods_name)
        TextView tvFollowGoodsName;
        @Bind(R.id.tv_follow_goods_price)
        TextView tvFollowGoodsPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
