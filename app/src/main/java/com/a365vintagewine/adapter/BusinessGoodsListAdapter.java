package com.a365vintagewine.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：商家首页商品列表适配器
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月04日  12:49
 * 版本：3.0
 */

public class BusinessGoodsListAdapter extends BaseRecyViewAdapter<ProductsBean> {

    /**
     * 头布局
     */
    public static final int TYPE_HEADER = 0;
    /**
     * 正常列表
     */
    public static final int TYPE_NORMAL = 1;

    /**头布局*/
    private View mHeaderView;

    /**头布局ViewHoler*/
    private RecyclerView.ViewHolder headerHolder;

    private OnProductItemClickListener onProductItemClickListener;

    public BusinessGoodsListAdapter(Context context) {
        super(context);
    }


    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }


    public void setHeaderHolder(RecyclerView.ViewHolder headerHolder){
        this.headerHolder=headerHolder;
    }



    @Override
    public int getItemCount() {
        return mHeaderView == null ? mlist.size() : mlist.size() + 1;
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    public void setOnProductItemClickListener(OnProductItemClickListener onProductItemClickListener){
        this.onProductItemClickListener=onProductItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null)
            return TYPE_NORMAL;
        if (position == 0)
            return TYPE_HEADER;
        return TYPE_NORMAL;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER)
            return headerHolder;
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_business_goods, parent, false);
        return new MyViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER)
            return;
        final int pos = getRealPosition(viewHolder);
        final ProductsBean productsBean =getItem(position-1);
        if(viewHolder instanceof MyViewHolder) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            UIHelper.imageNet(context,productsBean.getImage(),myViewHolder.imgGoods,false,R.mipmap.img_def);
            myViewHolder.tvGoodsName.setText(productsBean.getName());
            myViewHolder.tvGoodsPrice.setText("¥"+productsBean.getVipPrice());
            if(onProductItemClickListener == null)
                return;
            myViewHolder.imgShoppingCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProductItemClickListener.onAddShopCar(productsBean,pos);
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProductItemClickListener.onProductItemClick(productsBean, pos);
                }
            });
        }
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imgGoods)
        ImageView imgGoods;
        @Bind(R.id.tvGoodsName)
        TextView tvGoodsName;
        @Bind(R.id.tvGoodsPrice)
        TextView tvGoodsPrice;
        @Bind(R.id.imgShoppingCar)
        ImageView imgShoppingCar;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnProductItemClickListener{
        /**加入购物车*/
        void onAddShopCar(ProductsBean productsBean,int position);
        /**商品详情*/
        void onProductItemClick(ProductsBean productsBean,int position);
    }

}
