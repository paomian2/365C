package com.a365vintagewine.mvp.activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.ProfitDetailAdapter;
import com.a365vintagewine.mvp.model.bean.ProfitDetail;
import com.a365vintagewine.mvp.presenter.ProfitDetailPresenter;
import com.a365vintagewine.mvp.view.ProfitDetailView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.widget.CircleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfitDetailActivity extends BaseMVPActivity<ProfitDetailPresenter> implements ProfitDetailView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.tvRight)
    TextView tvRight;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.img_profit_detail)
    CircleImageView imgProfitDetail;
    @Bind(R.id.tv_profit_detail_nikename)
    TextView tvProfitDetailNikename;
    @Bind(R.id.tv_profit_detail_price)
    TextView tvProfitDetailPrice;
    @Bind(R.id.lv_profit_detail)
    ListView lvProfitDetail;

    private ProfitDetailAdapter adapter;
    private String nikeName;
    private double price;
    @Override
    protected ProfitDetailPresenter createPresenter() {
        return new ProfitDetailPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_profit_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        Intent intent = getIntent();
        nikeName = intent.getStringExtra("name");
        price = intent.getDoubleExtra("price",0);
        tvProfitDetailNikename.setText(nikeName);
        tvProfitDetailPrice.setText("¥"+price);
        tvTextTitle.setText("收益明细");
        adapter = new ProfitDetailAdapter(activity);
        lvProfitDetail.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mvpPresenter.getProfitDetail();
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
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    @Override
    public void setProfitDetialAdapter(List<ProfitDetail> list) {
        adapter.setMlist(list);
        adapter.notifyDataSetChanged();
    }
}
