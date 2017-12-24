package com.commsdk.common.widget.hlistview_circle_nomal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.commsdk.R;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.CircleImageView;
import com.commsdk.module.bean.RecommendBean;
import java.util.ArrayList;


/**
 * 奶茶 adapter
 *
 * @author zhangzhilai 2014.10.9
 */
public class ClubsItemAdapter extends BaseAdapter {

    public static final String TAG = "ClubsItemAdapter";
    private Context mContext;
    private ArrayList<RecommendBean> mClubsItemModelList;

    public ClubsItemAdapter(Context context, ArrayList<RecommendBean> ClubsItemModels) {
        mContext = context;
        mClubsItemModelList = ClubsItemModels;
    }

    @Override
    public int getCount() {
        return mClubsItemModelList.size();
    }

    @Override
    public RecommendBean getItem(int position) {
        return mClubsItemModelList.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.h_clubs_scrollview_item_cicleview, null);
            viewHolder = new ViewHolder();
            viewHolder.lvHeadImg= (CircleImageView) convertView.findViewById(R.id.lvHeadImg);
            viewHolder.tvUserName= (TextView) convertView.findViewById(R.id.tvUserName);
            viewHolder.tvGoodsName= (TextView) convertView.findViewById(R.id.tvGoodsName);
            viewHolder.tvUserDesc= (TextView) convertView.findViewById(R.id.tvUserDesc);
            viewHolder.ivGoods= (ImageView) convertView.findViewById(R.id.ivGoods);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        RecommendBean recommendBean = mClubsItemModelList.get(position);
        convertView.setTag(R.id.tag_clubsitem, recommendBean);
//        if (!StringUtils.isEmpty(recommendBean.getUserInfo().getImage())){
//            UIHelper.imageNet(mContext,recommendBean.getUserInfo().getImage(),viewHolder.lvHeadImg,false,R.drawable.icon_user_def);
//        }
//        viewHolder.tvUserName.setText(recommendBean.getUserInfo().getName());
//        viewHolder.tvUserDesc.setText(recommendBean.getUserInfo().getSign());
//        viewHolder.tvGoodsName.setText(recommendBean.getGoodsInfo().getName());
//        if (!StringUtils.isEmpty(recommendBean.getGoodsInfo().getMainPic())){
//            String pic=recommendBean.getGoodsInfo().getMainPic().split(",")[0];
//            UIHelper.imageNet(mContext,pic,viewHolder.ivGoods,false,R.drawable.img_def);
//        }
        return convertView;
    }


     class ViewHolder {
         public CircleImageView lvHeadImg;
         public TextView tvUserName,tvUserDesc,tvGoodsName;
         public ImageView ivGoods;
    }
}
