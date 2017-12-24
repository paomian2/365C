package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.RankingListAdapter;
import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.a365vintagewine.mvp.presenter.RankingListPresenter;
import com.a365vintagewine.mvp.view.RankingListView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的团队
 */
public class RankingListFragment extends BaseMVPFragment<RankingListPresenter> implements RankingListView {

    @Bind(R.id.lv_my_team)
    ListView lvMyTeam;
    @Bind(R.id.sf_myteam)
    SwipeRefreshLayout sfMyteam;

    private RankingListAdapter adapter;
    @Override
    protected RankingListPresenter createPresenter() {
        return new RankingListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_team, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        adapter = new RankingListAdapter(activity);
        lvMyTeam.setAdapter(adapter);
    }

    @Override
    public void initData() {
        mvpPresenter.getRankingList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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

    @Override
    public void setRankingListAdapter(List<MyTeam> list) {
        adapter.setMlist(list);
        adapter.notifyDataSetChanged();
    }
}
