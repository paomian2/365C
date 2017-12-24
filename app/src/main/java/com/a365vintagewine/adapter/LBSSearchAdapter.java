package com.a365vintagewine.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.AddressSearchTextEntity;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.NumberUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Destription:
 * @auther:lstreamlet
 * @date:2017/3/10
 */
public class LBSSearchAdapter extends BaseAdapter2 {

    private LatLng latLng;

    public LBSSearchAdapter(Context context,LatLng latLng) {
        super(context);
        this.latLng=latLng;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lbs_search, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        AddressSearchTextEntity addressSearchTextEntity= (AddressSearchTextEntity) getItem(position);
        viewHolder.tvAdress.setText(addressSearchTextEntity.getTittle());
        viewHolder.tvSnippet.setText(addressSearchTextEntity.getAdress());
        //计算距离
        LatLng latLng2=new LatLng(addressSearchTextEntity.getLatLonPoint().getLatitude(),addressSearchTextEntity.getLatLonPoint().getLongitude());
        float distance = AMapUtils.calculateLineDistance(latLng,latLng2);
        viewHolder.tvDistance.setText(NumberUtils.formatNumberofDistance(distance));
        return convertView;
    }

     class ViewHolder {
        @Bind(R.id.tvAdress)
        TextView tvAdress;
         @Bind(R.id.tvSnippet)
         TextView tvSnippet;
         @Bind(R.id.tvDistance)
         TextView tvDistance;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
