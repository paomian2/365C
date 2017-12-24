package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.base.BaseActivity;
import com.commsdk.common.PhoneUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUsActivity extends BaseActivity {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.tv_about_us_version)
    TextView tvAboutUsVersion;

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_about_us);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("关于我们");
        tvAboutUsVersion.setText("365名酒汇    V"+ PhoneUtil.getAppVersionCode(activity));
    }

    @Override
    protected void initData() {

    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

}
