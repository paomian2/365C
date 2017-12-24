package com.a365vintagewine.mvp.activity.setting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellerAuditStatusActivity extends BaseActivity {

    @Bind(R.id.img_seller_audit_status)
    ImageView imgSellerAuditStatus;
    @Bind(R.id.tv_seller_audit_status)
    TextView tvSellerAuditStatus;
    @Bind(R.id.btn_download_APP)
    Button btnDownloadAPP;
    @Bind(R.id.ll_seller_audit_success)
    LinearLayout llSellerAuditSuccess;
    @Bind(R.id.tv_seller_audit_fail)
    TextView tvSellerAuditFail;
    @Bind(R.id.ll_seller_audit_fail)
    LinearLayout llSellerAuditFail;
    @Bind(R.id.ll_seller_audit_in)
    LinearLayout llSellerAuditIn;
    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_seller_audit_status);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("入驻申请");
    }

    @Override
    protected void initData() {

    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }
}
