package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.commsdk.common.UIHelper;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * 描述：搜索门店 商品列表(listview嵌套listview高度计算问题)
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月20日  1:30
 * 版本：V1.0
 */
public class GoodsListLinearlayoutAdapter{


    private Context context;
    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;
    private QueryBean shop;
    List<ProductsBean> goodses=new ArrayList<>();


    private boolean showMoreTag;

    private OnGoodsItemClickListener onGoodsItemClickListener;


    public GoodsListLinearlayoutAdapter(Context context, LinearLayout linearLayout,QueryBean shop,OnGoodsItemClickListener onGoodsItemClickListener){
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.linearLayout=linearLayout;
        this.shop=shop;
        if (shop!=null && shop.getProducts()!=null){
            this.goodses.addAll(shop.getProducts());
        }
        this.showMoreTag=shop.isShowMoreTag();
        this.onGoodsItemClickListener=onGoodsItemClickListener;
        setGoodsListView();
    }



    private void setGoodsListView(){
        int showGoodsSize=0;
        if (goodses.size()>3 && !showMoreTag){
            showGoodsSize=3;
        }else{
            showGoodsSize=goodses.size();
        }
        linearLayout.removeAllViews();
        for (int i=0;i<showGoodsSize;i++){
            ProductsBean goods = goodses.get(i);
            View goodsView=layoutInflater.inflate(R.layout.item_search_goods,null);
            ImageView imgSearchGoods= (ImageView) goodsView.findViewById(R.id.img_search_goods);
            TextView tvSearchGoodsname= (TextView) goodsView.findViewById(R.id.tv_search_goodsname);
            TextView tvSearchGoodprice= (TextView) goodsView.findViewById(R.id.tv_search_goodprice);
            tvSearchGoodprice.setText("¥  "+goods.getVipPrice());
            tvSearchGoodsname.setText(goods.getName());
            UIHelper.imageNet(context,goods.getImage(),imgSearchGoods,true,R.mipmap.img_def);
            goodsView.setTag(goods);
            goodsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProductsBean productsBean= (ProductsBean) v.getTag();
                    if (onGoodsItemClickListener!=null)
                        onGoodsItemClickListener.onGoodsClick(shop,productsBean);
                }
            });
            View viewLine=goodsView.findViewById(R.id.viewLine);
            if (i==showGoodsSize-1){
                viewLine.setVisibility(View.INVISIBLE);
            }else{
                viewLine.setVisibility(View.VISIBLE);
            }
            linearLayout.addView(goodsView);
        }
    }


    public interface OnGoodsItemClickListener{
        void onGoodsClick(QueryBean shop,ProductsBean goods);
    }



}
