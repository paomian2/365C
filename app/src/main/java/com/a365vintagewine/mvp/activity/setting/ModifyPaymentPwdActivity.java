package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.SettingPaymentPwdPresenter;
import com.a365vintagewine.mvp.view.SettingPaymentPwdView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyPaymentPwdActivity extends BaseMVPActivity<SettingPaymentPwdPresenter> implements SettingPaymentPwdView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_update_paymentpassword)
    EditText etUpdatePaymentpassword;
    @Bind(R.id.tv_update_forget_payment_pwd)
    TextView tvUpdateForgetPaymentPwd;
    @Bind(R.id.btn_update_paymentpwd_next)
    Button btnUpdatePaymentpwdNext;

    @Override
    protected SettingPaymentPwdPresenter createPresenter() {
        return new SettingPaymentPwdPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_modify_payment_pwd);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("修改支付密码");
        etUpdatePaymentpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (StringUtils.isEmpty(etUpdatePaymentpassword.getText().toString().trim())
                        || etUpdatePaymentpassword.getText().toString().toString().length()!=6){
                    btnUpdatePaymentpwdNext.setEnabled(false);
                    btnUpdatePaymentpwdNext.setBackgroundResource(R.drawable.btn_background_ddd);
                    return;
                }
                btnUpdatePaymentpwdNext.setEnabled(true);
                btnUpdatePaymentpwdNext.setBackgroundResource(R.drawable.btn_background_black);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

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
    public void verifyOldPayPwd(String Client_Id, String PayPwd) {
         mvpPresenter.verifyOldPayPwd(Client_Id,PayPwd);
        UIHelper.showProgressDialog(activity,"正在校验原始密码...");
    }

    @Override
    public void verifyOldPayPwdResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
         if (success){
             AppActivityManager.getInstance().goTo(activity,SettingPaymentPasswordActivity.class);
         }else{
             showToast(msg);
         }
    }

    @Override
    public void verifyCodeAndMoblie(String Client_Id, String Mobile, String VerificationCode) {

    }

    @Override
    public void verifyCodeAndMoblieResult(boolean success, String msg) {

    }

    @Override
    public void setPayPwd(String Client_Id, String Mobile, String VerificationCode, String PayPwd, String ConfirmPayPwd) {

    }

    @Override
    public void setPayPwdResult(boolean success, String msg) {

    }

    @Override
    public void sendPayPwdVerificationCode(String Client_Id, String Mobile) {

    }

    @Override
    public void sendPayPwdVerificationCodeResult(boolean success, String msg) {

    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    /**
     * 下一步按钮点击
     */
    @OnClick(R.id.btn_update_paymentpwd_next)
    public void nextPage(){
        //判断原始密码是否正确
        verifyOldPayPwd(SharePreferenceUtils2.getClient_Id(activity),etUpdatePaymentpassword.getText().toString().trim());
    }

    /**
     * 忘记支付密码
     */
    @OnClick(R.id.tv_update_forget_payment_pwd)
    public void forgetPaymentPwd(){
        AppActivityManager.getInstance().goTo(activity,SettingPaymentPasswordActivity.class);
    }


}
