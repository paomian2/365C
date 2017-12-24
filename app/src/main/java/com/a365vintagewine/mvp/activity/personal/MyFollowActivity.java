package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.fragment.FollowGoodsFragment;
import com.a365vintagewine.mvp.fragment.FollowShopFragment;
import com.commsdk.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFollowActivity extends BaseActivity {



    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.tvRight)
    TextView tvRight;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.tv_myfollow_goods)
    TextView tvMyfollowGoods;
    @Bind(R.id.tv_myfollow_shop)
    TextView tvMyfollowShop;
    @Bind(R.id.ll_my_follow)
    LinearLayout llMyFollow;

    private FollowGoodsFragment followGoodsFragment;
    private FollowShopFragment followShopFragment;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_my_follow);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText(getResources().getString(R.string.my_follow));
        followGoodsFragment = new FollowGoodsFragment();
        followShopFragment = new FollowShopFragment();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.ll_my_follow,followGoodsFragment);
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    /**
     * 选择关注商家
     */
    @OnClick(R.id.tv_myfollow_shop)
    public void chooseShop(){
        tvMyfollowShop.setTextColor(getResources().getColor(R.color.tv_red));
        tvMyfollowGoods.setTextColor(getResources().getColor(R.color.corlor_666));
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ll_my_follow,followShopFragment);
        transaction.commit();
    }

    /**
     * 选择关注商品
     */
    @OnClick(R.id.tv_myfollow_goods)
    public void chooseGoods(){
        tvMyfollowShop.setTextColor(getResources().getColor(R.color.corlor_666));
        tvMyfollowGoods.setTextColor(getResources().getColor(R.color.red));
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ll_my_follow,followGoodsFragment);
        transaction.commit();
    }
}
