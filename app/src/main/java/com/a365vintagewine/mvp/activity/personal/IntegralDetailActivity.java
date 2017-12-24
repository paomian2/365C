package com.a365vintagewine.mvp.activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.IntegralDetailAdapter;
import com.a365vintagewine.mvp.activity.setting.IntegralMallActivity;
import com.a365vintagewine.mvp.model.bean.PointBean;
import com.a365vintagewine.mvp.model.response.GetUserConsignorPointListResponse;
import com.a365vintagewine.mvp.presenter.IntegralDetailPresenter;
import com.a365vintagewine.mvp.view.IntegralDetailView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.CircleImageView;
import com.commsdk.common.widget.PagedLoader;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntegralDetailActivity extends BaseMVPActivity<IntegralDetailPresenter> implements
        IntegralDetailView, SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener {

    /**
     * 返回布局
     */
    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    /**
     * 标题
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 标题布局
     */
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    /**
     * 积分明细列表
     */
    @Bind(R.id.lv_integral_detail)
    ListView lvIntegralDetail;
    /**
     * 刷新组件
     */
    @Bind(R.id.sf_integral_detail)
    SwipeRefreshLayout layoutRefresh;
    /**
     * 空数据列表布局
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**
     * 分页加载组件
     */
    private PagedLoader pagedLoader;
    /**
     * 当前加载页数
     */
    private int page = 1;
    /**
     * 是否刷新数据
     */
    private boolean refresh;
    /**
     * 数据列表适配器
     */
    private IntegralDetailAdapter adapter;
    private final static String POINT_BEAN = "pointBean";
    /**
     * 积分实体，设置在列表的头部
     */
    private PointBean pointBean;

    /**
     * @param pointBean:积分实体
     */
    public static void launch(BaseActivity activity, PointBean pointBean) {
        Intent intent = new Intent();
        intent.putExtra(POINT_BEAN, pointBean);
        intent.setClass(activity, IntegralDetailActivity.class);
        AppActivityManager.getInstance().goTo(activity, intent);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        pointBean = (PointBean) getIntent().getSerializableExtra(POINT_BEAN);
    }


    @Override
    protected IntegralDetailPresenter createPresenter() {
        return new IntegralDetailPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_integral_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("积分明细");
        layoutRefresh.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(lvIntegralDetail).setOnLoadListener(this).builder();
        adapter = new IntegralDetailAdapter(activity);
        pagedLoader.setAdapter(adapter);
        View headerView = View.inflate(this, R.layout.header_integral_deail, null);
        ViewHolder hederViewHolder = new ViewHolder(headerView);
        hederViewHolder.tvIntegralDetailName.setText(pointBean.getConsignorName());
        hederViewHolder.tvIntegralDetailSum.setText(pointBean.getPoint() + "");
        UIHelper.imageNet(activity, pointBean.getConsignorImg(), hederViewHolder.imgIntegralDetailLogo, true);
        hederViewHolder.tvIntegralDetailExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppActivityManager.getInstance().goTo(activity, IntegralMallActivity.class);
            }
        });
        lvIntegralDetail.addHeaderView(headerView);
        lvIntegralDetail.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        layoutRefresh.setRefreshing(true);
        getUserConsignorPointList();
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
    public void getUserConsignorPointList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Consignor_Id", pointBean.getConsignor_Id() + "");
        params.put("Page", page + "");
        params.put("Take", 20 + "");
        mvpPresenter.GetUserConsignorPointList(params);
    }

    @Override
    public void getUserConsignorPointListResult(boolean success, String msg, GetUserConsignorPointListResponse.PointListData pointListData) {
        layoutRefresh.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (refresh) {
            adapter.clearAdapter();
        }
        if (success) {
            adapter.addAdapterData(pointListData.getPagedData());
            page++;
        }
        if (adapter.getAdapterData().size() == 0) {
            layoutDataEmpty.setVisibility(View.VISIBLE);
        } else {
            layoutDataEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        refresh = true;
        getUserConsignorPointList();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        getUserConsignorPointList();
    }

    /**
     * 返回上一级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }


    static class ViewHolder {
        @Bind(R.id.img_integral_detail_logo)
        CircleImageView imgIntegralDetailLogo;
        @Bind(R.id.tv_integral_detail_name)
        TextView tvIntegralDetailName;
        @Bind(R.id.tv_integral_detail_sum)
        TextView tvIntegralDetailSum;
        @Bind(R.id.tv_integral_detail_exchange)
        TextView tvIntegralDetailExchange;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
