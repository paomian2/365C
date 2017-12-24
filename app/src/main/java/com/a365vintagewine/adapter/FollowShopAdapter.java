package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;
public class FollowShopAdapter extends BaseAdapter2<GetFavoriteShopListReponse.DataBean.PagedDataBean> {
    public FollowShopAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_follow_shop, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GetFavoriteShopListReponse.DataBean.PagedDataBean shop = getItem(position);
        viewHolder.tvFollowShopName.setText(shop.getConsignorShop_Name());
        UIHelper.imageNet(context,shop.getConsignor_Img(),viewHolder.imgFollowShop,true);
        viewHolder.rbFollowShopStar.setRating(Integer.parseInt(shop.getConsignor_Start()));
        onClicks(viewHolder,position);
        return convertView;
    }

    private void onClicks(final ViewHolder viewHolder, final int position) {

    }

    static class ViewHolder {
        @Bind(R.id.img_follow_shop)
        ImageView imgFollowShop;
        @Bind(R.id.tv_follow_shop_name)
        TextView tvFollowShopName;
        @Bind(R.id.rb_follow_shop_star)
        RatingBar rbFollowShopStar;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
