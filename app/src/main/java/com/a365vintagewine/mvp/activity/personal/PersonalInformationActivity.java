package com.a365vintagewine.mvp.activity.personal;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.activity.LoginActivity;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.presenter.PersonalInfoPresenter;
import com.a365vintagewine.mvp.view.PersonalInfoView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.a365vintagewine.widget.ChoosePhotoPw;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.BitmapUtil;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.observers.AffairObserver;
import com.commsdk.common.observers.AffairObserverableExcute;
import com.commsdk.common.widget.CircleImageView;
import com.google.gson.Gson;
import com.imagepicker.ImagePicker;
import com.imagepicker.data.ImageBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalInformationActivity extends BaseMVPActivity<PersonalInfoPresenter> implements PersonalInfoView,AffairObserver {

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
    @Bind(R.id.rl_person_info_head)
    LinearLayout rlPersonInfoHead;
    @Bind(R.id.tv_personal_info_nikename)
    TextView tvPersonalInfoNikename;
    @Bind(R.id.rl_person_info_nickname)
    LinearLayout rlPersonInfoNickname;
    @Bind(R.id.tv_personal_info_phone)
    TextView tvPersonalInfoPhone;
    @Bind(R.id.rl_person_info_phone)
    LinearLayout rlPersonInfoPhone;
    @Bind(R.id.tv_personal_info_weixin)
    TextView tvPersonalInfoWeixin;
    @Bind(R.id.rl_person_info_weixin)
    LinearLayout rlPersonInfoWeixin;
    @Bind(R.id.rl_person_info_blankcard)
    LinearLayout rlPersonInfoBlankcard;
    @Bind(R.id.rl_person_info_realname)
    LinearLayout rlPersonInfoRealname;
    @Bind(R.id.tv_personal_info_Invitationcode)
    TextView tvPersonalInfoInvitationcode;
    @Bind(R.id.rl_person_info_Invitationcode)
    LinearLayout rlPersonInfoInvitationcode;
    @Bind(R.id.img_person_user_head)
    CircleImageView imgPersonUserHead;

    @Override
    protected PersonalInfoPresenter createPresenter() {
        return new PersonalInfoPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_personal_information);
        AffairObserverableExcute.getInstance().attach(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        AffairObserverableExcute.getInstance().detach(this);
        super.onDestroy();
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("个人信息");
    }

    @Override
    protected void initData() {
         String userInfo= SharedPreferenceUtil.getInstance(activity).getString(SharedPreferenceUtil.USERINFO);
        if(!StringUtils.isEmpty(userInfo)){
            UserBean user=new Gson().fromJson(userInfo, UserBean.class);
            UIHelper.imageNet(activity,user.getUserHeadImgUrl(),imgPersonUserHead,false,R.mipmap.myself_head_portrait);
            tvPersonalInfoNikename.setText(user.getNickName());
            tvPersonalInfoPhone.setText(user.getMobile());
            tvPersonalInfoWeixin.setText("微信号");
        }
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
    public void getBaseUserInfo(String Client_Id) {
        mvpPresenter.getBaseUserInfo(Client_Id);
    }

    @Override
    public void getBaseUserInfoResult(boolean success, UserBean user, String msg) {
        if (success){
            initData();
        }
    }

    /**
     *
     * 用户基本数据改变通知更新数据  {@link com.a365vintagewine.mvp.activity.personal.UpdateNickNameActivity#updateNickName(String, String)}
     * */
    @Override
    public void updateAffair(String tag, Object object) {
        //重新加载用户基本信息
        String userInfo = SharedPreferenceUtil.getInstance(activity).getString(SharedPreferenceUtil.USERINFO);
        //已登录
        if (!StringUtils.isEmpty(userInfo)) {
            UserBean user = new Gson().fromJson(userInfo, UserBean.class);
            getBaseUserInfo(user.getClient_Id()+"");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == ChoosePhotoPw.REQUEST_CODE_ALBUM || requestCode == ChoosePhotoPw.REQUEST_CODE_PHOTOGRAPH) {
                //获取选择的图片数据
                List<ImageBean> resultList = data.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA);
                if(resultList==null || resultList.get(0)==null || StringUtils.isEmpty(resultList.get(0).getImagePath())){
                      showToast("获取图片失败！");
                }else{
                    String imagePath=resultList.get(0).getImagePath();
                    UIHelper.imageNet(activity, imagePath, imgPersonUserHead, true);
                    String base64Image= BitmapUtil.bitmap2StrByBase64(imagePath);
                    UserBean user=SharePreferenceUtils2.getBaseUser(activity);
                    if (user==null){
                        LoginActivity.launch(activity);
                    }else{
                        updateUserHeadImage(user.getClient_Id()+"",base64Image,user.getUserHeadImgUrl());
                        UIHelper.showProgressDialog(activity,"正在上传图片...");
                    }
                }
            }
        }
    }

    /**
     * 返回上级
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
    *修改头像
   */
    @OnClick(R.id.rl_person_info_head)
    public void personHead() {
        ChoosePhotoPw choosePhotoPw = new ChoosePhotoPw(activity);
        choosePhotoPw.showPopupWindow(rlPersonInfoHead);
    }

    /**
     * 修改昵称
     */
    @OnClick(R.id.rl_person_info_nickname)
    public void nickName(){
        AppActivityManager.getInstance().goTo(activity,UpdateNickNameActivity.class);
    }

    /**
     * 绑定微信号
     */
    @OnClick(R.id.rl_person_info_weixin)
    public void personWeixin() {

    }

    /**
     * 绑定银行卡
     */
    @OnClick(R.id.rl_person_info_blankcard)
    public void personBlankCard() {

    }

    /**
     * 实名认证
     */
    @OnClick(R.id.rl_person_info_realname)
    public void personRealname() {
        AppActivityManager.getInstance().goTo(activity,RealNameAuthenticationActivity.class);
    }

    /**
     * 补填邀请码
     */
    @OnClick(R.id.rl_person_info_Invitationcode)
    public void personInvitationCode() {
        AppActivityManager.getInstance().goTo(activity,FillInInvitationCodeActivity.class);
    }



    @Override
    public void updateUserHeadImage(String Client_Id, String Base64UserHeadImgUrl, String UpLoadFileStr) {
        mvpPresenter.updateUserHeadImage(Client_Id,Base64UserHeadImgUrl,UpLoadFileStr);
    }

    @Override
    public void updateUserHeadImageResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
         if(success){
             AffairObserverableExcute.getInstance().notifyAffairObserver(Contans.UPDATE_USER_INFO,null);
         }
    }


}
