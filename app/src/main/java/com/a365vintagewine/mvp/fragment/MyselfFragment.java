package com.a365vintagewine.mvp.fragment;
import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.activity.LoginActivity;
import com.a365vintagewine.mvp.activity.personal.BalanceHomeActivity;
import com.a365vintagewine.mvp.activity.personal.AdressHomeActivcity;
import com.a365vintagewine.mvp.activity.personal.MyFollowActivity;
import com.a365vintagewine.mvp.activity.personal.MyIntegralActivity;
import com.a365vintagewine.mvp.activity.personal.MyTeamActivity;
import com.a365vintagewine.mvp.activity.personal.MyVoucherActivity;
import com.a365vintagewine.mvp.activity.personal.MyWalletActivity;
import com.a365vintagewine.mvp.activity.personal.PersonalInformationActivity;
import com.a365vintagewine.mvp.activity.setting.MerchantsSettledActivity;
import com.a365vintagewine.mvp.activity.setting.SeetingActivity;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.presenter.MyselfPresenter;
import com.a365vintagewine.mvp.view.MyselfView;
import com.a365vintagewine.widget.MyDistributionNotQualifyPw;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.observers.AffairObserver;
import com.commsdk.common.observers.AffairObserverableExcute;
import com.commsdk.common.permission.XZPermissionUtils;
import com.commsdk.common.permission.listener.PermissionListener;
import com.commsdk.common.widget.CircleImageView;
import com.google.gson.Gson;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyselfFragment extends BaseMVPFragment<MyselfPresenter> implements MyselfView, SwipeRefreshLayout.OnRefreshListener,AffairObserver {

    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayout layoutRefresh;
    @Bind(R.id.tv_myself_msgcount)
    TextView tvMyselfMsgcount; //新消息个数
    @Bind(R.id.rl_myself_msg)
    RelativeLayout rlMyselfMsg; //消息模块
    @Bind(R.id.img_myself_setting)
    ImageView imgMyselfSetting; //设置模块
    @Bind(R.id.img_myself_headportrait)
    CircleImageView imgMyselfHeadportrait; //头像
    @Bind(R.id.tv_myself_login_or_register)
    TextView tvMyselfLoginOrRegister; //登录/注册
    @Bind(R.id.tv_myself_login_username)
    TextView tvMyselfLoginUsername; //登录状态下用户名
    @Bind(R.id.tv_myself_login_personalinformation)
    TextView tvMyselfLoginPersonalinformation; //登录状态下个人信息
    @Bind(R.id.ll_myself_login)
    LinearLayout llMyselfLogin; //登录状态下个人信息整体模块
    @Bind(R.id.img_myself_invitationCode)
    ImageView imgMyselfInvitationCode; //邀请码
    @Bind(R.id.tv_myself_integral)
    TextView tvMyselfIntegral; //积分数量
    @Bind(R.id.img_myself_new_integral)
    ImageView imgMyselfNewIntegral; //获取新积分显示圆点
    @Bind(R.id.ll_myself_integral)
    LinearLayout llMyselfIntegral; //积分模块
    @Bind(R.id.tv_myself_coupcon)
    TextView tvMyselfCoupcon; //优惠券数量
    @Bind(R.id.img_myself_new_coupcontext)
    ImageView imgMyselfNewCoupcontext; //获取新的优惠券显示圆点
    @Bind(R.id.ll_myself_coupcon)
    LinearLayout llMyselfCoupcon; //优惠券模块
    @Bind(R.id.tv_myself_balance)
    TextView tvMyselfBalance; //余额数量
    @Bind(R.id.img_myself_new_balancetext)
    ImageView imgMyselfNewBalancetext; //获取新的余额显示圆点
    @Bind(R.id.ll_myself_balance)
    LinearLayout llMyselfBalance; //余额模块
    @Bind(R.id.ll_myself_wallet)
    LinearLayout llMyselfWallet; //我的钱包模块
    @Bind(R.id.tv_myself_apply_shop)
    TextView tvMyselfApplyShop; //店铺是否开通
    @Bind(R.id.ll_myself_shop)
    LinearLayout llMyselfShop; //我的店铺模块
    @Bind(R.id.ll_myself_team)
    LinearLayout llMyselfTeam;  //我的团队
    @Bind(R.id.ll_myself_exchange_mall)
    LinearLayout llMyselfExchangeMall; //兑换商城
    @Bind(R.id.ll_myself_address_management)
    LinearLayout llMyselfAddressManagement; //地址管理
    @Bind(R.id.ll_myself_collection)
    LinearLayout llMyselfCollection; //我的收藏
    @Bind(R.id.ll_myself_customer_service_phone)
    LinearLayout llMyselfCustomerServicePhone; //客服电话

    /**
     * 跳转登录页
     */
    public boolean isLogin;

    @Override
    protected MyselfPresenter createPresenter() {
        return new MyselfPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        AffairObserverableExcute.getInstance().attach(this);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        String userInfo = SharedPreferenceUtil.getInstance(activity).getString(SharedPreferenceUtil.USERINFO);
        //已登录
        if (!StringUtils.isEmpty(userInfo)) {
            isLogin=true;
            UserBean user = new Gson().fromJson(userInfo, UserBean.class);
            UIHelper.imageNet(activity, user.getUserHeadImgUrl(), imgMyselfHeadportrait, false);
            tvMyselfLoginUsername.setText(user.getNickName());
            tvMyselfLoginOrRegister.setVisibility(View.GONE);
            llMyselfLogin.setVisibility(View.VISIBLE);
            tvMyselfIntegral.setText(user.getPoint()+"");
            tvMyselfCoupcon.setText(user.getCouponNum()+"");
            tvMyselfBalance.setText(user.getAccountBalance()+"");
        }
    }

    @Override
    public void onDestroyView() {
        AffairObserverableExcute.getInstance().detach(this);
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void initUI() {
       UIHelper.initRefreshView(layoutRefresh);
        layoutRefresh.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public String setTag() {
        return null;
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public BaseActivity getMyContext() {
        return activity;
    }


    @Override
    public void getBaseUserInfo(String Client_Id) {
        mvpPresenter.getBaseUserInfo(Client_Id);
    }

    /**
     * 设置用户基本信息
     */
    @Override
    public void getBaseUserInfoResult(boolean success, UserBean user, String msg) {
        layoutRefresh.setRefreshing(false);
        if (success) {
            UIHelper.imageNet(activity, user.getUserHeadImgUrl(), imgMyselfHeadportrait, false);
            tvMyselfLoginUsername.setText(user.getNickName());
            tvMyselfLoginOrRegister.setVisibility(View.GONE);
            llMyselfLogin.setVisibility(View.VISIBLE);
            tvMyselfIntegral.setText(user.getPoint()+"");
            tvMyselfCoupcon.setText(user.getCouponNum()+"");
            tvMyselfBalance.setText(user.getAccountBalance()+"");
        } else {
            showToast(msg);
        }

    }



    public boolean isLogin() {
        if (!isLogin) {
            AppActivityManager.getInstance().goTo(activity, LoginActivity.class);
        }
        return isLogin;
    }

    /**
     *
     * 用户基本数据改变通知更新数据  {@link com.a365vintagewine.mvp.activity.personal.UpdateNickNameActivity#updateNickName(String, String)}
     * */
    @Override
    public void updateAffair(String tag, Object object) {
        if (Contans.UPDATE_USER_INFO.equals(tag)) {
            onRefresh();
        }
    }

    @Override
    public void onRefresh() {
        //重新加载用户基本信息
        String userInfo = SharedPreferenceUtil.getInstance(activity).getString(SharedPreferenceUtil.USERINFO);
        //已登录
        if (!StringUtils.isEmpty(userInfo)) {
            UserBean user = new Gson().fromJson(userInfo, UserBean.class);
            getBaseUserInfo(user.getClient_Id()+"");
        }else{
            layoutRefresh.setRefreshing(false);
        }
    }

    /**
     * 跳转到个人中心
     */
    @OnClick(R.id.img_myself_headportrait)
    public void personal() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity, PersonalInformationActivity.class);
        }
    }

    /**跳转到个人中心*/
    @OnClick(R.id.ll_myself_login)
    public void ll_myself_login(){
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity,PersonalInformationActivity.class);
        }
    }

    /**
     * 设置
     */
    @OnClick(R.id.img_myself_setting)
    public void setting() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity,SeetingActivity.class);
        }
    }

    /**
     * 未登录情况下登录注册
     */
    @OnClick(R.id.tv_myself_login_or_register)
    public void loginOrRegister() {
        AppActivityManager.getInstance().goTo(activity,LoginActivity.class);
    }

    /**
     * 邀请码
     */
    @OnClick(R.id.img_myself_invitationCode)
    public void invitationCode() {
        String userInfo = SharedPreferenceUtil.getInstance(activity).getString(SharedPreferenceUtil.USERINFO);
        if (!StringUtils.isEmpty(userInfo)) {
            new MyDistributionNotQualifyPw(activity).showPopupWindow(imgMyselfInvitationCode);
        } else {
            LoginActivity.launch(activity);
        }
    }

    /**
     * 积分
     */
    @OnClick(R.id.ll_myself_integral)
    public void integral() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity,MyIntegralActivity.class);
        }
    }

    /**
     * 优惠券
     */
    @OnClick(R.id.ll_myself_coupcon)
    public void coupcon() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity,MyVoucherActivity.class);
        }
    }

    /**
     * 余额
     */
    @OnClick(R.id.ll_myself_balance)
    public void balance() {
        if (isLogin()) { //登录状态
            BalanceHomeActivity.lunch(activity);
        }
    }

    /**
     * 我的钱包
     */
    @OnClick(R.id.ll_myself_wallet)
    public void wallet() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity, MyWalletActivity.class);
        }
    }

    /**
     * 我的店铺
     */
    @OnClick(R.id.ll_myself_shop)
    public void shop() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity, MerchantsSettledActivity.class);
        }
    }

    /**
     * 我的团队
     */
    @OnClick(R.id.ll_myself_team)
    public void team() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity, MyTeamActivity.class);
        }
    }

    /**
     * 兑换商城
     */
    @OnClick(R.id.ll_myself_exchange_mall)
    public void exchangeMall() {
        if (isLogin()){
            AppActivityManager.getInstance().goTo(activity,MyIntegralActivity.class);
        }
    }

    /**
     * 地址管理
     */
    @OnClick(R.id.ll_myself_address_management)
    public void addressManagement() {
        if (isLogin()) { //登录状态
            AppActivityManager.getInstance().goTo(activity, AdressHomeActivcity.class);
        }
    }

    /**
     * 我的收藏
     */
    @OnClick(R.id.ll_myself_collection)
    public void collection() {
        if (isLogin()) { //登录状态
            AppActivityManager.getInstance().goTo(activity, MyFollowActivity.class);
        }
    }

    /**
     * 客服电话
     */
    @OnClick(R.id.ll_myself_customer_service_phone)
    public void customerServicePhone() {
        XZPermissionUtils.checkPermission(activity, new String[]{Manifest.permission.CALL_PHONE}, new PermissionListener() {
            @Override
            public void onSucceed(int requestCode, @NonNull String[] grantPermissions) {
                final String phoneNo = getResources().getString(R.string.custmerPhoneNo);
                String phoneNo_2 = getResources().getString(R.string.custmerPhoneNo_2);
                UIHelper.showButtonDialogInCenter(activity, "拨打客服电话" + phoneNo_2, "取消", "确定", null, new UIHelper.OnDialogClickListener() {
                    @Override
                    public void onClick() {
                        UIHelper.callPhone(activity, phoneNo);
                    }
                });
            }

            @Override
            public void onFailed(int requestCode, @NonNull String[] deniedPermissions) {
                   showToast("获取权限失败，请到设置页面开启该功能");
            }
        });
    }



}
