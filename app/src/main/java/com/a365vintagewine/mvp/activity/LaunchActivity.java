package com.a365vintagewine.mvp.activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.a365vintagewine.mvp.presenter.LaunchPresenter;
import com.a365vintagewine.mvp.view.LaunchView;
import com.commsdk.R;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;

public class LaunchActivity extends BaseMVPActivity<LaunchPresenter> implements LaunchView,Animation.AnimationListener{

    ImageView ivStart;
    Animation at;
    boolean startHomeActivity;
    @Override
    protected LaunchPresenter createPresenter() {
        return new LaunchPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.act_launch);
    }

    @Override
    protected void initUI() {
        ivStart= (ImageView) findViewById(R.id.iv_start);
        at = AnimationUtils.loadAnimation(this, R.anim.launch_ad);
        at.setAnimationListener(this);
        ivStart.startAnimation(at);
    }

    @Override
    protected void initData() {
        getSignKey();
    }

    @Override
    public String setTag() {
        return null;
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
    public void activityStart(int flag) {
       switch (flag){
           case GUIDE:
               AppActivityManager.getInstance().goTo(this, GuideActivity.class);
               break;
           case LOGIN:
               AppActivityManager.getInstance().goTo(this, HomeActivity.class);
               break;
           case HOME:
               AppActivityManager.getInstance().goTo(this, HomeActivity.class);
               break;
           default:
               if (startHomeActivity){
                   AppActivityManager.getInstance().goTo(this, HomeActivity.class);
               }
               startHomeActivity=true;
               break;
       }
       finish();
    }

    @Override
    public void getSignKey() {
        mvpPresenter.getSignKey();
    }

    @Override
    public void getSignKeyResult(boolean success, String msg) {
        if (!success){
            showToast(msg);
        }else{
            if (startHomeActivity){
                AppActivityManager.getInstance().goTo(this, HomeActivity.class);
            }
            startHomeActivity=true;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
         mvpPresenter.checkUserInfo();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode != KeyEvent.KEYCODE_BACK && super.onKeyDown(keyCode, event);
    }

}
