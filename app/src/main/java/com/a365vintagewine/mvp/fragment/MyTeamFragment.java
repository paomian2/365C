package com.a365vintagewine.mvp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.MyTeamAdapter;
import com.a365vintagewine.mvp.activity.personal.ProfitDetailActivity;
import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.a365vintagewine.mvp.presenter.MyTeamPresenter;
import com.a365vintagewine.mvp.view.MyTeamView;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的团队
 */
public class MyTeamFragment extends BaseMVPFragment<MyTeamPresenter> implements MyTeamView {

    @Bind(R.id.lv_my_team)
    ListView lvMyTeam;
    @Bind(R.id.sf_myteam)
    SwipeRefreshLayout sfMyteam;

    private MyTeamAdapter adapter;

    @Override
    protected MyTeamPresenter createPresenter() {
        return new MyTeamPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_team, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        adapter = new MyTeamAdapter(activity);
        lvMyTeam.setAdapter(adapter);
        lvMyTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyTeam team = (MyTeam) parent.getAdapter().getItem(position);
                Intent intent = new Intent(activity,ProfitDetailActivity.class);
                intent.putExtra("name",team.getName());
                intent.putExtra("price",team.getPrice());
                AppActivityManager.getInstance().goTo(activity,intent);
            }
        });
    }

    @Override
    public void initData() {
        mvpPresenter.getMyTeamList();
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
    public void setMyTeamAdapter(List<MyTeam> list) {
        adapter.setMlist(list);
        adapter.notifyDataSetChanged();
    }
}