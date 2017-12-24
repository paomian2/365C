package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.BalancePlatformListAdapter;
import com.a365vintagewine.adapter.BalanceRechargeListAdapter;
import com.a365vintagewine.mvp.model.bean.BanlanceOrderBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBalanceOrderBean;
import com.a365vintagewine.mvp.presenter.BalanceFragmentPresenter;
import com.a365vintagewine.mvp.view.BalanceFragmentView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.PagedLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  14:26
 * 版本：3.0
 */

public class BalanceFragment extends BaseMVPFragment<BalanceFragmentPresenter> implements BalanceFragmentView {

    /**
     * 平台余额Fragment
     */
    public final static int ACTION_CODE_PLATFORM = 1001;
    /**
     * 充值余额Fragment
     */
    public final static int ACTION_CODE_RECHARGE = 1002;
    /**
     * 余额模块标志
     */
    public final static String ACTION_CODE = "actionCode";
    /**
     * 标志那个Fragment
     */
    private int actionCode = ACTION_CODE_PLATFORM;

    /**
     * 加载中布局
     */
    @Bind(R.id.layoutLoading)
    LinearLayout layoutLoading;
    /**
     * 数据列表
     */
    @Bind(R.id.lv_common)
    ListView lvCommon;
    /**
     * 刷新组件
     */
    @Bind(R.id.refrenshLayout)
    SwipeRefreshLayout refrenshLayout;
    /**
     * 加载更多组件
     */
    private PagedLoader pagedLoader;
    private BalancePlatformListAdapter balancePlatformListAdapter;
    private BalanceRechargeListAdapter balanceRechargeListAdapter;
    private int page = 0;
    private boolean refresh;

    @Override
    protected BalanceFragmentPresenter createPresenter() {
        return new BalanceFragmentPresenter(this);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        if (bundle != null) {
            actionCode = bundle.getInt(ACTION_CODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_activitylist, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initUI() {
        switch (actionCode) {
            case ACTION_CODE_PLATFORM:
                UIHelper.initRefreshView(refrenshLayout);
                refrenshLayout.setOnRefreshListener(mOnRefreshListener);
                pagedLoader = PagedLoader.from(lvCommon).setOnLoadListener(mOnLoadListener).builder();
                balancePlatformListAdapter = new BalancePlatformListAdapter(activity);
                pagedLoader.setAdapter(balancePlatformListAdapter);
                lvCommon.setAdapter(balancePlatformListAdapter);
                GetPlatformUserBalance();
                break;
            case ACTION_CODE_RECHARGE:
                UIHelper.initRefreshView(refrenshLayout);
                refrenshLayout.setOnRefreshListener(mOnRefreshListener);
                pagedLoader = PagedLoader.from(lvCommon).setOnLoadListener(mOnLoadListener).builder();
                balanceRechargeListAdapter = new BalanceRechargeListAdapter(activity);
                pagedLoader.setAdapter(balanceRechargeListAdapter);
                lvCommon.setAdapter(balanceRechargeListAdapter);
                GetConsignorUserBalance();
                break;
            default:
                break;
        }

    }

    @Override
    public void initData() {
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
     * 获取平台余额列表
     */
    @Override
    public void GetPlatformUserBalance() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Page", page + "");
        params.put("Take", "20");
        mvpPresenter.GetPlatformUserBalance(params);
    }

    /**
     * 获取平台余额列表结果
     */
    @Override
    public void GetPlatformUserBalanceResult(boolean success, String msg, List<BanlanceOrderBean> list) {
        pagedLoader.setLoading(false);
        refrenshLayout.setRefreshing(false);
        layoutLoading.setVisibility(View.GONE);
        refrenshLayout.setVisibility(View.VISIBLE);
        if (refresh) {
            balancePlatformListAdapter.clearAdapter();
        }
        if (success) {
            balancePlatformListAdapter.addAdapterData(list);
            page++;
        }
    }

    /**
     * 获取平台余额列表
     */
    @Override
    public void GetConsignorUserBalance() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Page", page + "");
        params.put("Take", "20");
        mvpPresenter.GetConsignorUserBalance(params);
    }

    /**
     * 获取平台余额列表结果
     */
    @Override
    public void GetConsignorUserBalanceResult(boolean success, String msg,List<ConsignorBalanceOrderBean> list) {
        pagedLoader.setLoading(false);
        refrenshLayout.setRefreshing(false);
        layoutLoading.setVisibility(View.GONE);
        refrenshLayout.setVisibility(View.VISIBLE);
        if (refresh){
            balanceRechargeListAdapter.clearAdapter();
        }
        if (success) {
            balanceRechargeListAdapter.addAdapterData(list);
            page++;
        }
    }

    /**
     * 加载更多
     */
    private PagedLoader.OnLoadListener mOnLoadListener = new PagedLoader.OnLoadListener() {
        @Override
        public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
            refresh = false;
            if (actionCode == ACTION_CODE_PLATFORM) {
                GetPlatformUserBalance();
            } else {
                GetConsignorUserBalance();
            }
        }
    };

    /**
     * 刷新数据
     */
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            refresh = true;
            page = 1;
            if (actionCode == ACTION_CODE_PLATFORM) {
                GetPlatformUserBalance();
            } else {
                GetConsignorUserBalance();
            }
        }
    };


}
