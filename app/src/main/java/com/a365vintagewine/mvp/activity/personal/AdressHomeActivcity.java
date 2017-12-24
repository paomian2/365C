package com.a365vintagewine.mvp.activity.personal;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.AdressListAdapter;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.a365vintagewine.mvp.presenter.AdressHomePresenter;
import com.a365vintagewine.mvp.view.AdressHomeView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.widget.SwipeRefreshLayoutCompat;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;
import com.commsdk.common.observers.AffairObserver;
import com.commsdk.common.observers.AffairObserverableExcute;
import com.commsdk.common.widget.PagedLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  2:23
 * 版本：3.0
 */

public class AdressHomeActivcity extends BaseMVPActivity<AdressHomePresenter> implements AdressHomeView,
        SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener,AffairObserver{

    /**
     * 标题：地址管理
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 未读消息数
     */
    @Bind(R.id.tv_myself_msgcount)
    TextView tv_myself_msgcount;
    /**
     * 数据列表
     */
    @Bind(R.id.lv_address_swipemenu)
    SwipeMenuListView lvAddressSwipemenu;
    /**
     * 数据列表为空布局
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;

    /**
     * 刷新组件
     */
    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayoutCompat layoutRefresh;
    /**
     * 分页加载组件
     */
    private PagedLoader pagedLoader;
    /**
     * 当前页数
     */
    private int page = 1;
    private boolean refresh;
    private AdressListAdapter adressListAdapter;


    @Override
    protected AdressHomePresenter createPresenter() {
        return new AdressHomePresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_adress_home);
        ButterKnife.bind(this);
        AffairObserverableExcute.getInstance().attach(this);
    }

    @Override
    protected void onDestroy() {
        AffairObserverableExcute.getInstance().detach(this);
        super.onDestroy();
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("地址管理");
        tv_myself_msgcount.setText("18");
        layoutRefresh.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(lvAddressSwipemenu).setOnLoadListener(this).builder();
        adressListAdapter = new AdressListAdapter(activity);
        pagedLoader.setAdapter(adressListAdapter);
        lvAddressSwipemenu.setAdapter(adressListAdapter);
        lvAddressSwipemenu.setMenuCreator(initSwip());

        //左划菜单的监听事件
        lvAddressSwipemenu.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Map<String,Object> params=new HashMap<>();
                params.put("Client_Id",SharePreferenceUtils2.getClient_Id(activity));
                params.put("Address_Id",adressListAdapter.getItem(position).getAddress_Id() + "");
                deleteAdressRecord(params);
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        UIHelper.showProgressDialog(activity, "数据加载中...");
        getAdressList();
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
    public void getAdressList() {
        /*
      每页加载的数量
     */
        int size = 5;
        mvpPresenter.getAdressList(SharePreferenceUtils2.getClient_Id(activity), page, size);
    }

    @Override
    public void onGetAdressListResult(boolean success, List<AdressBean> adressBeanList, String msg) {
        UIHelper.cancleProgressDialog();
        layoutRefresh.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (success) {
            if (refresh) {
                adressListAdapter.clearAdapter();
            }
            adressListAdapter.addAdapterData(adressBeanList);
            page++;
        } else {
            if (adressListAdapter.getAdapterData().size() == 0) {
                //暂无数据
                layoutRefresh.setVisibility(View.GONE);
                layoutDataEmpty.setVisibility(View.VISIBLE);
            } else {
                showToast("已加载完成");
            }
        }
    }

    @Override
    public void deleteAdressRecord(Map<String,Object> params) {
        UIHelper.showProgressDialog(activity,"正在删除数据...");
        mvpPresenter.delUserAddress(params);
    }

    @Override
    public void onDeleteAdressRecordResult(boolean success,String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
           onRefresh();
        }
    }

    @Override
    public void onRefresh() {
        refresh = true;
        page = 1;
        getAdressList();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        getAdressList();
    }

    @Override
    public void updateAffair(String tag, Object object) {
        if (Contans.UPDATE_ADRESS.equals(tag)){
            onRefresh();
        }
    }

    /**
     * 设计左划窗口
     */
    private SwipeMenuCreator initSwip() {
        return new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem2 = new SwipeMenuItem(
                        getApplicationContext());
                openItem2.setBackground(new ColorDrawable(Color.RED));
                // set item width
                openItem2.setWidth(200);
                // set item title
                openItem2.setTitle("删除");
                // set item title fontsize
                openItem2.setTitleSize(18);
                // set item title font color
                openItem2.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem2);
            }
        };
    }


    /**
     * 返回
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 消息
     */
    @OnClick(R.id.rl_myself_msg)
    public void onMsgClick() {
        showToast("消息");
    }

    /**
     * 地址添加
     */
    @OnClick(R.id.layoutAdressAdd)
    public void adressAdd() {
        AdressEditActivity.lunch(activity, AdressEditActivity.ACTION_CODE_ADD);
    }



}
