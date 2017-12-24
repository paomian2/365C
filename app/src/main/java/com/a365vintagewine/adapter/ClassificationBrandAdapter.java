package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.BranchBen;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 品牌适配器
 */

public class ClassificationBrandAdapter extends BaseAdapter2<BranchBen> {

    /**开始展示6个，大于6个点击展示更多*/
    private boolean showMoreTag;

    public ClassificationBrandAdapter(Context context) {
        super(context);
    }


    public void setShowMoreTag(boolean showMoreTag){
        this.showMoreTag=showMoreTag;
    }


    @Override
    public int getCount() {
        if (mlist.size()<=3){
            return mlist.size();
        }else{
            if (showMoreTag){
                return mlist.size();
            }else{
                return 3;
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_classification_brand, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BranchBen brand = getItem(position);
        viewHolder.tvClassificationBrandname.setText(brand.getBrandNameCn());
        UIHelper.imageNet(context,brand.getLogo(),viewHolder.imgClassificationBrandurl,false,R.mipmap.img_def);
        return convertView;
    }

    static class ViewHolder {
        /**品牌图片*/
        @Bind(R.id.img_classification_brandurl)
        ImageView imgClassificationBrandurl;
        /**品牌名称*/
        @Bind(R.id.tv_classification_brandname)
        TextView tvClassificationBrandname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
