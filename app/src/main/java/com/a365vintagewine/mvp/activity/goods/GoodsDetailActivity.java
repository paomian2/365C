package com.a365vintagewine.mvp.activity.goods;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.GoodsAttributeAdapter;
import com.a365vintagewine.adapter.GoodsEvaluateAdapter;
import com.a365vintagewine.mvp.activity.LoginActivity;
import com.a365vintagewine.mvp.model.bean.ProductInfoBean;
import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.a365vintagewine.mvp.presenter.goods.GoodsDetailPresenter;
import com.a365vintagewine.mvp.view.goods.GoodsDetailView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.widget.ImgTextView;
import com.a365vintagewine.widget.MsgSharePw;
import com.a365vintagewine.widget.NoScrollGridView;
import com.a365vintagewine.widget.addcar.AddCarListener;
import com.commsdk.BuildConfig;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.LogUtil;
import com.commsdk.common.PhoneUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.MyListview;
import com.commsdk.common.widget.banner.BanerView;
import com.commsdk.common.widget.banner.BannerBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsDetailActivity extends BaseMVPActivity<GoodsDetailPresenter> implements GoodsDetailView {


    /**主布局*/
    @Bind(R.id.layoutMain)
    LinearLayout layoutMain;
    /**
     * 商品标题
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 消息
     */
    @Bind(R.id.img_title_right)
    ImageView imgTitleRight;
    /**
     * 收藏
     */
    @Bind(R.id.tv_goodsDetail_collection)
    TextView tvGoodsDetailCollection;
    /**
     * 商品banner
     */
    @Bind(R.id.bannerView)
    BanerView bannerView;
    /**
     * 商品名称
     */
    @Bind(R.id.tv_goodsDetail_goodsname)
    ImgTextView tvGoodsDetailGoodsname;
    /**
     * 销量
     */
    @Bind(R.id.tv_goodsDetail_sellout)
    TextView tvGoodsDetailSellout;
    /**
     * 商品售价
     */
    @Bind(R.id.tv_goodsDetail_goodsPrice)
    TextView tvGoodsDetailGoodsPrice;
    /**
     * 市场价
     */
    @Bind(R.id.tv_goodsDetail_proposal_price)
    TextView tvGoodsDetailProposalPrice;
    /**
     * 加入购物车
     */
    @Bind(R.id.ll_goodsDetail_jion_shopcart)
    LinearLayout llGoodsDetailJionShopcart;
    /**点击加入购物车图片*/
    @Bind(R.id.imgAddShopCar)
    ImageView imgAddShopCar;
    /**
     * 月销量
     */
    @Bind(R.id.tv_goodsDetail_monthly_sales)
    TextView tvGoodsDetailMonthlySales;
    /**
     * 正常商品模块
     */
    @Bind(R.id.ll_goodsDetail_goodsprice)
    LinearLayout llGoodsDetailGoodsprice;
    /**
     * 商品积分
     */
    @Bind(R.id.tv_goodsDetail_integral)
    TextView tvGoodsDetailIntegral;
    /**
     * 立即兑换积分
     */
    @Bind(R.id.btn_goodsDetail_exchange)
    LinearLayout btnGoodsDetailExchange;
    /**
     * 兑换积分商品米克
     */
    @Bind(R.id.ll_goodsDetail_exchange)
    LinearLayout llGoodsDetailExchange;
    /**
     * 兑换积分商品米克
     */
    @Bind(R.id.gv_goodsDetail_goodsinfo)
    NoScrollGridView gvGoodsDetailGoodsinfo;
    @Bind(R.id.tv_goodsDetail_moreinfo)
    TextView tvGoodsDetailMoreinfo;
    @Bind(R.id.img_goodsDetail_morearrow)
    ImageView imgGoodsDetailMorearrow;
    /**
     * 展开更多
     */
    @Bind(R.id.ll_goodsDetail_moreinfo)
    LinearLayout llGoodsDetailMoreinfo;
    /**
     * 商品详情
     */
    @Bind(R.id.tv_goodsDetail_goodsDetail)
    TextView tvGoodsDetailGoodsDetail;
    /**
     * 商品评价
     */
    @Bind(R.id.tv_goodsDetail_evaluate)
    TextView tvGoodsDetailEvaluate;
    /**
     * 商品详情
     */
    @Bind(R.id.ll_goodsDetail_join_fragmeng)
    RelativeLayout llGoodsDetailJoinFragmeng;
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
    /**
     * 加入购物车图片
     */
    @Bind(R.id.img_goodsDetail_goodscart)
    ImageView imgGoodsDetailGoodscart;
    /**
     * 商品详情
     */
    @Bind(R.id.webView)
    WebView webView;
    /**
     * 评论列表
     */
    @Bind(R.id.lvEval)
    MyListview lvEval;
    /**
     * 商品详情或商品评论列表无数据
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**
     * 商品详情实体
     */
    private ProductInfoBean productInfoBean;
    private GoodsAttributeAdapter goodsAttributeAdapter;
    /**
     * 商品评论列表
     */
    private GoodsEvaluateAdapter goodsEvaluateAdapter;


    /**
     * 商品编号
     */
    private String ProductCode;
    /**
     * 活动类型
     */
    private String ActivityId;
    /**
     * 活动Id
     */
    private String ActionID;

    /**用户是否已关注该商品*/
    private boolean Favorite;
    /**加入购物车动画使用*/
    private PathMeasure mPathMeasure;
    private float[] mCurrentPosition = new float[2];
    private int goodsNum=0;
    /**加入购物车监听*/
    private AddCarListener addCarListener;



    public static void launch(BaseActivity activity, String ProductCode, String ActivityId, String ActionID) {
        Intent intent = new Intent();
        intent.setClass(activity, GoodsDetailActivity.class);
        intent.putExtra("ProductCode", ProductCode);
        intent.putExtra("ActivityId", ActivityId);
        intent.putExtra("ActionID", ActionID);
        AppActivityManager.getInstance().goTo(activity, intent);
    }


    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        ProductCode = getIntent().getStringExtra("ProductCode");
        ActivityId = getIntent().getStringExtra("ActivityId");
        ActionID = getIntent().getStringExtra("ActionID");
    }

    @Override
    protected GoodsDetailPresenter createPresenter() {
        return new GoodsDetailPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_goods_detail);
        ButterKnife.bind(this);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initUI() {
        tvTextTitle.setText("商品详情");
        //商品属性适配器
        goodsAttributeAdapter = new GoodsAttributeAdapter(activity);
        gvGoodsDetailGoodsinfo.setAdapter(goodsAttributeAdapter);
        //商品评论列表适配
        goodsEvaluateAdapter=new GoodsEvaluateAdapter(activity);
        lvEval.setAdapter(goodsEvaluateAdapter);
        //商品详情webView适配
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        webSettings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        webSettings.setDisplayZoomControls(false);//隐藏webview缩放按钮
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放
        //* 用WebView显示图片，可使用这个参数 设置网页布局类型：
        //* 1、LayoutAlgorithm.NARROW_COLUMNS ：适应内容大小
        //* 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        addCarListener=mAddCarListener;
    }

    @Override
    protected void initData() {
        GetProductInfo();
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
    public void GetProductInfo() {
        Map<String, Object> params = new HashMap<>();
        params.put("ProductCode", ProductCode);
        params.put("ActivityId", ActivityId);
        params.put("ActionID", ActionID);
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        mvpPresenter.GetProductInfo(params);
        UIHelper.showProgressDialog(activity, "数据加载中...");
    }

    @Override
    public void GetProductInfoResult(boolean success, String msg, ProductInfoBean productInfoBean) {
        UIHelper.cancleProgressDialog();
        if (!success) {
            showToast(msg);
            finish();
            return;
        }
        this.productInfoBean = productInfoBean;
        tvGoodsDetailGoodsname.setText(productInfoBean.getName() + "");
        tvGoodsDetailGoodsPrice.setText("¥  " + productInfoBean.getVipPrice());
        tvGoodsDetailProposalPrice.setText("¥" + productInfoBean.getSalePrice());
        tvGoodsDetailProposalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvGoodsDetailMonthlySales.setText(productInfoBean.getSaleCount() + "");
        //设置商品属性
        if (productInfoBean.getPropTexts() != null && productInfoBean.getPropTexts().size() > 0) {
            List<String> list = new ArrayList<>();
            list.addAll(productInfoBean.getPropTexts());
            setGoodsAttributeAdapter(list);
            llGoodsDetailMoreinfo.setVisibility(View.VISIBLE);
        } else {
            llGoodsDetailMoreinfo.setVisibility(View.GONE);
        }
        //是否已收藏
        Favorite=productInfoBean.isFavorite();
        if (Favorite) {
            Drawable nav_up = getResources().getDrawable(R.mipmap.collection);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvGoodsDetailCollection.setCompoundDrawables(null, nav_up, null, null);
            tvGoodsDetailCollection.setText("已收藏");
        } else {
            Drawable nav_up = getResources().getDrawable(R.mipmap.no_collection);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvGoodsDetailCollection.setCompoundDrawables(null, nav_up, null, null);
            tvGoodsDetailCollection.setText("收藏");
        }
        //设置商品Banner图片
        if (productInfoBean.getImages() != null && productInfoBean.getImages().size() > 0) {
            ArrayList<com.commsdk.common.widget.banner.BannerBean> bannerBeanList = new ArrayList<>();
            for (String pic : productInfoBean.getImages()) {
                com.commsdk.common.widget.banner.BannerBean bannerBean = new com.commsdk.common.widget.banner.BannerBean();
                bannerBean.setAdPic(pic);
                bannerBeanList.add(bannerBean);
            }
            bannerView.setImageResources(bannerBeanList, new BanerView.BannerOnclickListner() {
                @Override
                public void onImageClick(int position, BannerBean bannerBean, View imageView) {

                }
            });
            bannerView.startImageCycle();
        }
        //设置商品详情
        String Description = productInfoBean.getDescription();
        if (!StringUtils.isEmpty(Description)) {
            Description = Description.replace("ueditor/net/upload", BuildConfig.IMAGE_SERVER_URL + "/upload/Editor");
            webView.loadData(Description, "text/html; charset=UTF-8", null);
        }
        //获取购物车商品总数量
        GetProductCount();
    }

    @Override
    public void GetProductCount() {
        String Client_Id= SharePreferenceUtils2.getClient_Id(activity);
        if (!StringUtils.isEmpty(Client_Id)){
            Map<String,Object> params=new HashMap<>();
            params.put("Client_Id",Client_Id);
            params.put("virtualName",SharePreferenceUtils2.getClient_Id(activity));
            params.put("Channel",23+"");//平台(1:wx,17:M站,23:APP)
            params.put("Media",null);
            params.put("Consignor_Id",productInfoBean.getVendorId()+"");
            params.put("ShopCartType",1+"");//购物车类型（1：普通购物车，8：积分商品购物车）
            params.put("Client_Id",Client_Id);
            mvpPresenter.GetProductCount(params);
        }


    }

    @Override
    public void GetProductCountResult(boolean success, String msg, ShopCarProductCountBean shopCarProductCountBean) {
        if (success){
            showShopCartData(shopCarProductCountBean);
        }
    }


    @Override
    public void AddFavoriteProductList() {
        String Client_Id= SharePreferenceUtils2.getClient_Id(activity);
        Map<String,Object> params=new HashMap<>();
        params.put("ProductCode",ProductCode);
        params.put("Client_Id",Client_Id);
        UIHelper.showProgressDialog(activity,"关注中...");
        mvpPresenter.AddFavoriteProductList(params);

    }

    @Override
    public void AddFavoriteProductListResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            Favorite=true;
            Drawable nav_up = getResources().getDrawable(R.mipmap.collection);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvGoodsDetailCollection.setCompoundDrawables(null, nav_up, null, null);
            tvGoodsDetailCollection.setText("已收藏");
        }else{
            showToast(msg);
        }
    }

    @Override
    public void DelFavoriteProductList() {
        String Client_Id= SharePreferenceUtils2.getClient_Id(activity);
        Map<String,Object> params=new HashMap<>();
        params.put("ProductCode",ProductCode);
        params.put("Client_Id",Client_Id);
        UIHelper.showProgressDialog(activity,"取消关注中...");
        mvpPresenter.DelFavoriteProductList(params);
    }

    @Override
    public void DelFavoriteProductListResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            Favorite=false;
            Drawable nav_up = getResources().getDrawable(R.mipmap.no_collection);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvGoodsDetailCollection.setCompoundDrawables(null, nav_up, null, null);
            tvGoodsDetailCollection.setText("收藏");
        }else{
            showToast(msg);
        }
    }

    @Override
    public void AddProduct() {
        Map<String, Object> params=new HashMap<>();
        params.put("Client_Id",SharePreferenceUtils2.getClient_Id(activity));
        params.put("virtualName", PhoneUtil.getInstance(activity).getIMEI());
        params.put("Channel","23");
        params.put("Media","");
        params.put("Consignor_Id",productInfoBean.getVendorId()+"");
        params.put("ActivityId",productInfoBean.getActivityId()+"");
        params.put("ProductCode",ProductCode);
        params.put("ProductNum","1");
        params.put("ActionID",productInfoBean.getActionID()+"");
        mvpPresenter.AddProduct(params);
    }

    @Override
    public void AddProductResult(boolean success, String msg, List<ShopCarBean> list) {
        UIHelper.cancleProgressDialog();
        if (success && list!=null && list.size()>0){
            GetProductCount();
        }else{
            showToast(msg);
        }
    }


    /**
     * 显示商品详情和商品评价
     */
    public void showGoodsDetailOrGoodsEvaluate(int i) {
        switch (i) {
            case 1:
                webView.setVisibility(View.VISIBLE);
                lvEval.setVisibility(View.GONE);
                break;
            case 2:
                webView.setVisibility(View.GONE);
                lvEval.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }


    /**
     * 设置购物车栏数据
     */
    public void showShopCartData(ShopCarProductCountBean shopCarProductCountBean) {
        if (shopCarProductCountBean.getSumProductCount() > 0) {
            tvGoodsDetailGoodsnum.setVisibility(View.VISIBLE);
            tvGoodsDetailGoodsnum.setText(shopCarProductCountBean.getSumProductCount() + "");
            tvGoodsDetailTotalprice.setText("¥"+shopCarProductCountBean.getSumProductPrice());
            tvGoodsDetailShippingfee.setText(""+shopCarProductCountBean.getPeiSongFei());
        }else{
            tvGoodsDetailGoodsnum.setVisibility(View.GONE);
        }
    }


    /**
     * 适配商品信息数据
     */
    public void setGoodsAttributeAdapter(List<String> list) {
        goodsAttributeAdapter.setMlist(list);
        goodsAttributeAdapter.notifyDataSetChanged();
    }


    /**加入购物车监听*/
    private AddCarListener mAddCarListener=new AddCarListener() {
        @Override
        public void addCart(int position, ImageView imgview) {
            int parent[] = new int[2];
            layoutMain.getLocationInWindow(parent);
            LogUtil.e("tag",parent[0]+"@"+parent[1]);

            int startLoc[] = new int[2];
            imgview.getLocationInWindow(startLoc);
            int endLoc[] = new int[2];
            imgGoodsDetailGoodscart.getLocationInWindow(endLoc);


            final ImageView goods = new ImageView(getApplicationContext());
            goods.setImageDrawable(imgview.getDrawable());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);

            layoutMain.addView(goods, params);

            float startX = startLoc[0];
            float startY = startLoc[1] - parent[1];
            float toX = endLoc[0] + imgGoodsDetailGoodscart.getWidth() / 3;
            float toY = endLoc[1];


            Path path = new Path();
            path.moveTo(startX, startY);
            path.quadTo((startX + toX) / 2, startY, toX, toY);
            mPathMeasure = new PathMeasure(path, false);


            //属性动画实现
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
            valueAnimator.setDuration(1000);
            // 匀速插值器
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (Float) animation.getAnimatedValue();
                    // 获取当前点坐标封装到mCurrentPosition
                    mPathMeasure.getPosTan(value, mCurrentPosition, null);
                    goods.setTranslationX(mCurrentPosition[0]);
                    goods.setTranslationY(mCurrentPosition[1]);
                }
            });
            valueAnimator.start();


            valueAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    goodsNum++;
                    tvGoodsDetailGoodsnum.setText(String.valueOf(goodsNum));
                    layoutMain.removeView(goods);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
    }};


    /**
     * 返回上一级界面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 点击查看消息、分享、客服
     */
    @OnClick(R.id.img_title_right)
    public void rightTitle() {
        MsgSharePw pw = new MsgSharePw(activity);
        pw.showPopupWindow(imgTitleRight);
    }

    /**
     * 点击展开更多商品信息
     */
    private boolean moreTag = false;

    @OnClick(R.id.ll_goodsDetail_moreinfo)
    public void moreGoodsInfo() {
        if (moreTag) {
            moreTag = false;
            tvGoodsDetailMoreinfo.setText("展开更多");
            imgGoodsDetailMorearrow.setImageResource(R.mipmap.arrow_dowm);
        } else {
            moreTag = true;
            tvGoodsDetailMoreinfo.setText("收起");
            imgGoodsDetailMorearrow.setImageResource(R.mipmap.arrow_up);
        }
        goodsAttributeAdapter.setMoreTag(moreTag);
        goodsAttributeAdapter.notifyDataSetChanged();

    }

    /**
     * 收藏商品点击
     */
    @OnClick(R.id.tv_goodsDetail_collection)
    public void collection() {
        if (StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))){
            LoginActivity.launch(activity);
        }else{
            if (Favorite){
                //取关
                DelFavoriteProductList();
            }else{
                //关注
                AddFavoriteProductList();
            }
        }

    }

    /**
     * 查看商品详情
     */
    @OnClick(R.id.tv_goodsDetail_goodsDetail)
    public void showGoodsDetail() {
        showGoodsDetailOrGoodsEvaluate(1);
        tvGoodsDetailGoodsDetail.setTextColor(getResources().getColor(R.color.tv_blue_goodsdetail));
        tvGoodsDetailEvaluate.setTextColor(getResources().getColor(R.color.corlor_666));
    }

    /**
     * 查看商品评价
     */
    @OnClick(R.id.tv_goodsDetail_evaluate)
    public void showEvaluate() {
        showGoodsDetailOrGoodsEvaluate(2);
        tvGoodsDetailEvaluate.setTextColor(getResources().getColor(R.color.tv_blue_goodsdetail));
        tvGoodsDetailGoodsDetail.setTextColor(getResources().getColor(R.color.corlor_666));
    }

    /**
     * 加入购物车
     */
    @OnClick(R.id.ll_goodsDetail_jion_shopcart)
    public void jionShopcart() {
        if (StringUtils.isEmpty(SharePreferenceUtils2.getClient_Id(activity))){
            LoginActivity.launch(activity);
        }else{
           AddProduct();
        }
    }

    /**
     * 点击查看购物车
     */
    @OnClick(R.id.rl_goodsDetail_goodscart)
    public void showgoodsCart() {

    }

    /**
     * 去结算
     */
    @OnClick(R.id.btn_goodsDetail_settlement)
    public void settlement() {

    }


}
