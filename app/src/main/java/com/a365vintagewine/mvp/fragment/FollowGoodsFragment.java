package com.a365vintagewine.mvp.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.FollowGoodsAdapter;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.a365vintagewine.mvp.presenter.FollowPresenter;
import com.a365vintagewine.mvp.view.FollowGoodsView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.widget.SwipeRefreshLayoutCompat;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
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
 * 关注商品
 */
public class FollowGoodsFragment extends BaseMVPFragment<FollowPresenter> implements FollowGoodsView, SwipeRefreshLayout.
        OnRefreshListener, PagedLoader.OnLoadListener {

    /**
     * 数据列表
     */
    @Bind(R.id.lv_swipe)
    SwipeMenuListView listview;
    /**
     * 列表刷新组件
     */
    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayoutCompat layoutRefresh;
    /**
     * 无数据布局
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**
     * 分页加载组件
     */
    private PagedLoader pagedLoader;
    /**
     * 列表适配器
     */
    private FollowGoodsAdapter adapter;
    private int page = 1;
    private boolean refresh;

    @Override
    protected FollowPresenter createPresenter() {
        return new FollowPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_list, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        layoutRefresh.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(listview).setOnLoadListener(this).builder();
        adapter = new FollowGoodsAdapter(activity);
        pagedLoader.setAdapter(adapter);
        listview.setAdapter(adapter);
        listview.setMenuCreator(initSwip());
        //左划菜单的监听事件
        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String productId = adapter.getItem(position).getProducts_Id() + "";
                delFavoriteProductList(productId);
                return false;
            }
        });
    }

    @Override
    public void initData() {
        page = 1;
        getFavoriteProductList();
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
    public void getFavoriteProductList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id",SharePreferenceUtils2.getClient_Id(activity));
        params.put("FavoriteType", "product");
        params.put("Page", page + "");
        params.put("Take", 20 + "");
        mvpPresenter.getFollowGoods(params);
    }

    @Override
    public void getFavoriteProductListResult(boolean success, List<GetFavoriteProductListResponse.DataBean.PagedDataBean> pagedDataBeanList, String msg) {
        UIHelper.cancleProgressDialog();
        layoutRefresh.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (success) {
            if (refresh) {
                adapter.clearAdapter();
            }
            adapter.addAdapterData(pagedDataBeanList);
            page++;
        } else {
            if (adapter.getAdapterData().size() == 0) {
                //暂无数据
                layoutRefresh.setVisibility(View.GONE);
                layoutDataEmpty.setVisibility(View.VISIBLE);
            } else {
                //已加载完成
                showToast("已加载完成");
            }
        }
    }

    @Override
    public void delFavoriteProductList(String Products_Id) {
        UIHelper.showProgressDialog(activity, "正在删除...");
        Map<String, Object> params = new HashMap<>();
        params.put("Products_Id", Products_Id);
        params.put("Client_Id", "1950");
        mvpPresenter.deleteGoods(params);
    }

    @Override
    public void delFavoriteProductListResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success) {
            onRefresh();
        }
    }

    @Override
    public void onRefresh() {
        refresh = true;
        page = 1;
        getFavoriteProductList();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        getFavoriteProductList();
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


}
