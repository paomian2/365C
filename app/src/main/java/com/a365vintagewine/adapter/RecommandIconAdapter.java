package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * 描述：热销Icon适配器
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月13日  10:57
 * 版本：3.0
 */

public class RecommandIconAdapter extends BaseAdapter2<BannerBean> {

    @Override
    public int getCount() {
        if (mlist.size()>=4){
            return 4;
        }
        return super.getCount();
    }

    public RecommandIconAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_recommand_icon, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        BannerBean bannerBean=getItem(position);
        UIHelper.imageNet(context,bannerBean.getPicURL(),viewHolder.imgIcon,false,R.mipmap.icon_summer);
        viewHolder.tvIconName.setText(bannerBean.getTitle());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.imgIcon)
        ImageView imgIcon;
        @Bind(R.id.tvIconName)
        TextView tvIconName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
