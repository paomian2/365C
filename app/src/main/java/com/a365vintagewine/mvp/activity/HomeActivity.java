package com.a365vintagewine.mvp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.HomePagerAdapter;
import com.a365vintagewine.mvp.fragment.ClassificationFragment;
import com.a365vintagewine.mvp.fragment.HomeFragment;
import com.a365vintagewine.mvp.fragment.MyselfFragment;
import com.a365vintagewine.mvp.fragment.OrderFragment;
import com.a365vintagewine.widget.NoScrollViewPager;
import com.commsdk.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity{

    @Bind(R.id.vp_home)
    NoScrollViewPager vpHome;
    @Bind(R.id.img_home_home)
    ImageView imgHomeHome;
    @Bind(R.id.rl_home_home)
    RelativeLayout rlHomeHome;
    @Bind(R.id.img_home_classification)
    ImageView imgHomeClassification;
    @Bind(R.id.rl_home_classification)
    RelativeLayout rlHomeClassification;
    @Bind(R.id.img_home_order)
    ImageView imgHomeOrder;
    @Bind(R.id.rl_home_order)
    RelativeLayout rlHomeOrder;
    @Bind(R.id.img_home_myself)
    ImageView imgHomeMyself;
    @Bind(R.id.rl_home_myself)
    RelativeLayout rlHomeMyself;


    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initUI() {
        HomeFragment homeFragment = new HomeFragment();
        ClassificationFragment classificationFragment = new ClassificationFragment();
        OrderFragment orderFragment = new OrderFragment();
        MyselfFragment myselfFragment = new MyselfFragment();
        fragments.add(homeFragment);
        fragments.add(classificationFragment);
        fragments.add(orderFragment);
        fragments.add(myselfFragment);
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), fragments);
        vpHome.setAdapter(homePagerAdapter);
        vpHome.setCurrentItem(0);
        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onpageChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    /**
     * 根据viewpager滑动的下标显示不同的页面
     */
    public void onpageChange(int position){
        switch(position){
            case 0:
                imgHomeHome.setImageResource(R.mipmap.home_show);
                imgHomeClassification.setImageResource(R.mipmap.classification_hide);
                imgHomeMyself.setImageResource(R.mipmap.myself_hide);
                imgHomeOrder.setImageResource(R.mipmap.order_hide);
                break;
            case 1:
                imgHomeHome.setImageResource(R.mipmap.home_hide);
                imgHomeClassification.setImageResource(R.mipmap.classification_show);
                imgHomeMyself.setImageResource(R.mipmap.myself_hide);
                imgHomeOrder.setImageResource(R.mipmap.order_hide);
                break;
            case 2:
                imgHomeHome.setImageResource(R.mipmap.home_hide);
                imgHomeClassification.setImageResource(R.mipmap.classification_hide);
                imgHomeMyself.setImageResource(R.mipmap.myself_hide);
                imgHomeOrder.setImageResource(R.mipmap.order_show);
                break;
            case 3:
                imgHomeHome.setImageResource(R.mipmap.home_hide);
                imgHomeClassification.setImageResource(R.mipmap.classification_hide);
                imgHomeMyself.setImageResource(R.mipmap.myself_show);
                imgHomeOrder.setImageResource(R.mipmap.order_hide);
                break;
            default :
                break;
        }
    }

    /**
     * 首页按钮
     */
    @OnClick(R.id.rl_home_home)
    public void home(){
        onpageChange(0);
        vpHome.setCurrentItem(0);
    }

    /**
     * 分类按钮
     */
    @OnClick(R.id.rl_home_classification)
    public void classification(){
        onpageChange(1);
        vpHome.setCurrentItem(1);
    }

    /**
     * 订单按钮
     */
    @OnClick(R.id.rl_home_order)
    public void order(){
        onpageChange(2);
        vpHome.setCurrentItem(2);
    }

    /**
     * 我的按钮
     */
    @OnClick(R.id.rl_home_myself)
    public void myself(){
        onpageChange(3);
        vpHome.setCurrentItem(3);
    }


}
