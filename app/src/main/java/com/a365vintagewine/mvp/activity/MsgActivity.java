package com.a365vintagewine.mvp.activity;
import android.os.Bundle;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.MsgPresenter;
import com.a365vintagewine.mvp.view.MsgView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月12日  3:13
 * 版本：3.0
 */

public class MsgActivity extends BaseMVPActivity<MsgPresenter> implements MsgView{



    @Override
    protected MsgPresenter createPresenter() {
        return new MsgPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
       setContentView(R.layout.act_msg);
    }

    @Override
    protected void initUI() {

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
        UIHelper.showProgressDialog(activity,"加载中...");
    }

    @Override
    public void hideProgress() {
        UIHelper.cancleProgressDialog();
    }
}
