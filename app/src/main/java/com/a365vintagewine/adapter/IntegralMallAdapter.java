package com.a365vintagewine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.IntegralMall;
import com.commsdk.common.UIHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class IntegralMallAdapter extends RecyclerView.Adapter<IntegralMallAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<IntegralMall> goodslist;

    public IntegralMallAdapter(Context mContext,List<IntegralMall> goodslist) {
        this.mContext = mContext;
        this.goodslist = goodslist;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(mInflater.inflate(R.layout.item_integral_mall,null));;
//        if (parent == null){
//            viewHolder =
//            parent.setTag(viewHolder);
//        }else{
//            viewHolder = (MyViewHolder) parent.getTag();
//        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        IntegralMall goods = goodslist.get(position);
        holder.tvIntegralMallGoodsintegral.setText(goods.getGoodsIntegral()+"积分");
        holder.tvIntegralMallGoodsname.setText(goods.getGoodsname());
        UIHelper.imageNet(mContext,goods.getGoodsimg(),holder.itemIntegralMallGoodsimg,true);
    }

    @Override
    public int getItemCount() {
        return goodslist.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.item_integral_mall_goodsimg)
        ImageView itemIntegralMallGoodsimg;
        @Bind(R.id.tv_integral_mall_goodsname)
        TextView tvIntegralMallGoodsname;
        @Bind(R.id.tv_integral_mall_goodsintegral)
        TextView tvIntegralMallGoodsintegral;
        @Bind(R.id.btn_integral_mall_exchange)
        Button btnIntegralMallExchange;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void resetList(List<IntegralMall> goodslist){
        this.goodslist.clear();
        this.goodslist = goodslist;
        this.notifyDataSetChanged();
    }
}
