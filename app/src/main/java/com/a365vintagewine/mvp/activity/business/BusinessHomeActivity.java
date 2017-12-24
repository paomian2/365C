package com.a365vintagewine.mvp.activity.business;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.BusinessGoodsListAdapter;
import com.a365vintagewine.adapter.BusinessHotGoodsAdapter;
import com.a365vintagewine.adapter.GalleryGoodsClassAdapter;
import com.a365vintagewine.mvp.activity.LoginActivity;
import com.a365vintagewine.mvp.activity.WebActivity;
import com.a365vintagewine.mvp.activity.goods.GoodsDetailActivity;
import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.a365vintagewine.mvp.model.bean.BusinessActivityBean;
import com.a365vintagewine.mvp.model.bean.CategorityBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBasicInfo;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.presenter.business.BusinessPresenter;
import com.a365vintagewine.mvp.view.BusinessHomeView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.widget.AutoVerticalScrollTextView;
import com.a365vintagewine.widget.MyDecoration;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.PhoneUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.MyGridView;
import com.commsdk.common.widget.PagedLoader;
import com.commsdk.common.widget.banner.BanerView;

import java.util.ArrayList;
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
 * 时间:2017年09月04日  10:07
 * 版本：3.0
 */

public class BusinessHomeActivity extends BaseMVPActivity<BusinessPresenter> implements BusinessHomeView,
        SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener {


    /**
     * 商品列表
     */
    @Bind(R.id.recycler_goodsList)
    RecyclerView recyclerGoodsList;
    /**
     * 刷新控件
     */
    @Bind(R.id.refrenshLayout)
    SwipeRefreshLayout refrenshLayout;
    /**
     * 商品列表适配器
     */
    private BusinessGoodsListAdapter businessGoodsListAdapter;
    /**
     * 热销商品适配器
     */
    private BusinessHotGoodsAdapter businessHotGoodsAdapter;
    /**
     * 商品分类适配器
     */
    private GalleryGoodsClassAdapter galleryGoodsClassAdapter;
    private int height = 1400;// 滑动开始变色的高,真实项目中此高度是由广告轮播或其他首页view高度决定
    private int overallXScroll = 0;

    /**
     * 隐藏的ActionBar
     */
    @Bind(R.id.layoutTitle)
    RelativeLayout layoutTitle;
    /**
     * 标题名称
     */
    @Bind(R.id.tvTitleName)
    TextView tvTitleName;
    /**
     * 返回控件
     */
    @Bind(R.id.img_back)
    ImageView img_back;
    /**
     * 消息控件
     */
    @Bind(R.id.rl_myself_msg)
    RelativeLayout rl_myself_msg;
    /**
     * 收藏控件
     */
    @Bind(R.id.img_attention)
    ImageView img_attention;
    /**
     * 头布局
     */
    private ViewHolder viewHolder;
    /**
     * 购物车商品数量
     */
    @Bind(R.id.tv_goodsDetail_goodsnum)
    TextView tvGoodsDetailGoodsnum;
    /**
     * 商品总价
     */
    @Bind(R.id.tv_goodsDetail_totalprice)
    TextView tvGoodsDetailTotalprice;
    /**
     * 配送费
     */
    @Bind(R.id.tv_goodsDetail_shippingfee)
    TextView tvGoodsDetailShippingfee;

    //列表标题控件

    /**
     * 店铺Id
     */
    private int storeId;

    /**
     * 商品列表当前页面
     */
    private int Page = 1;
    /**
     * 是否进行了刷新操作
     */
    private boolean refresh;
    /**
     * 商品排序规则
     */
    private int Sort = 0;
    /**
     * 类目Id
     */
    private String categoryId = "";
    /**
     * 活动切换记录专用
     */
    private int number = 0;
    /**
     * 活动是否正常切换
     */
    private boolean isRunning = true;
    /**
     * 活动列表
     */
    private List<BusinessActivityBean> activityBeanList = new ArrayList<>();
    /**
     * 用户是否已关注该门店
     */
    private boolean IsFav;


    public static void launch(BaseActivity activity, int storeId) {
        Intent intent = new Intent();
        intent.setClass(activity, BusinessHomeActivity.class);
        intent.putExtra("storeId", storeId);
        AppActivityManager.getInstance().goTo(activity, intent);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        storeId = getIntent().getIntExtra("storeId", 0);
    }

    @Override
    protected BusinessPresenter createPresenter() {
        return new BusinessPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_business_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }

    @Override
    protected void initUI() {

        UIHelper.initRefreshView(refrenshLayout);
        refrenshLayout.setOnRefreshListener(this);

        recyclerGoodsList.setLayoutManager(new LinearLayoutManager(this));
        recyclerGoodsList.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerGoodsList.addItemDecoration(new DividerItemDecoration(this, MyDecoration.VERTICAL_LIST));
        businessGoodsListAdapter = new BusinessGoodsListAdapter(activity);
        businessGoodsListAdapter.setOnProductItemClickListener(mOnProductItemClickListener);
        initHeaderAndFooter();
        recyclerGoodsList.setAdapter(businessGoodsListAdapter);
        //监听列表滑动设置actionBar
        recyclerGoodsList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                overallXScroll = overallXScroll + dy;// 累加y值 解决滑动一半y值为0
                if (overallXScroll < 1200) {   //设置标题的背景颜色
                    layoutTitle.setBackgroundResource(R.drawable.bg_empty);
                    tvTitleName.setVisibility(View.GONE);
                    img_back.setVisibility(View.INVISIBLE);
                    rl_myself_msg.setVisibility(View.INVISIBLE);
                    img_attention.setVisibility(View.INVISIBLE);
                } else if (overallXScroll > 1200 && overallXScroll <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    float scale = (float) overallXScroll / height;
                    float alpha = (255 * scale);
                    layoutTitle.setBackgroundColor(Color.argb((int) alpha, 41, 193, 246));
                    tvTitleName.setVisibility(View.VISIBLE);
                    img_back.setVisibility(View.VISIBLE);
                    rl_myself_msg.setVisibility(View.VISIBLE);
                    img_attention.setVisibility(View.VISIBLE);
                } else {
                    layoutTitle.setBackgroundColor(Color.argb(255, 41, 193, 246));
                    tvTitleName.setVisibility(View.VISIBLE);
                    tvTitleName.setVisibility(View.VISIBLE);
                    img_back.setVisibility(View.VISIBLE);
                    rl_myself_msg.setVisibility(View.VISIBLE);
                    img_attention.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void initData() {
        //商家基本数据
        GetConsignorBasicInfo();
        //商家Banner
        GetConsignorBanner();
        //商家热销排行
        GetConsignorHotProducts();
        //获取商品分类
        QueryCategory();
        //获取商品列表
        QueryProductList();
        //获取商家购物车数量
        GetProductCount();
        refrenshLayout.setRefreshing(true);
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


    private void initHeaderAndFooter() {
        View view = getLayoutInflater().inflate(R.layout.item_business_home_header, null);
        viewHolder = new ViewHolder(view);
        businessGoodsListAdapter.setHeaderView(view);
        businessGoodsListAdapter.setHeaderHolder(viewHolder);
        //热卖商品设置
        businessHotGoodsAdapter = new BusinessHotGoodsAdapter(this);
        businessHotGoodsAdapter.setOnHotGoodsItemClickListener(mOnHotGoodsItemClickListener);
        viewHolder.gvHotGoods.setAdapter(businessHotGoodsAdapter);
        //商品种类筛选

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.recycleGoodsClass.setLayoutManager(linearLayoutManager);
        //商品分类适配器
        galleryGoodsClassAdapter = new GalleryGoodsClassAdapter(this);
        viewHolder.recycleGoodsClass.setAdapter(galleryGoodsClassAdapter);
        galleryGoodsClassAdapter.setOnCategoryItemClick(mOnCategoryItemClick);
    }


    @Override
    public void GetConsignorBasicInfo() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Consignor_Id", storeId + "");
        mvpPresenter.GetConsignorBasicInfo(params);
    }

    @Override
    public void GetConsignorBasicInfoResult(boolean success, String msg, ConsignorBasicInfo consignorBasicInfo) {
        //设置商家基本信息
        if (success) {
            UIHelper.imageNet(activity, consignorBasicInfo.getStoreLogo() + "", viewHolder.imgBusinessLogo, false, R.mipmap.img_def);
            viewHolder.tvBusinessName.setText(consignorBasicInfo.getConsignorName());
            viewHolder.tvBusinessAdress.setText(consignorBasicInfo.getAddress());
            IsFav = consignorBasicInfo.isFav();
            if (IsFav) {
                viewHolder.imgAttention.setImageResource(R.mipmap.collection);
                img_attention.setImageResource(R.mipmap.collection);
            } else {
                viewHolder.imgAttention.setImageResource(R.mipmap.no_collection);
                img_attention.setImageResource(R.mipmap.no_collection);
            }
            //隐藏的actionBar
            tvTitleName.setText(consignorBasicInfo.getConsignorName());
            //设置活动
            viewHolder.tvGotoActivity.setText(consignorBasicInfo.getActivityCount() + "个活动");
            activityBeanList.addAll(consignorBasicInfo.getActivityList());
            viewHolder.tvAdvice.setText(activityBeanList.get(0).getActivityDesc());
            new Thread() {
                @Override
                public void run() {
                    while (isRunning) {
                        SystemClock.sleep(3000);
                        mHandle.sendEmptyMessage(199);
                    }
                }
            }.start();

        } else {
            showToast(msg);
            finish();
        }
    }

    @Override
    public void GetConsignorBanner() {
        Map<String, Object> params = new HashMap<>();
        params.put("Consignor_Id", storeId + "");
        mvpPresenter.GetConsignorBanner(params);
    }

    @Override
    public void GetConsignorBannerResult(boolean success, String msg, List<BannerBean> bannerBeen) {
        if (success && bannerBeen != null) {
            ArrayList<com.commsdk.common.widget.banner.BannerBean> bannerBeanList = new ArrayList<>();
            for (BannerBean bannerBeanTemp : bannerBeen) {
                com.commsdk.common.widget.banner.BannerBean bannerBean = new com.commsdk.common.widget.banner.BannerBean();
                bannerBean.setStoreId(bannerBeanTemp.getContent_Id() + "");
                bannerBean.setTheme(bannerBeanTemp.getTitle());
                bannerBean.setAdPic(bannerBeanTemp.getPicURL());
                bannerBean.setJumpUrl(bannerBeanTemp.getURLaddress());
                bannerBeanList.add(bannerBean);
            }
            viewHolder.banner.setImageResources(bannerBeanList, new BanerView.BannerOnclickListner() {
                @Override
                public void onImageClick(int position, com.commsdk.common.widget.banner.BannerBean bannerBean, View imageView) {
                    WebActivity.launcher(activity, bannerBean.getJumpUrl());
                }
            });
        } else {
            viewHolder.banner.setVisibility(View.GONE);
        }
    }

    @Override
    public void GetConsignorHotProducts() {
        Map<String, Object> params = new HashMap<>();
        params.put("Consignor_Id", storeId + "");
        mvpPresenter.GetConsignorHotProducts(params);
    }

    @Override
    public void GetConsignorHotProductsResult(boolean success, String msg, List<ProductsBean> list) {
        if (success && list != null && list.size() > 0) {
            businessHotGoodsAdapter.addAdapterData(list);
        } else {
            viewHolder.layoutHot.setVisibility(View.GONE);
        }
    }

    @Override
    public void QueryCategory() {
        Map<String, Object> params = new HashMap<>();
        params.put("Q", "");//商品id code 名称 或关键词
        params.put("B", "");//品牌id 多个以','分隔
        params.put("C", "");//类目id 多个以','分隔
        params.put("D", "");//配送方式id 多个以','分隔
        params.put("Geo", null);//经纬度
        params.put("Sort", "0");//排序 0默认(如果geo不为null 则按距离倒序列) 1销量降序 2价格升序 3价格降序 4 评论降序
        params.put("Page", 1 + "");//页数
        params.put("Take", 50 + "");//分页大小 最大50
        params.put("Vendor", storeId + "");//商家id
        params.put("Consignor_Id", storeId + "");//商家id
        params.put("PriceF", "");//价格区间起始值
        params.put("PriceT", "");//价格区间结束值
        params.put("Group", true);//是否按商家分组
        params.put("Facet", true);//是否聚合品牌和配送方式
        mvpPresenter.Query(params);
    }

    @Override
    public void QueryCategoryResult(boolean success, String msg, QueryResponse queryResponse) {
        if (success && queryResponse != null && queryResponse.getData() != null && queryResponse.getData().size() > 0) {
            //设置商品分类
            List<CategorityBean> categorityBeanList = queryResponse.getData().get(0).getCategories();
            if (categorityBeanList != null && categorityBeanList.size() > 0) {
                CategorityBean categorityBean = new CategorityBean();
                categorityBean.setId(-1);
                categorityBean.setName("全部商品");
                categorityBean.setLevel(3);
                galleryGoodsClassAdapter.addAdapterData(categorityBean);
                for (CategorityBean categorityBeanTemp : categorityBeanList) {
                    if (categorityBeanTemp.getLevel() == 3) {
                        galleryGoodsClassAdapter.addAdapterData(categorityBeanTemp);
                    }
                }
            }
        }
    }

    @Override
    public void QueryProductList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Q", "");//商品id code 名称 或关键词
        params.put("B", "");//品牌id 多个以','分隔
        params.put("C", categoryId);//类目id 多个以','分隔
        params.put("D", "");//配送方式id 多个以','分隔
        params.put("Geo", null);//经纬度
        params.put("Sort", Sort + "");//排序 0默认(如果geo不为null 则按距离倒序列) 1销量降序 2价格升序 3价格降序 4 评论降序
        params.put("Page", Page + "");//页数
        params.put("Take", 50 + "");//分页大小 最大50
        params.put("Vendor", storeId + "");//商家id
        params.put("Consignor_Id", storeId + "");//商家id
        params.put("PriceF", "");//价格区间起始值
        params.put("PriceT", "");//价格区间结束值
        params.put("Group", false);//是否按商家分组
        params.put("Facet", false);//是否聚合品牌和配送方式
        mvpPresenter.QueryProductList(params);
    }

    @Override
    public void QueryProductListResult(boolean success, String msg, List<ProductsBean> list) {
        refrenshLayout.setRefreshing(false);
        if (refresh) {
            businessGoodsListAdapter.clearAdapter();
        }
        if (success && list != null) {
            businessGoodsListAdapter.addAdapterData(list);
            Page++;
        }
    }

    @Override
    public void GetProductCount() {
        String Client_Id = SharePreferenceUtils2.getClient_Id(activity);
        if (!StringUtils.isEmpty(Client_Id)) {
            Map<String, Object> params = new HashMap<>();
            params.put("Client_Id", Client_Id);
            params.put("virtualName", SharePreferenceUtils2.getClient_Id(activity));
            params.put("Channel", 23 + "");//平台(1:wx,17:M站,23:APP)
            params.put("Media", null);
            params.put("Consignor_Id", storeId + "");
            params.put("ShopCartType", 1 + "");//购物车类型（1：普通购物车，8：积分商品购物车）
            mvpPresenter.GetProductCount(params);
        }
    }

    @Override
    public void GetProductCountResult(boolean success, String msg, ShopCarProductCountBean shopCarProductCountBean) {
        if (success) {
            showShopCartData(shopCarProductCountBean);
        }
    }

    @Override
    public void AddProduct(Map<String, Object> params) {
        mvpPresenter.AddProduct(params);
    }

    @Override
    public void AddProductResult(boolean success, String msg, List<ShopCarBean> list) {
        showToast(msg);
        if (success) {
            GetProductCount();
        }
    }

    @Override
    public void AddFavoriteShopList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Consignor_Id", storeId + "");
        mvpPresenter.AddFavoriteShopList(params);
    }

    @Override
    public void AddFavoriteShopListResult(boolean success, String msg) {
        if (success) {
            IsFav = true;
            viewHolder.imgAttention.setImageResource(R.mipmap.collection);
            img_attention.setImageResource(R.mipmap.collection);
        } else {
            showToast(msg);
        }
    }

    @Override
    public void DelFavoriteShopList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Consignor_Id", storeId + "");
        mvpPresenter.DelFavoriteShopList(params);
    }

    @Override
    public void DelFavoriteShopListResult(boolean success, String msg) {
        if (success) {
            IsFav = false;
            viewHolder.imgAttention.setImageResource(R.mipmap.no_collection);
            img_attention.setImageResource(R.mipmap.no_collection);
        } else {
            showToast(msg);
        }
    }

    @Override
    public void onRefresh() {
        refresh = true;
        Page = 1;
        QueryProductList();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        QueryProductList();
    }

    /**
     * 设置购物车栏数据
     */
    public void showShopCartData(ShopCarProductCountBean shopCarProductCountBean) {
        if (shopCarProductCountBean.getSumProductCount() > 0) {
            tvGoodsDetailGoodsnum.setVisibility(View.VISIBLE);
            tvGoodsDetailGoodsnum.setText(shopCarProductCountBean.getSumProductCount() + "");
            tvGoodsDetailTotalprice.setText("¥" + shopCarProductCountBean.getSumProductPrice());
            tvGoodsDetailShippingfee.setText("" + shopCarProductCountBean.getPeiSongFei());
        } else {
            tvGoodsDetailGoodsnum.setVisibility(View.GONE);
        }
    }


    /**
     * 热卖商品点击事件监听
     */
    private BusinessHotGoodsAdapter.OnHotGoodsItemClickListener mOnHotGoodsItemClickListener = new BusinessHotGoodsAdapter.OnHotGoodsItemClickListener() {
        @Override
        public void onHoGoodsAddCar(ProductsBean productsBean, int position) {
            if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
                Map<String, Object> params = new HashMap<>();
                params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
                params.put("virtualName", PhoneUtil.getInstance(activity).getIMEI());
                params.put("Channel", "23");//平台(1:wx,17:M站,23:APP)
                params.put("Media", "");
                params.put("Consignor_Id", storeId + "");
                params.put("ActivityId", "1");//商品活动类型(1:普通商品，2：限制折扣，3：满减活动，8：积分兑换活动)
                params.put("ProductCode", productsBean.getProductCode());
                params.put("ProductNum", "1");
                params.put("ActionID", "0");//商品活动ID 没值传入0
                AddProduct(params);
            } else {
                LoginActivity.launch(activity);
            }
        }

        @Override
        public void onHotGoodsItemClick(ProductsBean productsBean, int position) {
            GoodsDetailActivity.launch(activity, productsBean.getProduct_Id() + "", "", "0");
        }
    };


    /**
     * 商品列表分类选择点击
     */
    private GalleryGoodsClassAdapter.OnCategoryItemClick mOnCategoryItemClick = new GalleryGoodsClassAdapter.OnCategoryItemClick() {
        @Override
        public void onItemClick(CategorityBean categorityBean, int position) {
            for (CategorityBean categorityBeanTemp : galleryGoodsClassAdapter.getAdapterData()) {
                categorityBeanTemp.setSelect(false);
            }
            categorityBean.setSelect(true);
            galleryGoodsClassAdapter.notifyDataSetChanged();
            if (categorityBean.getId() == -1) {
                categoryId = "";
            } else {
                categoryId = categorityBean.getId() + "";
            }
            onRefresh();
        }
    };


    /**
     * 商品列表点击事件
     */
    private BusinessGoodsListAdapter.OnProductItemClickListener mOnProductItemClickListener = new BusinessGoodsListAdapter.OnProductItemClickListener() {

        @Override
        public void onAddShopCar(ProductsBean productsBean, int position) {
            if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
                Map<String, Object> params = new HashMap<>();
                params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
                params.put("virtualName", PhoneUtil.getInstance(activity).getIMEI());
                params.put("Channel", "23");//平台(1:wx,17:M站,23:APP)
                params.put("Media", "");
                params.put("Consignor_Id", storeId + "");
                params.put("ActivityId", "1");//商品活动类型(1:普通商品，2：限制折扣，3：满减活动，8：积分兑换活动)
                params.put("ProductCode", productsBean.getCode());
                params.put("ProductNum", "1");
                params.put("ActionID", "0");//商品活动ID 没值传入0
                AddProduct(params);
            } else {
                LoginActivity.launch(activity);
            }
        }

        @Override
        public void onProductItemClick(ProductsBean productsBean, int position) {
            GoodsDetailActivity.launch(activity, productsBean.getCode() + "", "1", "");
        }
    };


    /**
     * 活动切换
     */
    @SuppressLint("HandlerLeak")
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 199) {
                viewHolder.tvAdvice.next();
                number++;
                int position = number % activityBeanList.size();
                viewHolder.tvAdvice.setText(activityBeanList.get(position).getActivityDesc());
            }
        }
    };


    /**
     * 列表头布局信息
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * 我的消息
         */
        @Bind(R.id.myself_msg)
        ImageView myselfMsg;
        /**
         * 我的消息数量
         */
        @Bind(R.id.tv_myself_msgcount)
        TextView tvMyselfMsgcount;
        /**
         * 我的消息布局
         */
        @Bind(R.id.rl_myself_msg)
        RelativeLayout rlMyselfMsg;
        /**
         * 关注
         */
        @Bind(R.id.img_attention)
        ImageView imgAttention;
        /**
         * 门店LOGO
         */
        @Bind(R.id.imgBusinessLogo)
        ImageView imgBusinessLogo;
        /**
         * 门店名称
         */
        @Bind(R.id.tvBusinessName)
        TextView tvBusinessName;
        /**
         * 商家地址
         */
        @Bind(R.id.tvBusinessAdress)
        TextView tvBusinessAdress;
        /**
         * 充值
         */
        @Bind(R.id.tvRecharge)
        TextView tvRecharge;
        /**
         * 广告切换
         */
        @Bind(R.id.tvAdvice)
        AutoVerticalScrollTextView tvAdvice;
        /**
         * 广告数量
         */
        @Bind(R.id.tvGotoActivity)
        TextView tvGotoActivity;
        /**
         * 搜索
         */
        @Bind(R.id.layoutSearch)
        RelativeLayout layoutSearch;
        /**
         * 商家Banner
         */
        @Bind(R.id.banner)
        BanerView banner;
        /**
         * 商家热销
         */
        @Bind(R.id.gvHotGoods)
        MyGridView gvHotGoods;
        /**
         * 商家热销布局
         */
        @Bind(R.id.layoutHot)
        LinearLayout layoutHot;
        /**
         * 商品分类
         */
        @Bind(R.id.recycleGoodsClass)
        RecyclerView recycleGoodsClass;
        /**
         * 综合排序
         */
        @Bind(R.id.tv_search_comprehensive)
        TextView tvSearchComprehensive;
        /**
         * 销售数量
         */
        @Bind(R.id.tv_search_salesvolume)
        TextView tvSearchSalesvolume;
        /**
         * 评价数量
         */
        @Bind(R.id.tv_search_evaluate)
        TextView tvSearchEvaluate;
        /**
         * 筛选
         */
        @Bind(R.id.tv_search_screen)
        TextView tvSearchScreen;
        @Bind(R.id.ll_search_screen)
        LinearLayout llSearchScreen;

        /**
         * 返回
         */
        @OnClick(R.id.img_back)
        public void img_back() {
            finish();
        }

        /**
         * 进入消息列表
         */
        @OnClick(R.id.rl_myself_msg)
        public void rl_myself_msg() {
            if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
                showToast("进入消息");
            }else{
                LoginActivity.launch(activity);
            }
        }

        /**
         * 收藏
         */
        @OnClick(R.id.img_attention)
        public void img_attention() {
            if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
                if (IsFav) {
                    DelFavoriteShopList();
                } else {
                    AddFavoriteShopList();
                }
            } else {
                LoginActivity.launch(activity);
            }
        }

        /**
         * 充值
         */
        @OnClick(R.id.tvRecharge)
        public void tvRecharge() {
            if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
                showToast("充值");
            }else{
                LoginActivity.launch(activity);
            }
        }


        /**
         * 商品综合排序
         */
        @OnClick(R.id.tv_search_comprehensive)
        public void tv_search_comprehensive() {
            tvSearchComprehensive.setTextColor(ContextCompat.getColor(activity, R.color.blue));
            tvSearchSalesvolume.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            tvSearchEvaluate.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            Sort = 0;
            onRefresh();
        }

        /**
         * 销量最高
         */
        @OnClick(R.id.tv_search_salesvolume)
        public void tv_search_salesvolume() {
            tvSearchComprehensive.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            tvSearchSalesvolume.setTextColor(ContextCompat.getColor(activity, R.color.blue));
            tvSearchEvaluate.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            Sort = 1;
            onRefresh();
        }

        /**
         * 评价最好
         */
        @OnClick(R.id.tv_search_evaluate)
        public void tv_search_evaluate() {
            tvSearchComprehensive.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            tvSearchSalesvolume.setTextColor(ContextCompat.getColor(activity, R.color.corlor_666));
            tvSearchEvaluate.setTextColor(ContextCompat.getColor(activity, R.color.blue));
            Sort = 2;
            onRefresh();
        }

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    /**
     * 返回
     */
    @OnClick(R.id.img_back)
    public void img_back() {
        finish();
    }

    /**
     * 收藏
     */
    @OnClick(R.id.img_attention)
    public void img_attention() {
        if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {
            if (IsFav) {
                DelFavoriteShopList();
            } else {
                AddFavoriteShopList();
            }
        } else {
            LoginActivity.launch(activity);
        }
    }


    /**
     * 去结算
     */
    @OnClick(R.id.btn_goodsDetail_settlement)
    public void btn_goodsDetail_settlement() {
        if (!StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))) {

        }else{
            LoginActivity.launch(activity);
        }
    }
}
