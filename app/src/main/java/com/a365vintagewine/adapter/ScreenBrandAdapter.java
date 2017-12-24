package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.BranchBen;
import com.commsdk.base.BaseAdapter2;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 筛选页品牌适配器
 */

public class ScreenBrandAdapter extends BaseAdapter2<BranchBen> {

    public ScreenBrandAdapter(Context context) {
        super(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_screen_brand, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BranchBen branchBen = getItem(position);
        viewHolder.tvScreenBrandname.setText(branchBen.getBrandNameCn());
        if (branchBen.isSelect()){
            viewHolder.tvScreenBrandname.setBackgroundResource(R.drawable.screen_seletor_checked);
        }else{
            viewHolder.tvScreenBrandname.setBackgroundResource(R.drawable.btn_background_ddd);
        }
        onClicks(viewHolder,branchBen);
        return convertView;
    }

    private void onClicks(final ViewHolder viewHolder,final BranchBen branchBen) {
        final TextView tvBrandName =  viewHolder.tvScreenBrandname;
        tvBrandName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (branchBen.isSelect()){
                    branchBen.setSelect(false);
                    tvBrandName.setBackgroundResource(R.drawable.btn_background_ddd);
                }else{
                    branchBen.setSelect(true);
                    tvBrandName.setBackgroundResource(R.drawable.screen_seletor_checked);
                }
            }
        });
    }

    static class ViewHolder {
        @Bind(R.id.tv_screen_brandname)
        TextView tvScreenBrandname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
