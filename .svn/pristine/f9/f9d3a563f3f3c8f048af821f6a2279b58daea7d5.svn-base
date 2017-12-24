package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.FillInInvitationCodePresenter;
import com.a365vintagewine.mvp.view.FillInInvitationCodeView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FillInInvitationCodeActivity extends BaseMVPActivity<FillInInvitationCodePresenter> implements FillInInvitationCodeView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.myself_msg)
    ImageView myselfMsg;
    @Bind(R.id.tv_myself_msgcount)
    TextView tvMyselfMsgcount;
    @Bind(R.id.rl_myself_msg)
    RelativeLayout rlMyselfMsg;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_invitation_code)
    EditText etInvitationCode;
    @Bind(R.id.btn_binding_invitation_code)
    Button btnBindingInvitationCode;

    @Override
    protected FillInInvitationCodePresenter createPresenter() {
        return new FillInInvitationCodePresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.ac_fill_in_invitation_code);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("补填邀请码");
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

    /**
     * 返回上一级
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

}
