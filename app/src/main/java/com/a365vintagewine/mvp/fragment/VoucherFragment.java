package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.VoucherAdapter;
import com.a365vintagewine.mvp.model.bean.VoucherBean;
import com.a365vintagewine.mvp.presenter.VoucherFragmentPresenter;
import com.a365vintagewine.mvp.view.VoucherFragmentView;
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
 * 功能描述:返券列表
 * 作者：Linxz
 * E-mail：lin_xiao_zhang@13.com
 * 版本信息：V1.0.0
 * 时间：2017年04月08日  10:26.
 **/
public class VoucherFragment extends BaseMVPFragment<VoucherFragmentPresenter> implements VoucherFragmentView, SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener {

    /**空数据布局*/
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**
     * 返券列表
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
    /**
     * 券列表适配器
     */
    private VoucherAdapter voucherAdapter;

    /**
     * 当前券列表状态
     */
    private final static String STATUS = "status";
    private String status;
    /**
     * 是否触发了刷新组件
     */
    private boolean refresh;
    private int page = 0;

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        if (bundle != null) {
            status = bundle.getString(STATUS);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected VoucherFragmentPresenter createPresenter() {
        return new VoucherFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_voucherlist, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void initUI() {
        UIHelper.initRefreshView(refrenshLayout);
        refrenshLayout.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(lvCommon).setOnLoadListener(this).builder();
        voucherAdapter = new VoucherAdapter(activity, status);
        pagedLoader.setAdapter(voucherAdapter);
        lvCommon.setAdapter(voucherAdapter);
        //立即使用券监听
        voucherAdapter.setVoucherUseOnclickListener(new VoucherAdapter.VoucherUseOnclickListener() {
            @Override
            public void onUseClick(VoucherBean voucherBean) {

            }
        });
    }

    @Override
    public void initData() {
        refresh = true;
        page = 0;
        GetUserCouponList();

    }

    @Override
    public String setTag() {
        return null;
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        GetUserCouponList();
    }

    @Override
    public void onRefresh() {
        refresh = true;
        page=1;
        GetUserCouponList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void GetUserCouponList() {
        int statusInt=1;
        if ("未使用".equals(status)){
            statusInt=1;
        }else if ("已使用".equals(status)){
            statusInt=2;
        }else if ("已过期".equals(status)){
            statusInt=3;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Page", page + "");
        params.put("Take", "20");
        params.put("QueryWhere", statusInt+"");
        mvpPresenter.GetUserCouponList(params);
    }

    @Override
    public void GetUserCouponListResult(boolean success, String msg, List<VoucherBean> voucherBeanList) {
        refrenshLayout.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (refresh) {
            voucherAdapter.clearAdapter();
        }
        if (success) {
            voucherAdapter.addAdapterData(voucherBeanList);
            page++;
        }
        if (voucherAdapter.getAdapterData().size()==0){
            layoutDataEmpty.setVisibility(View.VISIBLE);
        }else{
            layoutDataEmpty.setVisibility(View.GONE);
        }

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


}
