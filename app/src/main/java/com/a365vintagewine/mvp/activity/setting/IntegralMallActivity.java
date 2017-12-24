package com.a365vintagewine.mvp.activity.setting;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.IntegralMallAdapter;
import com.a365vintagewine.mvp.activity.personal.IntegralDetailActivity;
import com.a365vintagewine.mvp.model.bean.IntegralMall;
import com.a365vintagewine.mvp.presenter.IntegralMallPresenter;
import com.a365vintagewine.mvp.view.IntegralMallView;
import com.a365vintagewine.widget.MyRecyclerViewHeader;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntegralMallActivity extends BaseMVPActivity<IntegralMallPresenter> implements IntegralMallView {


    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.img_integral_mall_advertisement)
    ImageView imgIntegralMallAdvertisement;
    @Bind(R.id.tv_integral_num)
    TextView tvIntegralNum;
    @Bind(R.id.ll_integral_mall_num)
    LinearLayout llIntegralMallNum;
    @Bind(R.id.tv_exchange_record)
    TextView tvExchangeRecord;
    @Bind(R.id.ll_integral_mall_exchange)
    LinearLayout llIntegralMallExchange;
    @Bind(R.id.tv_integral_mall_shopname)
    TextView tvIntegralMallShopname;
    @Bind(R.id.recycler_integral_mall)
    RecyclerView recyclerIntegralMall;
    @Bind(R.id.header_integral_mall)
    MyRecyclerViewHeader headerIntegralMall;
    @Bind(R.id.sf_integral_mall)
    SwipeRefreshLayout sfIntegralMall;
    @Bind(R.id.tv_integral_mall_sort_salenum)
    TextView tvIntegralMallSortSalenum;
    @Bind(R.id.tv_integral_mall_sort_integral)
    TextView tvIntegralMallSortIntegral;

    private IntegralMallAdapter adapter;
    private int mCurrentScroll;

    @Override
    protected IntegralMallPresenter createPresenter() {
        return new IntegralMallPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_integral_mall);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("兑换商城");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerIntegralMall.setLayoutManager(gridLayoutManager);
        // 将顶部视图与RecyclerView关联即可
        headerIntegralMall.attachTo(recyclerIntegralMall, true);
        headerIntegralMall.setOnScrollTopListener(new MyRecyclerViewHeader.OnScrollTopListener() {
            @Override
            public void onTop(boolean isTop) {
                sfIntegralMall.setEnabled(isTop);
            }
        });
        sfIntegralMall.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sfIntegralMall.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sfIntegralMall.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void initData() {
        mvpPresenter.getIntegralGoods();
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
    public void back() {
        finish();
    }

    /**
     * 积分明细
     */
    @OnClick(R.id.ll_integral_mall_num)
    public void integralDeatil() {
        AppActivityManager.getInstance().goTo(activity, IntegralDetailActivity.class);
    }

    /**
     * 兑换记录
     */
    @OnClick(R.id.ll_integral_mall_exchange)
    public void exchange() {
        AppActivityManager.getInstance().goTo(activity, ExchangeRecordActivity.class);
    }

    @Override
    public void setListAdapter(List<IntegralMall> goodsList) {
        adapter = new IntegralMallAdapter(activity, goodsList);
        recyclerIntegralMall.setAdapter(adapter);
    }

    /**
     * 点击销量排序
     */
    private int saleTag = 0;
    @OnClick(R.id.tv_integral_mall_sort_salenum)
    public void sortSalenum() {
        saleTag++;
        tvIntegralMallSortSalenum.setTextColor(Color.parseColor("#0196ff"));
        tvIntegralMallSortIntegral.setTextColor(Color.BLACK);
        if (saleTag % 2 == 0) {
            Drawable drawable= getResources().getDrawable(R.mipmap.integral_sort_dowm);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvIntegralMallSortSalenum.setCompoundDrawables(null,null,drawable,null);
            return;
        }
        Drawable drawable= getResources().getDrawable(R.mipmap.integral_sort_up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvIntegralMallSortSalenum.setCompoundDrawables(null,null,drawable,null);
    }

    /**
     * 点击积分排序
     */
    private int integralTag = 0;
    @OnClick(R.id.tv_integral_mall_sort_integral)
    public void sortIntegral(){
        tvIntegralMallSortIntegral.setTextColor(Color.parseColor("#0196ff"));
        tvIntegralMallSortSalenum.setTextColor(Color.BLACK);
        integralTag++;
        if (integralTag % 2 == 0) {
            Drawable drawable= getResources().getDrawable(R.mipmap.integral_sort_dowm);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvIntegralMallSortIntegral.setCompoundDrawables(null,null,drawable,null);
            return;
        }
        Drawable drawable= getResources().getDrawable(R.mipmap.integral_sort_up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvIntegralMallSortIntegral.setCompoundDrawables(null,null,drawable,null);
    }

}