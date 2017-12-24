package com.a365vintagewine.mvp.activity.personal;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.BalanceFragAdapter;
import com.a365vintagewine.mvp.model.bean.BalanceBean;
import com.a365vintagewine.mvp.fragment.BalanceFragment;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.presenter.BalanceHomePresenter;
import com.a365vintagewine.mvp.view.BalanceHomeView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述：平台余额，充值月额
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  13:05
 * 版本：3.0
 */

public class BalanceHomeActivity extends BaseMVPActivity<BalanceHomePresenter> implements BalanceHomeView {

    /**
     * 标题
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 提现
     */
    @Bind(R.id.tvRight)
    TextView tvRight;
    /**
     * 总余额
     */
    @Bind(R.id.tvTotalBalance)
    TextView tvTotalBalance;

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    /**
     * 平台余额
     */
    @Bind(R.id.tvBalanceNo_platform)
    TextView tvBalanceNoPlatform;
    /**
     * 平台余额
     */
    @Bind(R.id.tvBalanceDesc_platform)
    TextView tvBalanceDescPlatform;
    /**
     * 充值余额
     */
    @Bind(R.id.tvBalanceNo_recharge)
    TextView tvBalanceNoRecharge;
    /**
     * 充值余额
     */
    @Bind(R.id.tvBalanceDesc_recharge)
    TextView tvBalanceDescRecharge;

    public static void lunch(BaseActivity activity){
        AppActivityManager.getInstance().goTo(activity,BalanceHomeActivity.class);
    }

    @Override
    protected BalanceHomePresenter createPresenter() {
        return new BalanceHomePresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_balance);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("余额");
        tvRight.setText("提现");
        tvRight.setTextColor(ContextCompat.getColor(activity, R.color.tv_submit));

        ArrayList<Fragment> fragmentList=new ArrayList<>();
        BalanceFragment balancePlatformFrg=new BalanceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BalanceFragment.ACTION_CODE,BalanceFragment.ACTION_CODE_PLATFORM);
        balancePlatformFrg.onGetBundle(bundle);

        BalanceFragment balanceRechargeFrg=new BalanceFragment();
        Bundle bundleRecharge = new Bundle();
        bundleRecharge.putInt(BalanceFragment.ACTION_CODE,BalanceFragment.ACTION_CODE_RECHARGE);
        balanceRechargeFrg.onGetBundle(bundleRecharge);

        fragmentList.add(balancePlatformFrg);
        fragmentList.add(balanceRechargeFrg);

        BalanceFragAdapter balanceFragAdapter=new BalanceFragAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(balanceFragAdapter);

        viewPager.addOnPageChangeListener(mOnPageChangeListener);
    }

    @Override
    protected void initData() {
        GetUserBaseBalance();
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

    /**获取整体余额信息*/
    @Override
    public void GetUserBaseBalance() {
        Map<String,Object> params=new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        mvpPresenter.GetUserBaseBalance(params);
    }

    @Override
    public void GetUserBaseBalanceResult(boolean success,String msg,BalanceBean balanceBean) {
       if (success){
           tvTotalBalance.setText(balanceBean.getTakeItBalance()+"");
           tvBalanceNoPlatform.setText(balanceBean.getPlatformBalance()+"");
           tvBalanceNoRecharge.setText(balanceBean.getTakeItBalance()+"");
       }
    }

    /**监听viewpager切换*/
    private ViewPager.OnPageChangeListener mOnPageChangeListener=new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switchBalance(position == 0);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * 平台、充值余额切换
     *
     * @param platform:是否是平台余额
     */
    private void switchBalance(boolean platform) {
        if (platform) {
            tvBalanceNoPlatform.setTextColor(ContextCompat.getColor(activity, R.color.balance_select));
            tvBalanceDescPlatform.setTextColor(ContextCompat.getColor(activity, R.color.balance_select));
            tvBalanceNoRecharge.setTextColor(ContextCompat.getColor(activity, R.color.tv_hint));
            tvBalanceDescRecharge.setTextColor(ContextCompat.getColor(activity, R.color.tv_hint));
        }else{
            tvBalanceNoPlatform.setTextColor(ContextCompat.getColor(activity, R.color.tv_hint));
            tvBalanceDescPlatform.setTextColor(ContextCompat.getColor(activity, R.color.tv_hint));
            tvBalanceNoRecharge.setTextColor(ContextCompat.getColor(activity, R.color.balance_select));
            tvBalanceDescRecharge.setTextColor(ContextCompat.getColor(activity, R.color.balance_select));
        }
    }

    /**
     * 返回
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 提现
     */
    @OnClick(R.id.tvRight)
    public void withDrawals() {
        showToast("提现");
    }

    /**
     * 切换平台余额
     */
    @OnClick(R.id.layoutBalancePlatform)
    public void showPlatformBalance() {
        switchBalance(true);
        viewPager.setCurrentItem(0);
    }

    /**
     * 切换充值余额
     */
    @OnClick(R.id.layoutBalanceRecharge)
    public void showRechargeBalance() {
        switchBalance(false);
        viewPager.setCurrentItem(1);
    }


}
