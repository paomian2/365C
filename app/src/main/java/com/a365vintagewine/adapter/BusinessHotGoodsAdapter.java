package com.a365vintagewine.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：商家热销
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月06日  17:37
 * 版本：3.0
 */

public class BusinessHotGoodsAdapter extends BaseAdapter2<ProductsBean> {

    private OnHotGoodsItemClickListener onHotGoodsItemClickListener;

    public void setOnHotGoodsItemClickListener(OnHotGoodsItemClickListener onHotGoodsItemClickListener){
        this.onHotGoodsItemClickListener=onHotGoodsItemClickListener;
    }

    public BusinessHotGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_business_goods, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final ProductsBean productsBean=getItem(position);
        UIHelper.imageNet(context,productsBean.getPicURL(),viewHolder.imgGoods,false,R.mipmap.img_def);
        viewHolder.tvGoodsName.setText(productsBean.getProductName());
        viewHolder.tvGoodsPrice.setText("¥"+productsBean.getVipPrice());
        viewHolder.imgShoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (onHotGoodsItemClickListener!=null){
                   onHotGoodsItemClickListener.onHoGoodsAddCar(productsBean,position);
               }
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onHotGoodsItemClickListener!=null){
                    onHotGoodsItemClickListener.onHotGoodsItemClick(productsBean,position);
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.imgGoods)
        ImageView imgGoods;
        @Bind(R.id.tvGoodsName)
        TextView tvGoodsName;
        @Bind(R.id.tvGoodsPrice)
        TextView tvGoodsPrice;
        @Bind(R.id.imgShoppingCar)
        ImageView imgShoppingCar;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface OnHotGoodsItemClickListener{
        /**加入购物车*/
        void onHoGoodsAddCar(ProductsBean productsBean,int position);
        /**查看商品详情*/
        void onHotGoodsItemClick(ProductsBean productsBean,int position);
    }
}
