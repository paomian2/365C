package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.SettingPaymentPwdPresenter;
import com.a365vintagewine.mvp.view.SettingPaymentPwdView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.utils.VerificationCodeTimerUtils;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.ToastUtils;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingPaymentPasswordActivity extends BaseMVPActivity<SettingPaymentPwdPresenter> implements SettingPaymentPwdView {


    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_settingpayment_phone)
    EditText etSettingpaymentPhone;
    @Bind(R.id.tv_settingpayment_getVerificationCode)
    TextView tvGetVerificationCode;
    @Bind(R.id.et_settingpayment_verificationcode)
    EditText etSettingpaymentVerificationcode;
    @Bind(R.id.btn_setting_payment_next)
    Button btnSettingPaymentNext;
    @Bind(R.id.ll_setting_payment_pwd_onepage)
    LinearLayout llSettingPaymentPwdOnepage;
    @Bind(R.id.et_settingpayment_newpwd1)
    EditText etSettingpaymentNewpwd1;
    @Bind(R.id.et_settingpayment_newpwd2)
    EditText etSettingpaymentNewpwd2;
    @Bind(R.id.btn_setting_payment_complete)
    Button btnSettingPaymentComplete;
    @Bind(R.id.ll_setting_payment_pwd_twopage)
    LinearLayout llSettingPaymentPwdTwopage;

    /**
     * 发送验证码是否成功
     */
    private boolean isSendVeriCode;


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
    protected SettingPaymentPwdPresenter createPresenter() {
        return new SettingPaymentPwdPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_setting_payment_password);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("设置支付密码");
        //手机号取当前用户，不可编辑
        etSettingpaymentPhone.setText(SharePreferenceUtils2.getBaseUser(activity).getMobile());
        etSettingpaymentPhone.setEnabled(false);
        //当前页面是否是发送验证码页面
        etSettingpaymentPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmptyNextBtn(etSettingpaymentPhone.getText().toString().trim(), etSettingpaymentVerificationcode.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etSettingpaymentVerificationcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmptyNextBtn(etSettingpaymentPhone.getText().toString().trim(), etSettingpaymentVerificationcode.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etSettingpaymentNewpwd1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmptyCompleteBtn(etSettingpaymentNewpwd1.getText().toString().trim(), etSettingpaymentNewpwd2.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etSettingpaymentNewpwd2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmptyCompleteBtn(etSettingpaymentNewpwd1.getText().toString().trim(), etSettingpaymentNewpwd2.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }


    /**
     * 判断下一步按钮是否点击
     */
    private void judgeIsEmptyNextBtn(String phone, String verificationCode) {
        if (!isSendVeriCode || StringUtils.isEmpty(phone) || StringUtils.isEmpty(verificationCode)) {
            btnSettingPaymentNext.setBackgroundResource(R.drawable.btn_background_ddd);
            btnSettingPaymentNext.setEnabled(false);
            return;
        }
        btnSettingPaymentNext.setBackgroundResource(R.drawable.btn_background_black);
        btnSettingPaymentNext.setEnabled(true);
    }

    /**
     * 判断完成按钮是否点击
     */
    private void judgeIsEmptyCompleteBtn(String pwd1, String pwd2) {
        if (StringUtils.isEmpty(pwd1) || StringUtils.isEmpty(pwd2)) {
            btnSettingPaymentComplete.setBackgroundResource(R.drawable.btn_background_ddd);
            btnSettingPaymentComplete.setEnabled(false);
            return;
        }
        btnSettingPaymentComplete.setBackgroundResource(R.drawable.btn_background_black);
        btnSettingPaymentComplete.setEnabled(true);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (llSettingPaymentPwdOnepage.getVisibility() == View.VISIBLE) {
                finish();
                return false;
            }
            llSettingPaymentPwdOnepage.setVisibility(View.VISIBLE);
            llSettingPaymentPwdTwopage.setVisibility(View.GONE);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    @Override
    public void verifyOldPayPwd(String Client_Id, String PayPwd) {

    }

    @Override
    public void verifyOldPayPwdResult(boolean success, String msg) {


    }

    @Override
    public void verifyCodeAndMoblie(String Client_Id, String Mobile, String VerificationCode) {
        mvpPresenter.verifyCodeAndMoblie(Client_Id, Mobile, VerificationCode);
        UIHelper.showProgressDialog(activity, "正在校验验证码...");
    }

    @Override
    public void verifyCodeAndMoblieResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success) {
            llSettingPaymentPwdOnepage.setVisibility(View.GONE);
            llSettingPaymentPwdTwopage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setPayPwd(String Client_Id, String Mobile, String VerificationCode, String PayPwd, String ConfirmPayPwd) {
        mvpPresenter.setPayPwd(Client_Id, Mobile, VerificationCode, PayPwd, ConfirmPayPwd);
        UIHelper.showProgressDialog(activity, "正在提交数据...");
    }

    @Override
    public void setPayPwdResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success) {
            finish();
        }
    }

    @Override
    public void sendPayPwdVerificationCode(String Client_Id, String Mobile) {
        UIHelper.showProgressDialog(activity, "正在请求发送验证码...");
        mvpPresenter.sendPayPwdVerificationCode(Client_Id, Mobile);
    }

    @Override
    public void sendPayPwdVerificationCodeResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
            isSendVeriCode = true;
        }
    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        if (llSettingPaymentPwdOnepage.getVisibility() == View.VISIBLE) {
            finish();
            return;
        }
        llSettingPaymentPwdOnepage.setVisibility(View.VISIBLE);
        llSettingPaymentPwdTwopage.setVisibility(View.GONE);
    }

    /**
     * 获取验证码
     */
    @OnClick(value = R.id.tv_settingpayment_getVerificationCode)
    public void getVerificationCode() {
        if (!TextUtils.isEmpty(etSettingpaymentPhone.getText().toString().trim())) {
            if (StringUtils.phoneNumberValid(etSettingpaymentPhone.getText().toString().trim())) {
                VerificationCodeTimerUtils timer = new VerificationCodeTimerUtils(tvGetVerificationCode, 120000, 1000);
                timer.start();
                //发送验证码
                sendPayPwdVerificationCode(SharePreferenceUtils2.getClient_Id(activity), etSettingpaymentPhone.getText().toString().trim());
                return;
            }
            ToastUtils.showToast(activity, "请输入正确手机号");
        }
    }

    /**
     * 下一步按钮
     */
    @OnClick(R.id.btn_setting_payment_next)
    public void nextPage() {
        verifyCodeAndMoblie(SharePreferenceUtils2.getClient_Id(activity),
                etSettingpaymentPhone.getText().toString().trim(),
                etSettingpaymentVerificationcode.getText().toString().trim());
    }

    /**
     * 完成按钮
     */
    @OnClick(R.id.btn_setting_payment_complete)
    public void complete() {
        setPayPwd(SharePreferenceUtils2.getClient_Id(activity),
                etSettingpaymentPhone.getText().toString().trim(),
                etSettingpaymentVerificationcode.getText().toString().trim(),
                etSettingpaymentNewpwd1.getText().toString().trim(),
                etSettingpaymentNewpwd2.getText().toString().trim());
    }
}
