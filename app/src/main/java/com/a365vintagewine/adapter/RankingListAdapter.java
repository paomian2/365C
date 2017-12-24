package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.commsdk.base.BaseAdapter2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class RankingListAdapter extends BaseAdapter2<MyTeam> {

    public RankingListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_ranking, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MyTeam team = getItem(position);
        switch (team.getSort()) {
            case 1:
                viewHolder.tvRankingListRanking.setVisibility(View.GONE);
                viewHolder.imgRankingListRanking.setVisibility(View.VISIBLE);
                viewHolder.imgRankingListRanking.setImageResource(R.mipmap.ranking_one);
                break;
            case 2:
                viewHolder.tvRankingListRanking.setVisibility(View.GONE);
                viewHolder.imgRankingListRanking.setVisibility(View.VISIBLE);
                viewHolder.imgRankingListRanking.setImageResource(R.mipmap.ranking_two);
                break;
            case 3:
                viewHolder.tvRankingListRanking.setVisibility(View.GONE);
                viewHolder.imgRankingListRanking.setVisibility(View.VISIBLE);
                viewHolder.imgRankingListRanking.setImageResource(R.mipmap.ranking_three);
                break;
            default:
                viewHolder.imgRankingListRanking.setVisibility(View.GONE);
                viewHolder.tvRankingListRanking.setVisibility(View.VISIBLE);
                viewHolder.tvRankingListRanking.setText(team.getSort() + "");
                break;
        }
        viewHolder.tvRankingListName.setText(team.getName());
        viewHolder.tvRankingListPrice.setText("¥ " + team.getPrice());
        if (position == 0) {
            viewHolder.llRankingList.setBackgroundColor(convertView.getResources().getColor(R.color.background));
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.ll_ranking_list)
        LinearLayout llRankingList;
        @Bind(R.id.img_ranking_list_ranking)
        ImageView imgRankingListRanking;
        @Bind(R.id.tv_ranking_list_ranking)
        TextView tvRankingListRanking;
        @Bind(R.id.tv_ranking_list_name)
        TextView tvRankingListName;
        @Bind(R.id.tv_ranking_list_price)
        TextView tvRankingListPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
