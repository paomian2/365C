package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.personal.AboutUsActivity;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.common.PhoneUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeetingActivity extends BaseActivity {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.tv_setting_version)
    TextView tvSettingVersion;
    @Bind(R.id.tv_setting_cache)
    TextView tvSettingCache;
    @Bind(R.id.ll_setting_clear_cache)
    LinearLayout llSettingClearCache;
    @Bind(R.id.ll_setting_account_security)
    LinearLayout llSettingAccountSecurity;
    @Bind(R.id.ll_setting_feedback)
    LinearLayout llSettingFeedback;
    @Bind(R.id.ll_setting_about_us)
    LinearLayout llSettingAboutUs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_seeting);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("设置");
        tvSettingVersion.setText("v"+PhoneUtil.getAppVersionCode(activity));
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
     * 清除缓存
     */
    @OnClick(R.id.ll_setting_clear_cache)
    public void clearCache() {
        showToast("清除缓存成功");
        tvSettingCache.setText("0M");
    }

    /**
     * 账户安全设置
     */
    @OnClick(R.id.ll_setting_account_security)
    public void accountSecurity() {
        AppActivityManager.getInstance().goTo(activity,AccountSecurityActivity.class);
    }

    /**
     * 意见反馈
     */
    @OnClick(R.id.ll_setting_feedback)
    public void feedback() {
        AppActivityManager.getInstance().goTo(activity,FeedBackActivity.class);
    }

    /**
     * 关于我们
     */
    @OnClick(R.id.ll_setting_about_us)
    public void aboutUs(){
        AppActivityManager.getInstance().goTo(activity, AboutUsActivity.class);
    }

}
