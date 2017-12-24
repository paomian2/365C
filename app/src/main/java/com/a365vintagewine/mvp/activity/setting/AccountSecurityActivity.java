package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountSecurityActivity extends BaseActivity {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.rl_accountsencurity_login)
    RelativeLayout rlAccountsencurityLogin;
    @Bind(R.id.tv_accountsencurity_payment)
    TextView tvAccountsencurityPayment;
    @Bind(R.id.rl_accountsencurity_payment)
    RelativeLayout rlAccountsencurityPayment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_account_security);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("账户安全设置");
    }

    @Override
    protected void initData() {

    }

    /**
     * 返回
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 修改登录密码
     */
    @OnClick(R.id.rl_accountsencurity_login)
    public void settingLogin() {
        AppActivityManager.getInstance().goTo(activity, SettingLoginPasswordActivity.class);
    }

    /**
     * 修改支付密码
     */
    @OnClick(R.id.rl_accountsencurity_payment)
    public void settingpayment() {
        UserBean user = SharePreferenceUtils2.getBaseUser(activity);
        if ("1".equals(user.getPayPwdState())) {
            //已开通支付密码
            AppActivityManager.getInstance().goTo(activity, ModifyPaymentPwdActivity.class);
        }else{
            AppActivityManager.getInstance().goTo(activity, SettingPaymentPasswordActivity.class);
        }

    }

}
