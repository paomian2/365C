package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class MyTeamAdapter extends BaseAdapter2<MyTeam> {
    public MyTeamAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_my_team, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MyTeam team = getItem(position);
        switch(position){
            case 0:
                viewHolder.tvMyTeamRanking.setVisibility(View.GONE);
                viewHolder.imgMyTeamRanking.setVisibility(View.VISIBLE);
                viewHolder.imgMyTeamRanking.setImageResource(R.mipmap.ranking_one);
                break;
            case 1:
                viewHolder.tvMyTeamRanking.setVisibility(View.GONE);
                viewHolder.imgMyTeamRanking.setVisibility(View.VISIBLE);
                viewHolder.imgMyTeamRanking.setImageResource(R.mipmap.ranking_two);
                break;
            case 2:
                viewHolder.tvMyTeamRanking.setVisibility(View.GONE);
                viewHolder.imgMyTeamRanking.setVisibility(View.VISIBLE);
                viewHolder.imgMyTeamRanking.setImageResource(R.mipmap.ranking_three);
                break;
            default :
                viewHolder.imgMyTeamRanking.setVisibility(View.GONE);
                viewHolder.tvMyTeamRanking.setText(position+"");
                break;
        }
        viewHolder.tvMyTeamName.setText(team.getName());
        viewHolder.tvMyTeamNum.setText("（"+team.getNum()+"）");
        viewHolder.tvMyTeamPrice.setText("¥ "+team.getPrice());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.img_my_team_ranking)
        ImageView imgMyTeamRanking;
        @Bind(R.id.tv_my_team_ranking)
        TextView tvMyTeamRanking;
        @Bind(R.id.tv_my_team_name)
        TextView tvMyTeamName;
        @Bind(R.id.tv_my_team_num)
        TextView tvMyTeamNum;
        @Bind(R.id.tv_my_team_price)
        TextView tvMyTeamPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
