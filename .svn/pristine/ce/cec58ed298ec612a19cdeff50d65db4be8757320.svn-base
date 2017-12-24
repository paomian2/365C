package com.a365vintagewine.mvp.activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.presenter.RealNamePresenter;
import com.a365vintagewine.mvp.view.RealNameView;
import com.a365vintagewine.widget.ChoosePhotoPw;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;
import com.imagepicker.ImagePicker;
import com.imagepicker.data.ImageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RealNameAuthenticationActivity extends BaseMVPActivity<RealNamePresenter> implements RealNameView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_authentication_realname)
    EditText etAuthenticationRealname;
    @Bind(R.id.et_authentication_IDnumber)
    EditText etAuthenticationIDnumber;
    @Bind(R.id.btn_realname_next)
    Button btnRealnameNext;
    @Bind(R.id.ll_authentication_one)
    LinearLayout llAuthenticationOne;
    @Bind(R.id.authentication_IDcard_positive)
    ImageView authenticationIDcardPositive;
    @Bind(R.id.authentication_IDcard_reverse)
    ImageView authenticationIDcardReverse;
    @Bind(R.id.btn_realname_complete)
    Button btnRealnameComplete;
    @Bind(R.id.tv_authentication_state)
    TextView tvAuthenticationState;
    @Bind(R.id.tv_authentication_realname)
    TextView tvAuthenticationRealname;
    @Bind(R.id.tv_authentication_IDnumber)
    TextView tvAuthenticationIDnumber;
    @Bind(R.id.ll_in_authentication)
    LinearLayout llInAuthentication;
    @Bind(R.id.tv_again_authenticaion)
    TextView tvAgainAuthenticaion;
    @Bind(R.id.ll_authentication_fail)
    LinearLayout llAuthenticationFail;
    @Bind(R.id.ll_authentication_IDcard)
    LinearLayout llAuthenticationIDcard;

    @Override
    protected RealNamePresenter createPresenter() {
        return new RealNamePresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_real_name_authentication);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("实名认证");
        etAuthenticationRealname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etAuthenticationRealname.getText().toString().trim(),etAuthenticationIDnumber.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etAuthenticationIDnumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty(etAuthenticationRealname.getText().toString().trim(),etAuthenticationIDnumber.getText().toString().trim());
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
     * 根据是否输入姓名和身份证号显示下一步按钮
     */
    public void judgeIsEmpty(String name, String IDnumber){
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(IDnumber)){
            btnRealnameNext.setEnabled(false);
            btnRealnameNext.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnRealnameNext.setBackgroundResource(R.drawable.btn_background_black);
        btnRealnameNext.setEnabled(true);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == ChoosePhotoPw.REQUEST_CODE_ALBUM || requestCode == ChoosePhotoPw.REQUEST_CODE_PHOTOGRAPH) {
                //获取选择的图片数据
                List<ImageBean> resultList = data.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA);
                switch(choosePhotoTag){
                    case 1:
                        UIHelper.imageNet(activity, resultList.get(0).getImagePath(), authenticationIDcardPositive, true);
                        break;
                    case 2:
                        UIHelper.imageNet(activity, resultList.get(0).getImagePath(), authenticationIDcardReverse, true);
                        break;
                    default :
                        break;
                }
            }
        }
    }

    /**
     * 返回上级
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        if (View.VISIBLE == llAuthenticationOne.getVisibility() || View.VISIBLE == llInAuthentication.getVisibility() || View.VISIBLE == llAuthenticationFail.getVisibility()) {
            finish();
            return;
        }
        if (View.VISIBLE == llAuthenticationIDcard.getVisibility()){
            llAuthenticationOne.setVisibility(View.VISIBLE);
            llAuthenticationIDcard.setVisibility(View.GONE);
        }
    }

    /**
     * 选择身份证正面照片
     */
    private ChoosePhotoPw choosePhotoPw;
    private int choosePhotoTag = 0;
    @OnClick(R.id.authentication_IDcard_positive)
    public void IDcardPositive(){
        choosePhotoTag = 1;
        choosePhotoPw = new ChoosePhotoPw(activity);
    }

    /**
     * 选择身份证反面照片
     */
    @OnClick(R.id.authentication_IDcard_reverse)
    public void IDcardReverse(){
        choosePhotoTag = 2;
        choosePhotoPw = new ChoosePhotoPw(activity);
    }

}
