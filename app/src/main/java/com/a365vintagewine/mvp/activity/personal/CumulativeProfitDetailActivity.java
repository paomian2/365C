package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.CumulativeDetailAdapter;
import com.a365vintagewine.mvp.model.bean.CumulativeDetail;
import com.a365vintagewine.mvp.presenter.CumulativeProfitPresenter;
import com.a365vintagewine.mvp.view.CumulativeProfitView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CumulativeProfitDetailActivity extends BaseMVPActivity<CumulativeProfitPresenter> implements CumulativeProfitView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.tv_cumulative_detail_profit)
    TextView tvCumulativeDetailProfit;
    @Bind(R.id.lv_cumulative_detail)
    ListView lvCumulativeDetail;

    private CumulativeDetailAdapter adapter;
    @Override
    protected CumulativeProfitPresenter createPresenter() {
        return new CumulativeProfitPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_cumulative_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("累计收益明细");
        adapter = new CumulativeDetailAdapter(activity);
        lvCumulativeDetail.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mvpPresenter.getCumulativeDetail();
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

    @Override
    public void setCumulativeAdapter(List<CumulativeDetail> list) {
        adapter.setMlist(list);
        adapter.notifyDataSetChanged();
    }
}
