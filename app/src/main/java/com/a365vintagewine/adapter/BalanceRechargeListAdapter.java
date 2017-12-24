package com.a365vintagewine.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.personal.BalanceDetailedActivity;
import com.a365vintagewine.mvp.model.bean.ConsignorBalanceOrderBean;
import com.a365vintagewine.mvp.model.bean.StoreBean;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.CircleImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import static com.a365vintagewine.R.layout.item_balance_recharge;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  17:38
 * 版本：3.0
 */

public class BalanceRechargeListAdapter extends BaseAdapter2<ConsignorBalanceOrderBean> {

    public BalanceRechargeListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(item_balance_recharge, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ConsignorBalanceOrderBean consignorBalanceOrderBean=getItem(position);
        UIHelper.imageNet(context,consignorBalanceOrderBean.getConsignorImg()+"",viewHolder.headImg,false);
        viewHolder.tvStoreName.setText(consignorBalanceOrderBean.getConsignorName());
        viewHolder.tvBalancePrice.setText(consignorBalanceOrderBean.getBalance()+"");
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppActivityManager.getInstance().goTo((BaseActivity)context, BalanceDetailedActivity.class);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.headImg)
        CircleImageView headImg;
        @Bind(R.id.tvStoreName)
        TextView tvStoreName;
        @Bind(R.id.tvBalancePrice)
        TextView tvBalancePrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
