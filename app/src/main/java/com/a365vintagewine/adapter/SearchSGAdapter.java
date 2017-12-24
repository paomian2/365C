package com.a365vintagewine.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchSGAdapter extends BaseAdapter2<QueryBean> {


    private OnBusinessItemClick onBusinessItemClick;

    public SearchSGAdapter(Context context) {
        super(context);
    }

    public void setOnBusinessItemClick(OnBusinessItemClick onBusinessItemClick){
        this.onBusinessItemClick=onBusinessItemClick;
    }

    ViewHolder viewHolder = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = null;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_search_shop, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final QueryBean shop = getItem(position);
        UIHelper.imageNet(context, shop.getImage()+"", viewHolder.imgSearchShop, true,R.mipmap.img_def);
        viewHolder.rbSearchShopStar.setRating(shop.getScore());
        viewHolder.tvSearchShopDistance.setText(shop.getDistance()+"");
        viewHolder.tvSearchShopName.setText(shop.getName());
        List<ProductsBean> goodses = shop.getProducts();
        //设置商品列表
        if (goodses!=null && goodses.size()>0){
            new GoodsListLinearlayoutAdapter(context,viewHolder.layoutGoodsList,shop,new GoodsListLinearlayoutAdapter.OnGoodsItemClickListener(){
                @Override
                public void onGoodsClick(QueryBean shop, ProductsBean goods) {
                    if (onBusinessItemClick!=null)
                        onBusinessItemClick.onGoodsClick(shop,goods);
                }
            });
        }
        if (goodses!=null && goodses.size()<=3){
            viewHolder.rlSearchShopGoodsShowbrand.setVisibility(View.GONE);
        }
        onCLicks(viewHolder,shop);
        return convertView;
    }

    private void onCLicks(final ViewHolder viewHolder,final QueryBean shop) {
        /**查看更多*/
        viewHolder.rlSearchShopGoodsShowbrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop.isShowMoreTag()){
                    shop.setShowMoreTag(false);
                }else{
                    shop.setShowMoreTag(true);
                }
                notifyDataSetChanged();
            }
        });

        /**店铺点击*/
        viewHolder.layoutBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (onBusinessItemClick!=null)
                     onBusinessItemClick.onShopClick(shop);
            }
        });

    }

    /**点击列表中对应的商家*/
    public interface OnBusinessItemClick{
        /**店铺点击*/
        void onShopClick(QueryBean shopGoods);
        /**商品点击*/
        void onGoodsClick(QueryBean shopGoods,ProductsBean productsBean);
    }


    static class ViewHolder {
        @Bind(R.id.img_search_shop)
        ImageView imgSearchShop;
        @Bind(R.id.rb_search_shop_star)
        RatingBar rbSearchShopStar;
        @Bind(R.id.tv_search_shop_distance)
        TextView tvSearchShopDistance;
        @Bind(R.id.tv_search_shopname)
        TextView tvSearchShopName;
        @Bind(R.id.layoutGoodsList)
        LinearLayout layoutGoodsList;
        @Bind(R.id.img_search_shop_goods_showbrand)
        ImageView imgSearchShopGoodsShowbrand;
        @Bind(R.id.rl_search_shop_goods_showbrand)
        RelativeLayout rlSearchShopGoodsShowbrand;
        @Bind(R.id.layoutBusiness)
        LinearLayout layoutBusiness;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
