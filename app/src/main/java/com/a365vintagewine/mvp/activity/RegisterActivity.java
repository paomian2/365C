package com.a365vintagewine.mvp.activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.RegisterPresenter;
import com.a365vintagewine.mvp.view.RegisterView;
import com.a365vintagewine.utils.VerificationCodeTimerUtils;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseMVPActivity<RegisterPresenter> implements RegisterView {

    @Bind(R.id.img_registerback)
    RelativeLayout imgRegisterback;  //返回按键
    @Bind(R.id.tv_register_title)
    TextView tvRegisterTitle; //头部字体
    @Bind(R.id.et_register_phone)
    EditText etRegisterPhone; //注册手机号
    @Bind(R.id.tv_getVerificationCode)
    TextView tvGetVerificationCode; //获取验证码
    @Bind(R.id.et_register_verificationCode)
    EditText etRegisterVerificationCode; //注册验证码
    @Bind(R.id.et_register_invitationCode)
    EditText etRegisterInvitationCode; //注册邀请码
    @Bind(R.id.checkbox_useragreement)
    CheckBox checkboxUseragreement; //选择是否同意用户协议
    @Bind(R.id.btn_register_next)
    Button btnRegisterNext; //下一步按钮
    @Bind(R.id.ll_register_one)
    LinearLayout llRegisterOne; //注册第一页整体布局
    @Bind(R.id.et_register_passwprd)
    EditText etRegisterPasswprd; //注册设置登录密码
    @Bind(R.id.img_register_eye)
    ImageView imgRegisterEye; //是否显示密码明文
    @Bind(R.id.btn_register_complete)
    Button btnRegisterComplete;  //完成注册
    @Bind(R.id.ll_register_two)
    LinearLayout llRegisterTwo; //注册第二页整体布局

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        etRegisterPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etRegisterPhone.getText().toString().trim(),etRegisterVerificationCode.getText().toString().trim(),checkboxUseragreement.isChecked());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRegisterVerificationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etRegisterPhone.getText().toString().trim(),etRegisterVerificationCode.getText().toString().trim(),checkboxUseragreement.isChecked());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etRegisterPasswprd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(etRegisterPasswprd.getText().toString().trim())){
                    btnRegisterComplete.setEnabled(false);
                    btnRegisterComplete.setBackgroundColor(ContextCompat.getColor(activity,R.color.line_back));
                    return;
                }
                if (etRegisterPasswprd.getText().toString().trim().length() <= 5){
                    btnRegisterComplete.setEnabled(false);
                    btnRegisterComplete.setBackgroundColor(ContextCompat.getColor(activity,R.color.line_back));
                    return;
                }
                btnRegisterComplete.setEnabled(true);
                btnRegisterComplete.setBackgroundColor(ContextCompat.getColor(activity,R.color.black));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        checkboxUseragreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                judgeIsEmpty(etRegisterPhone.getText().toString().trim(),etRegisterVerificationCode.getText().toString().trim(),isChecked);
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
         UIHelper.showProgressDialog(activity,msg);
    }

    @Override
    public void hideProgress() {
        UIHelper.cancleProgressDialog();
    }

    /**
     * 根据是否输入用户名和密码判断登录按钮是否能够点击
     */
    private void judgeIsEmpty(String phone, String verificationCode,boolean checked){
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(verificationCode) || !checked){
            btnRegisterNext.setEnabled(false);
            btnRegisterNext.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnRegisterNext.setBackgroundResource(R.drawable.btn_background_black);
        btnRegisterNext.setEnabled(true);
    }

    /**发送验证码*/
    @Override
    public void sendVerificationCode(String phoneNo) {
        mvpPresenter.sendVerifyCode(phoneNo);
    }

    @Override
    public void sendVerificationCodeResult(boolean success, String msg) {
        hideProgress();
        if (success){
            showToast("验证码已发送");
            timer = new VerificationCodeTimerUtils(tvGetVerificationCode,120000,1000);
            timer.start();
        } else{
            showToast(msg);
        }

    }

    @Override
    public void verifyCodeAndUserMobile(String Mobile, String VerificationCode) {
        mvpPresenter.verifyCodeAndUserMobile(Mobile,VerificationCode);
        UIHelper.showProgressDialog(activity,"正在校验验证码...");
    }

    @Override
    public void verifyCodeAndUserMobileResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            tvRegisterTitle.setText("设置登录密码");
            llRegisterOne.setVisibility(View.GONE);
            llRegisterTwo.setVisibility(View.VISIBLE);
            if (timer != null){
                timer.cancel();
            }
        }else{
            showToast(msg);
        }
    }

    @Override
    public void register(String phoneNo, String VerificationCode, String InvitationCode, String Pwd) {
        mvpPresenter.register(phoneNo,VerificationCode,InvitationCode,Pwd);
    }

    @Override
    public void registerResult(boolean success, String msg) {
        if (success){
            showToast("注册成功");
            AppActivityManager.getInstance().goTo(activity,HomeActivity.class);
            finish();
        }else{
            showToast(msg);
        }
    }

    /** 返回按钮*/
    @OnClick(R.id.img_registerback)
    public void back(){
        if (View.GONE == llRegisterOne.getVisibility()){
            tvRegisterTitle.setText("注册");
            llRegisterOne.setVisibility(View.VISIBLE);
            llRegisterTwo.setVisibility(View.GONE);
            return;
        }
        finish();
    }

    private VerificationCodeTimerUtils timer; //获取验证码倒计时
    /**获取邀请码*/
    @OnClick(R.id.tv_getVerificationCode)
    public void getVerificationCode(){
        if (!TextUtils.isEmpty(etRegisterPhone.getText().toString().trim())){
            if (StringUtils.phoneNumberValid(etRegisterPhone.getText().toString().trim())){
                showProgress("正在请求发送验证码...");
                sendVerificationCode(etRegisterPhone.getText().toString().trim());
                return;
            }
            showToast("请输入正确手机号");
            return;
        }
        showToast("请输入手机号");
    }

    /**
     * 将设置的密码明文显示
     */
    private boolean passwordExpress = false;
    @OnClick(R.id.img_register_eye)
    public void passwordExpress(){
        if (passwordExpress){
            passwordExpress = false;
            etRegisterPasswprd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            imgRegisterEye.setImageResource(R.mipmap.eye_noshow);
        }else{
            passwordExpress = true;
            etRegisterPasswprd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imgRegisterEye.setImageResource(R.mipmap.eye_show);
        }
    }

    /**注册协议*/
    @OnClick(R.id.tvAgreement)
    public void goToAgreement(){
       WebActivity.launcher(activity,"http://hao123.com");
    }

    /**下一步按钮点击*/
    @OnClick(R.id.btn_register_next)
    public void next(){
        verifyCodeAndUserMobile(etRegisterPhone.getText().toString().trim(),
                etRegisterVerificationCode.getText().toString().trim());
    }

    /**完成按钮点击*/
    @OnClick(R.id.btn_register_complete)
    public void complete(){
        String phoneNo=etRegisterPhone.getText().toString().trim();
        String verifyCode=etRegisterVerificationCode.getText().toString().trim();
        String invitationCode=etRegisterInvitationCode.getText().toString().trim();
        String pwd=etRegisterPasswprd.getText().toString().trim();
        if(UIHelper.checkTvWithAnim(activity,etRegisterPasswprd,"请输入手机号！")
                ||UIHelper.checkTvWithAnim(activity,etRegisterVerificationCode,"请输入验证码！")
                ||UIHelper.checkTvWithAnim(activity,etRegisterPasswprd,"请输入密码！")){
            if (etRegisterPasswprd.getText().toString().trim().length() <= 5){
                showToast("设置的密码不能少于6位");
            }else{
                register(phoneNo,verifyCode,invitationCode,pwd);
            }
        }
    }


}
