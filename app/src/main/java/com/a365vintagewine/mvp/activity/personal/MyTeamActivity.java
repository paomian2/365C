package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.HomePagerAdapter;
import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.a365vintagewine.mvp.fragment.MyTeamFragment;
import com.a365vintagewine.mvp.fragment.RankingListFragment;
import com.a365vintagewine.mvp.presenter.MyTeamPresenter;
import com.a365vintagewine.mvp.view.MyTeamView;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTeamActivity extends BaseMVPActivity<MyTeamPresenter> implements MyTeamView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.tv_myteam_accumulated_income)
    TextView tvMyteamAccumulatedIncome;
    @Bind(R.id.tv_my_team)
    TextView tvMyTeam;
    @Bind(R.id.tv_my_team_line)
    TextView tvMyTeamLine;
    @Bind(R.id.ll_my_team)
    LinearLayout llMyTeam;
    @Bind(R.id.tv_ranking_list)
    TextView tvRankingList;
    @Bind(R.id.tv_ranking_list_line)
    TextView tvRankingListLine;
    @Bind(R.id.ll_ranking_list)
    LinearLayout llRankingList;
    @Bind(R.id.vp_my_team)
    ViewPager vpMyTeam;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected MyTeamPresenter createPresenter() {
        return new MyTeamPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_my_team);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("我的团队");
        MyTeamFragment myTeamFragment = new MyTeamFragment();
        RankingListFragment rankingListFragment = new RankingListFragment();
        fragments.add(myTeamFragment);
        fragments.add(rankingListFragment);
        vpMyTeam.setAdapter(new HomePagerAdapter(getSupportFragmentManager(),fragments));
        vpMyTeam.setCurrentItem(0);
        vpMyTeam.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPageChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * viewPager滑动页面切换
     */
    public void onPageChange(int currentItem){
        switch(currentItem){
            case 0:
                tvMyTeam.setTextColor(getResources().getColor(R.color.tv_red));
                tvMyTeamLine.setVisibility(View.VISIBLE);
                tvRankingList.setTextColor(getResources().getColor(R.color.corlor_666));
                tvRankingListLine.setVisibility(View.GONE);
                break;
            case 1:
                tvRankingList.setTextColor(getResources().getColor(R.color.tv_red));
                tvRankingListLine.setVisibility(View.VISIBLE);
                tvMyTeam.setTextColor(getResources().getColor(R.color.corlor_666));
                tvMyTeamLine.setVisibility(View.GONE);
                break;
            default :
                break;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public BaseActivity getMyContext() {
        return activity;
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }

    /**
     * 返回上级界面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    /**
     * 我的团队
     */
    @OnClick(R.id.ll_my_team)
    public void myTeam(){
        onPageChange(0);
        vpMyTeam.setCurrentItem(0);
    }

    /**
     * 排行榜
     */
    @OnClick(R.id.ll_ranking_list)
    public void rankingList(){
        onPageChange(1);
        vpMyTeam.setCurrentItem(1);
    }

    /**
     * 累计收益明细
     */
    @OnClick(R.id.ll_myteam_accumulated_income)
    public void accumulatedIncome(){
        AppActivityManager.getInstance().goTo(activity,CumulativeProfitDetailActivity.class);
    }

    @Override
    public void setMyTeamAdapter(List<MyTeam> list) {

    }
}
