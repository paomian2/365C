package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.BanlanceOrderBean;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.CircleImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import static com.a365vintagewine.R.layout.item_balance_platform;

/**
 * 描述：平台余额列表
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  17:13
 * 版本：3.0
 */

public class BalancePlatformListAdapter extends BaseAdapter2<BanlanceOrderBean> {

    public BalancePlatformListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(item_balance_platform, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        BanlanceOrderBean banlanceOrderBean=getItem(position);
        UIHelper.imageNet(context,banlanceOrderBean.getHeadImgUrl(),viewHolder.headImg,false,R.mipmap.myself_head_portrait);
        viewHolder.tvUserName.setText(banlanceOrderBean.getMainTitle());
        viewHolder.tvBalanceDesc.setText(banlanceOrderBean.getSubtitle());
        viewHolder.tvBalancePrice.setText(banlanceOrderBean.getBalance()+"");
        viewHolder.tvTime.setText(banlanceOrderBean.getBalanceDate());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.headImg)
        CircleImageView headImg;
        @Bind(R.id.tvUserName)
        TextView tvUserName;
        @Bind(R.id.tvBalanceDesc)
        TextView tvBalanceDesc;
        @Bind(R.id.tvBalancePrice)
        TextView tvBalancePrice;
        @Bind(R.id.tvTime)
        TextView tvTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
