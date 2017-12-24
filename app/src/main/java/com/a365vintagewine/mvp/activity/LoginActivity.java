package com.a365vintagewine.mvp.activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.LoginPresenter;
import com.a365vintagewine.mvp.view.LoginView;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.ToastUtils;
import com.commsdk.common.UIHelper;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月24日  15:22
 * 版本：3.0
 */

public class LoginActivity extends BaseMVPActivity<LoginPresenter> implements LoginView {

    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.img_loginback)
    RelativeLayout imgLoginback;
    @Bind(R.id.et_login_username)
    EditText etLoginUsername;
    @Bind(R.id.et_login_password)
    EditText etLoginPassword;
    @Bind(R.id.tv_login_forget_password)
    TextView tvLoginForgetPassword;
    @Bind(R.id.tv_login_register)
    TextView tvLoginRegister;
    @Bind(R.id.img_login_qq)
    ImageView imgLoginQq;
    @Bind(R.id.img_login_weibo)
    ImageView imgLoginWeibo;
    @Bind(R.id.img_login_weixin)
    ImageView imgLoginWeixin;

    public static void launch(BaseActivity activity){
        AppActivityManager.getInstance().goTo(activity,LoginActivity.class);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        etLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etLoginUsername.getText().toString().trim(),etLoginPassword.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etLoginUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etLoginUsername.getText().toString().trim(),etLoginPassword.getText().toString().trim());
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
    public String setTag() {
        return null;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    /**登录按钮*/
    @OnClick(R.id.btnLogin)
    public void login() {
        if (!StringUtils.phoneNumberValid(etLoginUsername.getText().toString().trim())){
            ToastUtils.showToast(activity,"请输入正确手机号");
        }else if (UIHelper.checkTvLimit(activity,etLoginPassword,6,"您输入的密码有误！")){
            mvpPresenter.login();
        }
    }

    /**新用户注册*/
    @OnClick(R.id.tv_login_register)
    public void register() {
        AppActivityManager.getInstance().goTo(activity,RegisterActivity.class);
    }

    /**忘记密码*/
    @OnClick(R.id.tv_login_forget_password)
    public void forgetPassword() {
        AppActivityManager.getInstance().goTo(activity,ForgetPasswordActivity.class);
    }


    /**
     * 根据是否输入用户名和密码判断登录按钮是否能够点击
     */
    private void judgeIsEmpty(String phone, String password){
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)){
            btnLogin.setEnabled(false);
            btnLogin.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnLogin.setBackgroundResource(R.drawable.btn_background_black);
        btnLogin.setEnabled(true);
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
    public String getUserName() {
        return etLoginUsername.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return etLoginPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        showToast("登录成功");
        finish();
    }

    @Override
    public void loginFailuer(String msg) {
        showToast(msg);
    }


}
