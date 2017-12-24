package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.IndexHotProductsAdapter;
import com.a365vintagewine.adapter.IndexQueryVendorAdapter;
import com.a365vintagewine.adapter.RecommandIconAdapter;
import com.a365vintagewine.mvp.activity.business.BusinessHomeActivity;
import com.a365vintagewine.mvp.activity.search.SearchShopGoodsActivity;
import com.a365vintagewine.mvp.model.bean.Geo;
import com.a365vintagewine.mvp.model.bean.ProductLibBean;
import com.a365vintagewine.mvp.model.bean.QueryVendorBean;
import com.a365vintagewine.mvp.model.bean.QueryVendorParams;
import com.a365vintagewine.mvp.presenter.HomeFragmentPresenter;
import com.a365vintagewine.mvp.view.HomeFragmentView;
import com.a365vintagewine.widget.SwipeRefreshLayoutCompat;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;
import com.commsdk.common.PopupHelper;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.MyGridView;
import com.commsdk.common.widget.PagedLoader;
import com.commsdk.common.widget.banner.BanerView;
import com.commsdk.common.widget.banner.BannerBean;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseMVPFragment<HomeFragmentPresenter>
        implements HomeFragmentView,SwipeRefreshLayout.OnRefreshListener,PagedLoader.OnLoadListener {

    /**刷新组件*/
    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayoutCompat layoutRefresh;
    /**ActionBar*/
    @Bind(R.id.layoutActionBar)
    LinearLayout layoutActionBar;
    /**门店列表*/
    @Bind(R.id.storeLists)
    ListView storeLists;
    /**加载器*/
    private PagedLoader pagedLoader;
    /**店铺列表无数据布局*/
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    //头布局文件
    private HeandViewHolder heandViewHolder;
    //泡泡窗口，附近商家列表筛选
    private PopupWindow popupWindow;
    private View popuWindSelectView;
    //显示泡泡窗口是否已经弹出
    private boolean isPopuWindShow;
    /**热销Icon适配器*/
    private RecommandIconAdapter recommandIconAdapter;
    /**推荐热卖产品*/
    private IndexHotProductsAdapter indexHotProductsAdapter;
    /**店铺列表适配器*/
    private IndexQueryVendorAdapter indexQueryVendorAdapter;
    /**是否刷新执行了刷新操作*/
    private boolean refresh;
    /**店铺列表当前页*/
    private int Page=1;
    /**排序*/
    private int Sort=0;



    @Override
    protected HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void initUI() {
        //刷新组件
        UIHelper.initRefreshView(layoutRefresh);
        layoutRefresh.setColorSchemeResources(R.color.color_refresh);
        layoutRefresh.setOnRefreshListener(this);
        //加载组件
        pagedLoader=PagedLoader.from(storeLists).setOnLoadListener(this).builder();
        //店铺列表适配器
        indexQueryVendorAdapter=new IndexQueryVendorAdapter(activity);
        pagedLoader.setAdapter(indexQueryVendorAdapter);
        storeLists.setAdapter(indexQueryVendorAdapter);
        storeLists.setOnItemClickListener(mStoreOnItemClickListener);

        //初始化头布局
        initHeader();
        //初始化泡泡窗口(店铺筛选)
        popupWindow=PopupHelper.getInstance().newBasicPopupWindow(activity, PopupHelper.PopStyle.MATCH_PARENT);
        popuWindSelectView=activity.getLayoutInflater().inflate(R.layout.window_popu,null);
        popupWindow.setContentView(popuWindSelectView);
        popupWindow.setOutsideTouchable(false);
    }

    private void initHeader() {
        View view = activity.getLayoutInflater().inflate(R.layout.heander_home, null);
        storeLists.addHeaderView(view);
        //推荐热销ICON
        recommandIconAdapter=new RecommandIconAdapter(activity);
        //爆款列表
        indexHotProductsAdapter = new IndexHotProductsAdapter(activity);

        heandViewHolder=new HeandViewHolder(view);
        heandViewHolder.gridviewWineRecommand.setAdapter(indexHotProductsAdapter);
        heandViewHolder.gridviewWineRecommand.setOnItemClickListener(mHotProductClickListener);

        heandViewHolder.gvIcon.setAdapter(recommandIconAdapter);
        heandViewHolder.gvIcon.setOnItemClickListener(mOnItemClickListener);
    }

    @Override
    public void initData() {
        //获取轮播图
        CmsActivityBannerRequestModel();
        //热销icon(多于四个只取前四个)
        GetIndexIcon();
        //广告位
        GetIndexAd();
        //获取热卖产品
        GetProductLibList();
        //搜索附近商家
        QueryVendor();
        layoutRefresh.setRefreshing(true);
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
    public void CmsActivityBannerRequestModel() {
        mvpPresenter.GetIndexBanner();
    }

    @Override
    public void CmsActivityBannerRequestModelResult(boolean success, ArrayList<BannerBean> bannerList, String msg) {
        if (success) {
            heandViewHolder.bannerHome.setADfixXY(true);
            heandViewHolder.bannerHome.setImageResources(bannerList, new BanerView.BannerOnclickListner() {
                @Override
                public void onImageClick(int position, BannerBean bannerBean, View imageView) {

                }
            });
            heandViewHolder.bannerHome.startImageCycle();
        }
    }

    @Override
    public void GetIndexIcon() {
        mvpPresenter.GetIndexIcon();
    }

    @Override
    public void GetIndexIconResult(boolean success, List<com.a365vintagewine.mvp.model.bean.BannerBean> bannerBeanList, String msg) {
        if(success && bannerBeanList!=null){
            recommandIconAdapter.clearAdapter();
            recommandIconAdapter.addAdapterData(bannerBeanList);
        }
    }

    @Override
    public void GetIndexAd() {
        mvpPresenter.GetIndexAd();
    }

    @Override
    public void GetIndexAdResult(boolean success, List<com.a365vintagewine.mvp.model.bean.BannerBean> bannerBeanList, String msg) {
        if(success && bannerBeanList!=null && bannerBeanList.size()>0){
            UIHelper.imageNet(activity,bannerBeanList.get(0).getPicURL(),heandViewHolder.imgHomeAcivity,false);
        }
    }

    @Override
    public void GetProductLibList() {
        mvpPresenter.GetProductLibList();
    }

    @Override
    public void GetProductLibListResult(boolean success, String msg, List<ProductLibBean> list) {
        if (success){
            indexHotProductsAdapter.addAdapterData(list);
        }
    }


    @Override
    public void QueryVendor() {
        Geo geo=new Geo();
        geo.setLat(40.083896);
        geo.setLng(116.341409);

        QueryVendorParams queryVendorParams=new QueryVendorParams();
        queryVendorParams.setQ("");
        queryVendorParams.setSort(Sort+"");
        queryVendorParams.setGeo(geo);
        queryVendorParams.setPage(Page+"");
        queryVendorParams.setTake(10+"");
        mvpPresenter.QueryVendor(queryVendorParams);
    }

    @Override
    public void QueryVendorResulst(boolean success, String msg, List<QueryVendorBean> list) {
        layoutRefresh.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (refresh){
            indexQueryVendorAdapter.clearAdapter();
        }
        if (success && list!=null && list.size()>0){
            indexQueryVendorAdapter.addAdapterData(list);
            Page++;
        }
        if (indexQueryVendorAdapter.getAdapterData().size()==0){
            layoutDataEmpty.setVisibility(View.VISIBLE);
        }else {
            layoutDataEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        refresh=true;
        Page=1;
        QueryVendor();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh=false;
        QueryVendor();
    }

    /**附近商家列表筛选控件转变*/
    private void resetSelectItem(TextView tvSelect){
        heandViewHolder.tvSearchComprehensive.setTextColor(ContextCompat.getColor(activity,R.color.corlor_666));
        heandViewHolder.tvSearchSalesvolume.setTextColor(ContextCompat.getColor(activity,R.color.corlor_666));
        heandViewHolder.tvSearchEvaluate.setTextColor(ContextCompat.getColor(activity,R.color.corlor_666));
        heandViewHolder.tvSearchScreen.setTextColor(ContextCompat.getColor(activity,R.color.corlor_666));
        tvSelect.setTextColor(ContextCompat.getColor(activity,R.color.black));
    }

    /**热销ICON点击监听*/
    private AdapterView.OnItemClickListener mOnItemClickListener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            com.a365vintagewine.mvp.model.bean.BannerBean banner=recommandIconAdapter.getAdapterData().get(position);
            SearchShopGoodsActivity.launch(activity,"",banner.getTitle(),"","");
        }
    };


    /**热卖产品列表点击监听*/
    private AdapterView.OnItemClickListener mHotProductClickListener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ProductLibBean productLibBean= (ProductLibBean) parent.getAdapter().getItem(position);
            SearchShopGoodsActivity.launch(activity,"",productLibBean.getProductLibName(),"","");
        }
    };

    /**店铺列表点击事件监听*/
    private AdapterView.OnItemClickListener mStoreOnItemClickListener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            QueryVendorBean queryVendorBean=indexQueryVendorAdapter.getItem(position-1);
            BusinessHomeActivity.launch(activity,queryVendorBean.getId());
        }
    };




    class HeandViewHolder {
        @Bind(R.id.banner_home)
        BanerView bannerHome;
        @Bind(R.id.gvIcon)
         MyGridView gvIcon;
        @Bind(R.id.img_home_acivity)
        ImageView imgHomeAcivity;
        @Bind(R.id.gridview_WineRecommand)
        MyGridView gridviewWineRecommand;
        @Bind(R.id.tv_search_comprehensive)
        TextView tvSearchComprehensive;
        @Bind(R.id.tv_search_salesvolume)
        TextView tvSearchSalesvolume;
        @Bind(R.id.tv_search_evaluate)
        TextView tvSearchEvaluate;
        @Bind(R.id.tv_search_screen)
        TextView tvSearchScreen;
        @Bind(R.id.ll_search_screen)
        LinearLayout llSearchScreen;

         @OnClick(R.id.img_home_acivity)
         public void onImgHomeActivity(){
             showToast("");
         }

         @OnClick(R.id.tv_search_comprehensive)
         public void onTvCompreshensive(){
             showToast("综合排序");
             resetSelectItem(tvSearchComprehensive);
         }

         @OnClick(R.id.tv_search_salesvolume)
         public void onTvSalevolume(){
             showToast("销售数量");
             resetSelectItem(tvSearchSalesvolume);
         }

         @OnClick(R.id.tv_search_evaluate)
         public void onTvEvaluatate(){
             showToast("评价最好");
             resetSelectItem(tvSearchEvaluate);
         }

         @OnClick(R.id.tv_search_screen)
         public void onTvScreen(){
             showToast("筛选");
             resetSelectItem(tvSearchScreen);
           //  popupWindow.showAsDropDown(layoutActionBar);
             popupWindow.showAtLocation(LayoutInflater.from(activity).inflate(R.layout.fragment_home, null),
                     Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
             isPopuWindShow=true;
         }
         HeandViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
