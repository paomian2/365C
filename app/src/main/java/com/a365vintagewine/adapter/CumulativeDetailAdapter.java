package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.CumulativeDetail;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class CumulativeDetailAdapter extends BaseAdapter2<CumulativeDetail> {
    public CumulativeDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_cumulative_detail, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CumulativeDetail detail = getItem(position);
        if (detail.isNew()){
            viewHolder.tvCumulativeDetailNew.setVisibility(View.VISIBLE);
        }else{
            viewHolder.tvCumulativeDetailNew.setVisibility(View.GONE);
        }
        viewHolder.tvAumulativaDetailTime.setText(detail.getTime());
        viewHolder.tvCumulativeDetailMoney.setText("+"+detail.getMoney());
        viewHolder.tvCumulativeDetailNikename.setText(detail.getNikename());
        if (!StringUtils.isEmpty(detail.getImgUrl())){
            UIHelper.imageNet(context,detail.getImgUrl(),viewHolder.imgCumulativaDetail,true);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.img_cumulativa_detail)
        ImageView imgCumulativaDetail;
        @Bind(R.id.tv_cumulative_detail_nikename)
        TextView tvCumulativeDetailNikename;
        @Bind(R.id.tv_cumulative_detail_new)
        TextView tvCumulativeDetailNew;
        @Bind(R.id.tv_cumulative_detail_money)
        TextView tvCumulativeDetailMoney;
        @Bind(R.id.tv_aumulativa_detail_time)
        TextView tvAumulativaDetailTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
