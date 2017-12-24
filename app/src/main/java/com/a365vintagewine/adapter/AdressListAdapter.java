package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.personal.AdressEditActivity;
import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  3:01
 * 版本：3.0
 */

public class AdressListAdapter extends BaseAdapter2<AdressBean> {

    ViewHolder viewHolder;
    public AdressListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        viewHolder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_adress_list, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final AdressBean adressBean=getItem(position);
        viewHolder.tvAdress.setText(adressBean.getCityName()+adressBean.getStreet()+adressBean.getAddress());
        viewHolder.tvConsignee.setText(adressBean.getName()+"    "+adressBean.getMobile());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdressEditActivity.lunch((BaseActivity)context,AdressEditActivity.ACTION_CODE_EEIT,adressBean);
//                if (adressEditClickListener!=null)
//                    adressEditClickListener.onAdressEditClick(tempPosition,getItem(tempPosition));
            }
        });
        return convertView;
    }

    interface AdressEditClickListener{
        public void onAdressEditClick(int position,AdressBean adressBean);
    }

    private AdressEditClickListener adressEditClickListener;
    public void setAdressEditClickListener(AdressEditClickListener adressEditClickListener){
        this.adressEditClickListener=adressEditClickListener;
    }

    static class ViewHolder {
        @Bind(R.id.tvAdress)
        TextView tvAdress;
        @Bind(R.id.tvConsignee)
        TextView tvConsignee;
        @Bind(R.id.imgEdit)
        ImageView imgEdit;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
