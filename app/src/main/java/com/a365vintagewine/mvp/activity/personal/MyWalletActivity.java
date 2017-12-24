package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.setting.IntegralMallActivity;
import com.a365vintagewine.mvp.activity.setting.SettingPaymentPasswordActivity;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.presenter.MyWalletPresenter;
import com.a365vintagewine.mvp.view.MyWalletView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyWalletActivity extends BaseMVPActivity<MyWalletPresenter> implements MyWalletView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_my_wallet_payment_pwd)
    TextView tvMyWalletPaymentPwd;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    /**总余额*/
    @Bind(R.id.tv_my_wallet_summoney)
    TextView tvMyWalletSummoney;
    @Bind(R.id.btn_my_wallet_reflect)
    Button btnMyWalletReflect;
    /**积分*/
    @Bind(R.id.tv_my_wallet_sumintegral)
    TextView tvMyWalletSumintegral;
    /**优惠券*/
    @Bind(R.id.tv_my_wallet_sumCoupon)
    TextView tvMyWalletSumCoupon;
    @Bind(R.id.rl_my_wallet_myIDcrad)
    RelativeLayout rlMyWalletMyIDcrad;

    @Override
    protected MyWalletPresenter createPresenter() {
        return new MyWalletPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_my_wallet);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initData() {
        GetUserBasicInfo();
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
    public void GetUserBasicInfo() {
        mvpPresenter.GetUserBasicInfo(SharePreferenceUtils2.getClient_Id(activity));
    }

    @Override
    public void GetUserBasicInfoResult(boolean success, String msg, UserBean userBean) {
       if (success){
           tvMyWalletSummoney.setText("¥"+userBean.getAccountBalance());
           tvMyWalletSumintegral.setText(userBean.getPoint()+"");
           tvMyWalletSumCoupon.setText(userBean.getCouponNum()+"");
       }
    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 设置支付密码
     */
    @OnClick(R.id.rl_my_wallet_myIDcrad)
    public void settingPaymentPwd() {
        AppActivityManager.getInstance().goTo(activity, SettingPaymentPasswordActivity.class);
    }

    /**
     * 使用积分兑换商品
     */
    @OnClick(R.id.tv_my_wallet_exchange)
    public void changeGodos(){
        AppActivityManager.getInstance().goTo(activity, IntegralMallActivity.class);
    }

    /**
     * 我的优惠券
     */
    @OnClick(R.id.rl_my_wallet_Myvoucher)
    public void myVoucher(){
        AppActivityManager.getInstance().goTo(activity,MyVoucherActivity.class);
    }

    /**
     * 积分明细
     */
    @OnClick(R.id.rl_my_wallet_integral)
    public void integral(){
        AppActivityManager.getInstance().goTo(activity,MyIntegralActivity.class);
    }


}
