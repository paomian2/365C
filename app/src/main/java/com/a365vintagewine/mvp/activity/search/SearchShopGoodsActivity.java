package com.a365vintagewine.mvp.activity.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.SearchSGAdapter;
import com.a365vintagewine.mvp.activity.business.BusinessHomeActivity;
import com.a365vintagewine.mvp.activity.goods.GoodsDetailActivity;
import com.a365vintagewine.mvp.model.bean.BranchBen;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.a365vintagewine.mvp.model.bean.DeliveryBean;
import com.a365vintagewine.mvp.model.bean.FacetsBean;
import com.a365vintagewine.mvp.model.bean.Geo;
import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.presenter.search.SearchSGPresenter;
import com.a365vintagewine.mvp.view.search.SearchSGView;
import com.a365vintagewine.widget.ScreenGoodsPw;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.PagedLoader;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchShopGoodsActivity extends BaseMVPActivity<SearchSGPresenter> implements SearchSGView,
        ScreenGoodsPw.CallbackSreenGoods, SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener {

    /**
     * 列表数据空的布局
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.et_title_search)
    EditText etTitleSearch;
    @Bind(R.id.tv_title_search)
    RelativeLayout tvTitleSearch;
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
    @Bind(R.id.lv_search_shopgoods)
    ListView lvSearchShopgoods;
    @Bind(R.id.refrenshLayout)
    SwipeRefreshLayout refrenshLayout;
    /**
     * 分页加载组件
     */
    private PagedLoader pagedLoader;

    private SearchSGAdapter searchSGAdapter;
    private ScreenGoodsPw pw;

    /**
     * 商品id code 名称 或关键词
     */
    private String Q = "";
    /**
     * 品牌id 多个以','分隔
     */
    private String B = "";
    /**
     * 类目id 多个以','分隔
     */
    private String C = "";
    /**
     * 配送方式id 多个以','分隔
     */
    private String D = "";
    /**
     * 排序 0默认(如果geo不为null 则按距离倒序列) 1销量降序 2价格升序 3价格降序 4 评论降序
     */
    private String Sort = "0";
    /**
     * 页数
     */
    private int Page = 1;
    /**
     * 商家id
     */
    private String Vendor = "";
    /**
     * 价格区间起始值
     */
    private String PriceF = "";
    /**
     * 价格区间结束值
     */
    private String PriceT = "";
    /**
     * 是否按商家分组
     */
    private boolean Group = true;
    /**
     * 是否聚合品牌和配送方式
     */
    private boolean Facet = true;
    /**
     * 品牌查询
     */
    private BranchBen branchBen;
    /**
     * 分类查询
     */
    private CategoryBean categoryBean;
    /**
     * 普通查询
     */
    public final static int SEARCH_ACTION_CODE_N = 0;
    /**
     * 品牌查询
     */
    public final static int SEARCH_ACTION_CODE_B = 1;
    /**
     * 分类查询
     */
    public final static int SEARCH_ACTION_CODE_C = 2;
    /**
     * 查询入口
     */
    private final static String ACTION_CODE = "actionCode";
    /**
     * 查询入口
     */
    private int actionCode = SEARCH_ACTION_CODE_N;
    /**
     * 筛选使用
     */
    private FacetsBean facetsBean;


    /**
     * 是否执行刷新操作
     */
    private boolean refresh;


    /**
     * 一般查询
     *
     * @param activity:当前页面
     * @param Vendor：店铺Id
     * @param search:关键字
     * @param categoryIds:分类Id
     * @param branchIds:品牌Id
     */
    public static void launch(BaseActivity activity, String Vendor, String search, String categoryIds, String branchIds) {
        Intent intent = new Intent(activity, SearchShopGoodsActivity.class);
        intent.putExtra("Vendor", Vendor);
        intent.putExtra("search", search);
        intent.putExtra("categoryIds", categoryIds);
        intent.putExtra("branchIds", branchIds);
        AppActivityManager.getInstance().goTo(activity, intent);
    }


    /**
     * 品牌查询入口
     *
     * @param activity:当前页面
     * @param branchBen:品牌
     */
    public static void launch(BaseActivity activity, int actionCode, BranchBen branchBen) {
        Intent intent = new Intent(activity, SearchShopGoodsActivity.class);
        intent.putExtra(ACTION_CODE, actionCode);
        intent.putExtra("branchBen", branchBen);
        AppActivityManager.getInstance().goTo(activity, intent);
    }


    /**
     * 分类查询入口
     *
     * @param activity:当前页面
     * @param categoryBean:分类
     */
    public static void launch(BaseActivity activity, int actionCode, CategoryBean categoryBean) {
        Intent intent = new Intent(activity, SearchShopGoodsActivity.class);
        intent.putExtra(ACTION_CODE, actionCode);
        intent.putExtra("categoryBean", categoryBean);
        AppActivityManager.getInstance().goTo(activity, intent);
    }


    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        actionCode = getIntent().getIntExtra(ACTION_CODE, SEARCH_ACTION_CODE_N);
        if (actionCode == SEARCH_ACTION_CODE_N) {
            Vendor = getIntent().getStringExtra("Vendor");
            Q = getIntent().getStringExtra("search");
            C = getIntent().getStringExtra("categoryIds");
            B = getIntent().getStringExtra("branchIds");
        } else if (actionCode == SEARCH_ACTION_CODE_B) {
            branchBen = (BranchBen) getIntent().getSerializableExtra("branchBen");
        } else if (actionCode == SEARCH_ACTION_CODE_C) {
            categoryBean = (CategoryBean) getIntent().getSerializableExtra("categoryBean");
        }
    }

    @Override
    protected SearchSGPresenter createPresenter() {
        return new SearchSGPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_search_shop_goods);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        UIHelper.initRefreshView(refrenshLayout);
        refrenshLayout.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(lvSearchShopgoods).setOnLoadListener(this).builder();
        searchSGAdapter = new SearchSGAdapter(activity);
        pagedLoader.setAdapter(searchSGAdapter);
        lvSearchShopgoods.setAdapter(searchSGAdapter);
        searchSGAdapter.setOnBusinessItemClick(mOnBusinessItemClick);


        if (!StringUtils.isEmpty(Q)) {
            etTitleSearch.setText(Q);
        }
        etTitleSearch.setOnEditorActionListener(mOnEditorActionListener);


    }

    @Override
    protected void initData() {
        switch (actionCode) {
            case SEARCH_ACTION_CODE_N:
                break;
            case SEARCH_ACTION_CODE_B:
                if (branchBen!=null){
                    B=branchBen.getBrand_Id()+"";
                }
                break;
            case SEARCH_ACTION_CODE_C:
                if (categoryBean!=null){
                    C=categoryBean.getId()+"";
                }
                break;
            default:
                break;
        }
        StoreGoodsQuery();
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

    @Override
    public void StoreGoodsQuery() {
        Geo geo = new Geo();
        geo.setLat(40.083896);
        geo.setLng(116.341409);

        Map<String, Object> params = new HashMap<>();
        params.put("Q", Q + "");
        params.put("B", B + "");
        params.put("C", C + "");
        params.put("D", D + "");
        params.put("Geo", new Gson().toJson(geo));
        params.put("Sort", Sort + "");
        params.put("Page", Page + "");
        params.put("Take", "15");
        params.put("Vendor", Vendor + "");
        params.put("PriceF", PriceF + "");
        params.put("PriceT", PriceT + "");
        params.put("Group", Group);
        params.put("Facet", Facet);
        mvpPresenter.StoreGoodsQuery(params);
    }

    @Override
    public void StoreGoodsQueryResult(boolean success, String msg, QueryResponse queryResponse) {
        refrenshLayout.setRefreshing(false);
        pagedLoader.setLoading(false);
        if (refresh) {
            searchSGAdapter.clearAdapter();
        }
        //设置店铺列表
        if (success && queryResponse != null && queryResponse.getData() != null && queryResponse.getData().size() > 0) {
            searchSGAdapter.addAdapterData(queryResponse.getData());
            Page++;
        }
        if (searchSGAdapter.getAdapterData().size() == 0) {
            layoutDataEmpty.setVisibility(View.VISIBLE);
        } else {
            layoutDataEmpty.setVisibility(View.GONE);
        }
        //设置品牌/配送方式
        if (success && queryResponse != null) {
            facetsBean = queryResponse.getFacets();
        }
    }


    @Override
    public void onRefresh() {
        refresh = true;
        Page = 1;
        StoreGoodsQuery();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        StoreGoodsQuery();
    }


    /**
     * Sort排序设置
     */
    private void swichItem(TextView textView) {
        tvSearchComprehensive.setTextColor(getResources().getColor(R.color.corlor_666));
        textPaint = tvSearchComprehensive.getPaint();
        textPaint.setFakeBoldText(false);
        tvSearchSalesvolume.setTextColor(getResources().getColor(R.color.corlor_666));
        textPaint = tvSearchSalesvolume.getPaint();
        textPaint.setFakeBoldText(false);
        tvSearchEvaluate.setTextColor(getResources().getColor(R.color.corlor_666));
        textPaint = tvSearchEvaluate.getPaint();
        textPaint.setFakeBoldText(false);
        tvSearchScreen.setTextColor(getResources().getColor(R.color.corlor_666));
        textPaint = tvSearchScreen.getPaint();
        textPaint.setFakeBoldText(false);

        textView.setTextColor(getResources().getColor(R.color.black));
        textPaint = textView.getPaint();
        textPaint.setFakeBoldText(true);
        onRefresh();
    }


    /**
     * 搜索框搜索监听
     */
    private TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                Q = etTitleSearch.getText().toString().trim();
                onRefresh();
            }
            return false;
        }
    };

    /**
     * 店铺列表点击事件监听
     */
    private SearchSGAdapter.OnBusinessItemClick mOnBusinessItemClick = new SearchSGAdapter.OnBusinessItemClick() {
        @Override
        public void onShopClick(QueryBean shopGoods) {
            BusinessHomeActivity.launch(activity, shopGoods.getId());
        }

        @Override
        public void onGoodsClick(QueryBean shopGoods, ProductsBean productsBean) {
            GoodsDetailActivity.launch(activity, productsBean.getCode(), "1", "0");
        }
    };

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 综合排序
     */
    @OnClick(R.id.tv_search_comprehensive)
    public void comprehensive() {
        Sort = "0";
        swichItem(tvSearchComprehensive);
    }

    /**
     * 销量最高
     */
    @OnClick(R.id.tv_search_salesvolume)
    public void salesvolume() {
        Sort = "1";
        swichItem(tvSearchSalesvolume);
    }

    /**
     * 评价最高
     */
    @OnClick(R.id.tv_search_evaluate)
    public void evaluate() {
        Sort = "4";
        swichItem(tvSearchEvaluate);
    }

    /**
     * 筛选
     */
    TextPaint textPaint;

    @OnClick(R.id.ll_search_screen)
    public void screen() {
        swichItem(tvSearchScreen);
        if (pw == null) {
            pw = new ScreenGoodsPw(activity, facetsBean);
            pw.showPopupWindow(llSearchScreen);
            pw.setCallbackScreenGoods(this);
        } else {
            pw.showPopupWindow(llSearchScreen);
        }


    }


    @Override
    public void setSreenGoods(List<DeliveryBean> deliveryBeanList, String startPrice, String endPrice, List<BranchBen> branchBenList) {
        //配送方式
        for (DeliveryBean deliveryBean:deliveryBeanList){
            if (deliveryBean.isSelect()){
                D=deliveryBean.getId();
                break;
            }
        }
        PriceF = startPrice;
        PriceT = endPrice;
        //品牌
        if (branchBenList != null && branchBenList.size() > 0) {
            B="";
            for (BranchBen branchBen : branchBenList) {
                if (branchBen.isSelect()) {
                    if (!StringUtils.isEmpty(B)) {
                        B += "," + branchBen.getBrand_Id();
                    } else {
                        B = branchBen.getBrand_Id() + "";
                    }
                }

            }
        }
        onRefresh();
    }


    /**
     * 搜索
     */
    @OnClick(R.id.tv_title_search)
    public void tv_title_search() {
        Q = etTitleSearch.getText().toString().trim();
        onRefresh();
    }

}
