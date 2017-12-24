package com.a365vintagewine.mvp.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.ForgetPasswordPresenter;
import com.a365vintagewine.mvp.view.ForgetPasswordView;
import com.a365vintagewine.utils.VerificationCodeTimerUtils;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.ToastUtils;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class ForgetPasswordActivity extends BaseMVPActivity<ForgetPasswordPresenter> implements ForgetPasswordView {


    @Bind(R.id.img_forgetpasswordback)
    RelativeLayout imgForgetpasswordback;
    @Bind(R.id.tv_forgetpassword_title)
    TextView tvForgetpasswordTitle;
    @Bind(R.id.et_forgetpassword_phone)
    EditText etForgetpasswordPhone;
    @Bind(R.id.tv_forgetpassword_getVerificationCode)
    TextView tvForgetpasswordGetVerificationCode;
    @Bind(R.id.et_forgetpassword_verificationCode)
    EditText etForgetpasswordVerificationCode;
    @Bind(R.id.btn_forgetpassword_next)
    Button btnForgetpasswordNext;
    @Bind(R.id.ll_forgetpassword_one)
    LinearLayout llForgetpasswordOne;
    @Bind(R.id.et_forgetpassword_password)
    EditText etForgetpasswordPassword;
    @Bind(R.id.img_forgetpassword_eye)
    ImageView imgForgetpasswordEye;
    @Bind(R.id.et_forgetpassword_confirm_password)
    EditText etForgetpasswordConfirmPassword;
    @Bind(R.id.img_forgetpassword_confirm_eye)
    ImageView imgForgetpasswordConfirmEye;
    @Bind(R.id.btn_forgetpassword_complete)
    Button btnForgetpasswordComplete;
    @Bind(R.id.ll_forgetpassword_two)
    LinearLayout llForgetpasswordTwo;

    @Override
    protected ForgetPasswordPresenter createPresenter() {
        return new ForgetPasswordPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_forget_password);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        etForgetpasswordPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etForgetpasswordPhone.getText().toString().trim(), etForgetpasswordVerificationCode.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etForgetpasswordVerificationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etForgetpasswordPhone.getText().toString().trim(), etForgetpasswordVerificationCode.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etForgetpasswordPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                judgeIsEmptyPassword(etForgetpasswordPassword.getText().toString().trim(), etForgetpasswordConfirmPassword.getText().toString().trim());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etForgetpasswordConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmptyPassword(etForgetpasswordPassword.getText().toString().trim(), etForgetpasswordConfirmPassword.getText().toString().trim());
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
        return null;
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }


    /**
     * 根据是否输入手机号和验证码判断下一步按钮是否能够点击
     */
    private void judgeIsEmpty(String phone, String verificationCode) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(verificationCode)) {
            btnForgetpasswordNext.setEnabled(false);
            btnForgetpasswordNext.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnForgetpasswordNext.setBackgroundResource(R.drawable.btn_background_black);
        btnForgetpasswordNext.setEnabled(true);
    }

    /**
     * 根据是否输入的密码判断完成按钮是否能够点击
     */
    private void judgeIsEmptyPassword(String password, String confrimPassword) {
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(confrimPassword)) {
            btnForgetpasswordComplete.setEnabled(false);
            btnForgetpasswordComplete.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnForgetpasswordComplete.setBackgroundResource(R.drawable.btn_background_black);
        btnForgetpasswordComplete.setEnabled(true);
    }

    @Override
    public void sendForgotPwdVerificationCode(String Mobile) {
        mvpPresenter.sendForgotPwdVerificationCode(Mobile);
        UIHelper.showProgressDialog(activity,"正在请求发送验证码...");
    }

    @Override
    public void sendForgotPwdVerificationCodeResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            showToast("验证码已发送");
            timer = new VerificationCodeTimerUtils(tvForgetpasswordGetVerificationCode, 120000, 1000);
            timer.start();
        }else{
            showToast(msg);
        }

    }

    @Override
    public void forgotPwdStepOne(String Mobile, String VerificationCode) {
         mvpPresenter.forgotPwdStepOne(Mobile,VerificationCode);
        UIHelper.showProgressDialog(activity,"正在校验数据...");
    }

    @Override
    public void forgotPwdStepOneResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            tvForgetpasswordTitle.setText("设置新密码");
            llForgetpasswordOne.setVisibility(View.GONE);
            llForgetpasswordTwo.setVisibility(View.VISIBLE);
            if (timer != null){
                timer.cancel();
            }
        }else{
            showToast(msg);
        }
    }

    @Override
    public void forgotPwdStepTwo(String Mobile, String NewPwd, String ConfirmPwd) {
         mvpPresenter.forgotPwdStepTwo(Mobile, NewPwd,ConfirmPwd);
        UIHelper.showProgressDialog(activity,"正在提交数据");
    }

    @Override
    public void forgotPwdStepTwoResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
            finish();
        }
    }

    /**
     * 返回按钮
     */
    @OnClick(R.id.img_forgetpasswordback)
    public void back() {
        if (View.GONE == llForgetpasswordOne.getVisibility()) {
            tvForgetpasswordTitle.setText("找回密码");
            llForgetpasswordOne.setVisibility(View.VISIBLE);
            llForgetpasswordTwo.setVisibility(View.GONE);
            return;
        }
        finish();
    }

    /**
     * 下一步按钮点击
     */
    @OnClick(R.id.btn_forgetpassword_next)
    public void next() {
        forgotPwdStepOne(etForgetpasswordPhone.getText().toString().trim(),
                etForgetpasswordVerificationCode.getText().toString().trim());
    }

    /**
     * 完成按钮点击
     */
    @OnClick(R.id.btn_forgetpassword_complete)
    public void complete() {
        forgotPwdStepTwo(etForgetpasswordPhone.getText().toString().trim(),
                etForgetpasswordPassword.getText().toString().trim(),
                etForgetpasswordConfirmPassword.getText().toString().trim());
    }

    private VerificationCodeTimerUtils timer; //获取验证码倒计时

    /**
     * 获取验证码
     */
    @OnClick(R.id.tv_forgetpassword_getVerificationCode)
    public void getVerificationCode() {
        if (!TextUtils.isEmpty(etForgetpasswordPhone.getText().toString().trim())) {
            if (StringUtils.phoneNumberValid(etForgetpasswordPhone.getText().toString().trim())) {
                sendForgotPwdVerificationCode(etForgetpasswordPhone.getText().toString().trim());
                return;
            }
            ToastUtils.showToast(activity, "请输入正确手机号");
            return;
        }
        ToastUtils.showToast(activity, "请输入手机号");
    }

    /**
     * 将设置的密码明文显示
     */
    private boolean passwordExpress = false;
    @OnClick(R.id.img_forgetpassword_eye)
    public void passwordExpress(){
        if (passwordExpress){
            passwordExpress = false;
            etForgetpasswordPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            imgForgetpasswordEye.setImageResource(R.mipmap.eye_noshow);

        }else{
            passwordExpress = true;
            etForgetpasswordPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imgForgetpasswordEye.setImageResource(R.mipmap.eye_show);
        }
    }

    /**
     * 将确认密码明文显示
     */
    private boolean confrimPasswordExpress = false;
    @OnClick(R.id.img_forgetpassword_confirm_eye)
    public void confrimPasswordExpress(){
        if (confrimPasswordExpress){
            confrimPasswordExpress = false;
            etForgetpasswordConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            imgForgetpasswordConfirmEye.setImageResource(R.mipmap.eye_noshow);

        }else{
            confrimPasswordExpress = true;
            etForgetpasswordConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imgForgetpasswordConfirmEye.setImageResource(R.mipmap.eye_show);
        }
    }


}
