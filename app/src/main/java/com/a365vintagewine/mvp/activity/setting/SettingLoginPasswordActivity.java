package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.ForgetPasswordActivity;
import com.a365vintagewine.mvp.presenter.SettingLoginPasswordPresenter;
import com.a365vintagewine.mvp.view.SettingLoginPasswordView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingLoginPasswordActivity extends BaseMVPActivity<SettingLoginPasswordPresenter> implements SettingLoginPasswordView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_settinglogin_oldpassword)
    EditText etSettingloginOldpassword;
    @Bind(R.id.et_settinglogin_newdpassword1)
    EditText etSettingloginNewdpassword1;
    @Bind(R.id.et_settinglogin_newdpassword2)
    EditText etSettingloginNewdpassword2;
    @Bind(R.id.tv_settinglogin_forgetpassword)
    TextView tvSettingloginForgetpassword;
    @Bind(R.id.btn_setting_complete)
    Button btnSettingComplete;

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_seeting_login_password);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("修改登录密码");
        etSettingloginNewdpassword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String oldPwd = etSettingloginOldpassword.getText().toString().trim();
                String newPwd1 = etSettingloginNewdpassword1.getText().toString().trim();
                String newPwd2 = etSettingloginNewdpassword2.getText().toString().trim();
                judgeComplete(oldPwd,newPwd1,newPwd2);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etSettingloginNewdpassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String oldPwd = etSettingloginOldpassword.getText().toString().trim();
                String newPwd1 = etSettingloginNewdpassword1.getText().toString().trim();
                String newPwd2 = etSettingloginNewdpassword2.getText().toString().trim();
                judgeComplete(oldPwd,newPwd1,newPwd2);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etSettingloginOldpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String oldPwd = etSettingloginOldpassword.getText().toString().trim();
                String newPwd1 = etSettingloginNewdpassword1.getText().toString().trim();
                String newPwd2 = etSettingloginNewdpassword2.getText().toString().trim();
                judgeComplete(oldPwd,newPwd1,newPwd2);
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
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected SettingLoginPasswordPresenter createPresenter() {
        return new SettingLoginPasswordPresenter(this);
    }

    @Override
    public BaseActivity getMyContext() {
        return activity;
    }

    /**
     * 判断完成按钮是否可以点击
     */
    public void judgeComplete(String oldPwd, String newPwd1, String newPwd2){
        if (!StringUtils.isEmpty(oldPwd) && !StringUtils.isEmpty(newPwd1) && !StringUtils.isEmpty(newPwd2)){
            btnSettingComplete.setBackgroundResource(R.drawable.btn_background_black);
            btnSettingComplete.setEnabled(true);
            return;
        }
        btnSettingComplete.setBackgroundResource(R.drawable.btn_background_ddd);
        btnSettingComplete.setEnabled(false);
    }

    @Override
    public void updateUserPwd(String Client_Id, String OrgPwd, String NewPwd, String ConfirmPwd) {
        mvpPresenter.updateUserPwd(Client_Id,OrgPwd,NewPwd,ConfirmPwd);
    }

    @Override
    public void updateUserPwdResult(boolean success, String msg) {
        showToast(msg);
        if (success){
            finish();
        }
        UIHelper.cancleProgressDialog();
    }

    /**
     * 返回上一级
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.tv_settinglogin_forgetpassword)
    public void forgetPassword(){
        AppActivityManager.getInstance().goTo(activity,ForgetPasswordActivity.class);
    }

    @OnClick(R.id.btn_setting_complete)
    public void complete(){
        String oldPwd = etSettingloginOldpassword.getText().toString().trim();
        String newPwd1 = etSettingloginNewdpassword1.getText().toString().trim();
        String newPwd2 = etSettingloginNewdpassword2.getText().toString().trim();
        updateUserPwd(SharePreferenceUtils2.getClient_Id(activity),oldPwd,newPwd1,newPwd2);
    }


}
