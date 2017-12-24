package com.commsdk.common.widget.hlistview_circle_nomal;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.commsdk.R;
import com.commsdk.module.bean.RecommendBean;

import java.util.ArrayList;

/**
 * 奶茶 横向滑动scrollview
 * 
 * @author zhangzhilai 2014.10.9
 * 
 */
public class ClubsHorizonScrollView extends HorizontalScrollView {
	
	public static final String TAG = "ClubsHorizonScrollView";
	private Context mContext;
	private ArrayList<RecommendBean> mClubsItemModelList=new ArrayList<RecommendBean>();
	private LinearLayout mClubContainerLayout;
	private ClubsItemAdapter mClubsItemAdapter;
	private final int mMarginLeftDp =10;

	public ClubsHorizonScrollView(Context context) {
		super(context);
		mContext = context;
		initView();
	}

	public ClubsHorizonScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
	}

	private void initView() {
		LayoutInflater.from(mContext).inflate(R.layout.h_clubs_horizon_scrollview, this);
		mClubContainerLayout = (LinearLayout) findViewById(R.id.horizonscrollview_linearlayout);
	}

	public void setListData(ArrayList<RecommendBean> clubsItemModelList) {
		mClubsItemModelList = clubsItemModelList;
		mClubsItemAdapter = new ClubsItemAdapter(mContext, mClubsItemModelList);
		addViews();
	}

	// 提供外部设置adapter
	public void setAdapter() {

	}

	private void addViews(){
		mClubContainerLayout.removeAllViews();
		for (int i = 0; i < mClubsItemAdapter.getCount(); i++) {
			View itemView = mClubsItemAdapter.getView(i, null, null);
			itemView.setOnClickListener(onClickListener);
			LinearLayout.LayoutParams layoutParams = UIUtils.getLllp(UIUtils.LLW, UIUtils.LLW);
			if (i==0){
				//第一个间距为1，接下来为10
				layoutParams.leftMargin = UIUtils.dip2px(mContext, 0);
			}else{
				layoutParams.leftMargin = UIUtils.dip2px(mContext, mMarginLeftDp);
			}
			itemView.setLayoutParams(layoutParams);
			mClubContainerLayout.addView(itemView);
		}
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			RecommendBean recommendBean = (RecommendBean) view.getTag(R.id.tag_clubsitem);
			//Toast.makeText(mContext, "clubsItemModel" + clubsItemModel.getClubTitle(), Toast.LENGTH_SHORT).show();
	        if(onItemClickListener!=null){
	        	onItemClickListener.onclick(recommendBean);
	        }
		}
	};
	
	public interface HLCircleOnItemNormalClickListener{
		public void onclick(RecommendBean recommendBean);
	}
	
	private HLCircleOnItemNormalClickListener onItemClickListener;
	public void setHLCircleOnItemClickListener(HLCircleOnItemNormalClickListener onItemClickListener){
		this.onItemClickListener=onItemClickListener;
	}
}
