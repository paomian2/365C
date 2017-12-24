package com.a365vintagewine.mvp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.HomePagerAdapter;
import com.commsdk.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderFragment extends BaseFragment {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.myself_msg)
    ImageView myselfMsg;
    @Bind(R.id.tv_myself_msgcount)
    TextView tvMyselfMsgcount;
    @Bind(R.id.rl_myself_msg)
    RelativeLayout rlMyselfMsg;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.tv_orderList_all)
    TextView tvOrderListAll;
    @Bind(R.id.tv_orderList_pending_payment)
    TextView tvOrderListPendingPayment;
    @Bind(R.id.tv_orderList_goodsreceipt)
    TextView tvOrderListGoodsreceipt;
    @Bind(R.id.tv_orderList_evaluate)
    TextView tvOrderListEvaluate;
    @Bind(R.id.tv_orderList_refund)
    TextView tvOrderListRefund;
    @Bind(R.id.vp_orderList)
    ViewPager vpOrderList;

    private List<Fragment> fragmentList;
    private HomePagerAdapter pagerAdapter;
    private TextPaint textPaint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        fragmentList = new ArrayList<>();
        imgTextTitleBack.setVisibility(View.GONE);
        tvTextTitle.setText("订单");
        String[] orderStatus=new String[]{"全部","待付款","待收货","待评价","退款"};
        for (int i = 0; i < 5; i++) {
            BaseFragment tempFrg=new OrderListFragment();
            Bundle bundle=new Bundle();
            bundle.putString("orderStatus",orderStatus[i]);
            tempFrg.onGetBundle(bundle);
            fragmentList.add(new OrderListFragment());
        }
        pagerAdapter = new HomePagerAdapter(getChildFragmentManager(),fragmentList);
        vpOrderList.setAdapter(pagerAdapter);
        vpOrderList.setCurrentItem(0);
        pagerChangeText(tvOrderListAll);
        vpOrderList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPagerChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 切换viewpager
     */
    private void onPagerChange(int position){
        switch(position){
            case 0:
                pagerChangeText(tvOrderListAll);
                break;
            case 1:
                pagerChangeText(tvOrderListPendingPayment);
                break;
            case 2:
                pagerChangeText(tvOrderListGoodsreceipt);
                break;
            case 3:
                pagerChangeText(tvOrderListEvaluate);
                break;
            case 4:
                pagerChangeText(tvOrderListRefund);
                break;
            default :
                break;
        }
    }

    /**
     * 切换viewpager是改变字体格式
     */
    private void pagerChangeText(TextView textView){
        textPaint = tvOrderListAll.getPaint();
        tvOrderListAll.setTextSize(30);
        textPaint.setFakeBoldText(false);
        textPaint = tvOrderListEvaluate.getPaint();
        tvOrderListEvaluate.setTextSize(30);
        textPaint.setFakeBoldText(false);
        textPaint = tvOrderListGoodsreceipt.getPaint();
        tvOrderListGoodsreceipt.setTextSize(30);
        textPaint.setFakeBoldText(false);
        textPaint = tvOrderListRefund.getPaint();
        tvOrderListRefund.setTextSize(30);
        textPaint.setFakeBoldText(false);
        textPaint = tvOrderListPendingPayment.getPaint();
        tvOrderListPendingPayment.setTextSize(30);
        textPaint.setFakeBoldText(false);
        textPaint = textView.getPaint();
        textView.setTextSize(36);
        textPaint.setFakeBoldText(true);
    }

    @Override
    public void initData() {

    }

    @Override
    public String setTag() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 全部订单
     */
    @OnClick(R.id.tv_orderList_all)
    public void orderListAll(){
        vpOrderList.setCurrentItem(0);
        pagerChangeText(tvOrderListAll);
    }

    /**
     * 待付款订单
     */
    @OnClick(R.id.tv_orderList_pending_payment)
    public void orderListPendingPayment(){
        vpOrderList.setCurrentItem(1);
        pagerChangeText(tvOrderListPendingPayment);
    }

    /**
     * 待收货订单
     */
    @OnClick(R.id.tv_orderList_goodsreceipt)
    public void orderListGoodsReceipt(){
        vpOrderList.setCurrentItem(2);
        pagerChangeText(tvOrderListGoodsreceipt);
    }

    /**
     * 待评价订单
     */
    @OnClick(R.id.tv_orderList_evaluate)
    public void orderListEvaluate(){
        vpOrderList.setCurrentItem(3);
        pagerChangeText(tvOrderListEvaluate);
    }

    /**
     * 退款订单
     */
    @OnClick(R.id.tv_orderList_refund)
    public void orderListRefund(){
        vpOrderList.setCurrentItem(4);
        pagerChangeText(tvOrderListRefund);
    }
}
