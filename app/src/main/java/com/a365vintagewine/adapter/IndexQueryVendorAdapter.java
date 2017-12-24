package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.QueryVendorBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：附近商家适配器
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月14日  14:28
 * 版本：3.0
 */

public class IndexQueryVendorAdapter extends BaseAdapter2<QueryVendorBean> {

    public IndexQueryVendorAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_home_shop, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        QueryVendorBean queryVendorBean=getItem(position);
        UIHelper.imageNet(context,queryVendorBean.getImage(),viewHolder.imgStore,false,R.mipmap.img_def);
        viewHolder.tvStoreName.setText(queryVendorBean.getName());
        viewHolder.ratingbar.setRating(queryVendorBean.getScore());
        viewHolder.tvSaleNo.setText("销量 "+queryVendorBean.getSaleCount());
        viewHolder.tvMinFee.setText("起送 ¥"+queryVendorBean.getMinFee());
        viewHolder.tvDeliveryFee.setText("配送费 ¥"+queryVendorBean.getDeliveryFee());
        viewHolder.tvDisScope.setText(queryVendorBean.getDistance()+"");
        viewHolder.tvManJian.setText(queryVendorBean.getManJian()+"");
        viewHolder.tvZheKou.setText(queryVendorBean.getZheKou()+"");
        if (StringUtils.isEmpty(queryVendorBean.getManJian())){
            viewHolder.tvManJian.setVisibility(View.GONE);
        }
        if (StringUtils.isEmpty(queryVendorBean.getZheKou())){
            viewHolder.tvZheKou.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ViewHolder {
        /**店铺图片*/
        @Bind(R.id.imgStore)
        ImageView imgStore;
        /**店铺名称*/
        @Bind(R.id.tvStoreName)
        TextView tvStoreName;
        /**分数*/
        @Bind(R.id.ratingbar)
        RatingBar ratingbar;
        /**销量*/
        @Bind(R.id.tv_sale_no)
        TextView tvSaleNo;
        /**最小起送费*/
        @Bind(R.id.tvMinFee)
        TextView tvMinFee;
        /**配送费*/
        @Bind(R.id.tvDeliveryFee)
        TextView tvDeliveryFee;
        /**距离*/
        @Bind(R.id.tvDisScope)
        TextView tvDisScope;
        /**满减*/
        @Bind(R.id.tvManJian)
        TextView tvManJian;
        /**折扣*/
        @Bind(R.id.tvZheKou)
        TextView tvZheKou;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
