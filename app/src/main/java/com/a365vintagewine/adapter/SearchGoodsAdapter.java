package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.FollowGoods;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商品列表适配器
 */

public class SearchGoodsAdapter extends BaseAdapter2<ProductsBean> {


    /**默认展示三个*/
    private boolean showMoreTag;

    public void setShowMoreTag(boolean showMoreTag){
        this.showMoreTag=showMoreTag;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        if (showMoreTag){
            return super.getCount();
        }else{
            if (mlist.size()<=3){
                return super.getCount();
            }else{
                return 3;
            }
        }

    }

    public SearchGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_search_goods, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ProductsBean goods = getItem(position);
        viewHolder.tvSearchGoodprice.setText("¥  "+goods.getVipPrice());
        viewHolder.tvSearchGoodsname.setText(goods.getName());
        UIHelper.imageNet(context,goods.getImage(),viewHolder.imgSearchGoods,true,R.mipmap.img_def);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.img_search_goods)
        ImageView imgSearchGoods;
        @Bind(R.id.tv_search_goodsname)
        TextView tvSearchGoodsname;
        @Bind(R.id.tv_search_goodprice)
        TextView tvSearchGoodprice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
