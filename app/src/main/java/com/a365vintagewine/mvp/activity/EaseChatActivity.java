package com.a365vintagewine.mvp.activity;
import android.content.Intent;
import android.os.Bundle;

import com.a365vintagewine.R;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.Constant;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.view.BaseMVPActivity;
/**
 * 描述：启动环信聊天页面
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月18日  14:29
 * 版本：3.0
 */

public class EaseChatActivity extends BaseMVPActivity {

    /**聊天对象的id*/
    private String userId;

    public static void lunch(BaseActivity activity, String userId){
        Intent intent=new Intent();
        intent.setClass(activity,EaseChatActivity.class);
        intent.putExtra(Constant.EXTRA_USER_ID,userId);
        AppActivityManager.getInstance().goTo(activity,intent);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        userId=getIntent().getStringExtra(Constant.EXTRA_USER_ID);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_ease_chat);
    }

    @Override
    protected void initUI() {
      /*  EaseChatFragment chatFragment = new EaseChatFragment();
        //传入参数
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_USER_ID, userId);
        chatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.container_chat, chatFragment).commit();*/
    }

    @Override
    protected void initData() {

    }
}
