package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.presenter.UpdateNikeNamePresenter;
import com.a365vintagewine.mvp.view.UpdateNikeNameView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;
import com.commsdk.common.observers.AffairObserverableExcute;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateNickNameActivity extends BaseMVPActivity<UpdateNikeNamePresenter> implements UpdateNikeNameView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_update_nikename_complete)
    TextView tvUpdateNikenameComplete;
    @Bind(R.id.et_update_nikename)
    EditText etUpdateNikename;

    @Override
    protected UpdateNikeNamePresenter createPresenter() {
        return new UpdateNikeNamePresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_update_nick_name);
        ButterKnife.bind(this);
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

    }

    @Override
    public void hideProgress() {

    }

    /**
     * 返回上级
     */
    @OnClick(R.id.img_text_title_back)
    public void back(){
        finish();
    }

    /**
     * 完成
     */
    @OnClick(R.id.tv_update_nikename_complete)
    public void updateNikenameComplete(){
        if(UIHelper.checkTvWithAnim(activity,etUpdateNikename,"请输入昵称")){
            updateNickName(SharePreferenceUtils2.getClient_Id(activity),etUpdateNikename.getText().toString().trim());
        }
    }

    @Override
    public void updateNickName(String Client_Id, String Nickname) {
        mvpPresenter.updateNickName(Client_Id,Nickname);
        UIHelper.showProgressDialog(activity,"正在提交数据...");
    }

    @Override
    public void updateNickNameResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        if (success){
            showToast("修改成功");
            AffairObserverableExcute.getInstance().notifyAffairObserver(Contans.UPDATE_USER_INFO,null);
            finish();
        }else{
            showToast(msg);
        }
    }
}
