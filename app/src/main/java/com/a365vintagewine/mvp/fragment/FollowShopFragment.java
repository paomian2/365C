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
import com.a365vintagewine.adapter.FollowShopAdapter;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.a365vintagewine.mvp.presenter.FollowShopPresenter;
import com.a365vintagewine.mvp.view.FollowShopView;
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
 * 收藏店铺
 */
public class FollowShopFragment extends BaseMVPFragment<FollowShopPresenter> implements
        FollowShopView,SwipeRefreshLayout.OnRefreshListener,PagedLoader.OnLoadListener {

    /**
     * 数据列表
     */
    @Bind(R.id.lv_swipe)
    SwipeMenuListView listview;
    /**刷新组件*/
    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayoutCompat layoutRefresh;
    /**空数据布局*/
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**分页加载组件*/
    private PagedLoader pagedLoader;
    /**
     * 数据适配器
     */
    private FollowShopAdapter adapter;
    private int page=1;
    private boolean refresh;

    @Override
    protected FollowShopPresenter createPresenter() {
        return new FollowShopPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_list, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        layoutRefresh.setOnRefreshListener(this);
        pagedLoader=PagedLoader.from(listview).setOnLoadListener(this).builder();
        pagedLoader.setOnLoadListener(this);
        adapter = new FollowShopAdapter(activity);
        pagedLoader.setAdapter(adapter);
        listview.setAdapter(adapter);
        listview.setMenuCreator(initSwip());

        //左划菜单的监听事件
        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                deleteShop(adapter.getAdapterData().get(position).getShops_Id()+"");
                return false;
            }
        });
    }


    @Override
    public void initData() {
        page=1;
        UIHelper.showProgressDialog(activity,"正在加载...");
        getFavoriteShopList();
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
    public void getFavoriteShopList() {
        Map<String,Object> params=new HashMap<>();
        params.put("Client_Id","1950");
        params.put("FavoriteType","shop");
        params.put("Page",page+"");
        params.put("Take",5+"");
        mvpPresenter.getFollowShop(params);
    }

    @Override
    public void getFavoriteShopListResult(boolean success, List<GetFavoriteShopListReponse.DataBean.PagedDataBean> pagedDataBeanList,String msg) {
          UIHelper.cancleProgressDialog();
          layoutRefresh.setRefreshing(false);
          pagedLoader.setLoading(false);
          if (success){
              if (refresh){
                  adapter.clearAdapter();
              }
              adapter.addAdapterData(pagedDataBeanList);
              page++;
          }else{
              if (adapter.getAdapterData().size()==0){
                  layoutRefresh.setVisibility(View.GONE);
                  layoutDataEmpty.setVisibility(View.VISIBLE);
              }else{
                  showToast("已加载完成");
              }
          }
    }

    @Override
    public void deleteShop(String shopId) {
        UIHelper.showProgressDialog(activity,"正在删除数据...");
        Map<String,Object> params=new HashMap<>();
        params.put("Shops_Id",shopId);
        params.put("Client_Id","1950");
        mvpPresenter.deleteShop(params);
    }

    @Override
    public void deleteShopResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
            onRefresh();
        }
    }

    @Override
    public void onRefresh() {
        refresh=true;
        page=1;
        getFavoriteShopList();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
       refresh=false;
        getFavoriteShopList();
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
