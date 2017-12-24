package com.a365vintagewine.mvp.activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.a365vintagewine.mvp.presenter.AdressEditPresenter;
import com.a365vintagewine.mvp.view.AdressEditView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.observers.AffairObserverableExcute;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述：添加地址,地址编辑
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  3:47
 * 版本：3.0
 */

public class AdressEditActivity extends BaseMVPActivity<AdressEditPresenter> implements AdressEditView {

    /**
     * 添加地址
     */
    public final static int ACTION_CODE_ADD = 1001;
    /**
     * 添加编辑
     */
    public final static int ACTION_CODE_EEIT = 1002;
    public final static String ACTION_CODE = "actionCode";
    /**
     * 当前操作标志
     */
    public int actionCode = ACTION_CODE_ADD;
    /**
     * 标题：新建地址，编辑地址
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 提交数据
     */
    @Bind(R.id.tvRight)
    TextView tvSubmit;
    /**
     * 收货人姓名
     */
    @Bind(R.id.tvName)
    EditText tvName;
    /**
     * 收货人性别
     */
    @Bind(R.id.rb_sex0)
    RadioButton rbSex0;
    /**
     * 收货人性别
     */
    @Bind(R.id.rb_sex1)
    RadioButton rbSex1;
    /**
     * 收货人电话
     */
    @Bind(R.id.tvPhone)
    EditText tvPhone;
    /**
     * 收货人地址
     */
    @Bind(R.id.tvAdressDesc)
    TextView tvAdressDesc;
    /**
     * 收货人门牌号
     */
    @Bind(R.id.tvHouseNo)
    EditText tvHouseNo;

    private AdressBean adressBean;
    private String ProvinceName;
    private String CityName;
    private String RegionName;

    private String Longitude;//经度
    private String Latitude;//纬度

    public static void lunch(BaseActivity activity, int actionCode) {
        Intent intent = new Intent();
        intent.setClass(activity, AdressEditActivity.class);
        intent.putExtra(ACTION_CODE, actionCode);
        AppActivityManager.getInstance().goTo(activity, intent);
    }

    public static void lunch(BaseActivity activity, int actionCode, AdressBean adressBean) {
        Intent intent = new Intent();
        intent.setClass(activity, AdressEditActivity.class);
        intent.putExtra(ACTION_CODE, actionCode);
        intent.putExtra("adressBean", adressBean);
        AppActivityManager.getInstance().goTo(activity, intent);
    }

    @Override
    protected AdressEditPresenter createPresenter() {
        return new AdressEditPresenter(this);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        actionCode = getIntent().getIntExtra(ACTION_CODE, ACTION_CODE_ADD);
        if (actionCode == ACTION_CODE_EEIT) {
            adressBean = (AdressBean) getIntent().getSerializableExtra("adressBean");
        }
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_adress_edit);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        if (actionCode == ACTION_CODE_ADD) {
            tvTextTitle.setText("新建地址");
        } else {
            tvTextTitle.setText("编辑地址");
            tvName.setText(adressBean.getName());
            tvPhone.setText(adressBean.getMobile());
            tvAdressDesc.setText(adressBean.getCityName() + adressBean.getStreet());
            tvHouseNo.setText(adressBean.getAddress());
        }
        tvSubmit.setText("完成");
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

    @Override
    public void addUserAddress(Map<String, Object> params) {
        UIHelper.showProgressDialog(activity, "正在提交数据...");
        mvpPresenter.AddUserAddress(params);
    }

    @Override
    public void addUserAddressResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
            AffairObserverableExcute.getInstance().notifyAffairObserver(Contans.UPDATE_ADRESS,null);
            finish();
        }
    }

    @Override
    public void editUserAddress(Map<String, Object> params) {
        UIHelper.showProgressDialog(activity,"正在提交数据...");
        mvpPresenter.editUserAddress(params);
    }

    @Override
    public void editUserAddressResult(boolean success, String msg) {
        UIHelper.cancleProgressDialog();
        showToast(msg);
        if (success){
            AffairObserverableExcute.getInstance().notifyAffairObserver(Contans.UPDATE_ADRESS,null);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LBSLatLngLocationActivity.RequestCode && resultCode == RESULT_OK) {
            if (data != null) {
                try {
                    String lbsLocation = data.getStringExtra("lbsLocation");
                    Map<String, Object> lbsMap = StringUtils.transStringToMap(lbsLocation);
                    if (lbsMap != null) {
                        tvAdressDesc.setText(lbsMap.get("addressName") + "");
                        ProvinceName = lbsMap.get("ProvinceName") + "";
                        CityName = lbsMap.get("CityName") + "";
                        RegionName = lbsMap.get("RegionName") + "";
                        Longitude = lbsMap.get("Latitude") + "";
                        Latitude = lbsMap.get("Longitude") + "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 返回
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }


    /**
     * 进入高德地图获取地址
     */
    @OnClick(R.id.tvAdressDesc)
    public void goLbsMap() {
        LBSLatLngLocationActivity.launch(activity);
    }

    /**
     * 添加地址
     */
    @OnClick(R.id.tvRight)
    public void submit() {
        if (UIHelper.checkTvWithAnim(activity, tvName, "请输入收货人姓名")
                && UIHelper.checkTvWithAnim(activity, tvPhone, "请输入收货人手机号码")
                && UIHelper.checkTvWithAnim(activity, tvAdressDesc, "请选择收货位置")
                && UIHelper.checkTvWithAnim(activity, tvHouseNo, "请输入楼号-门牌号")) {
            String sex = rbSex0.isChecked() ? "男" : "女";
            Map<String, Object> paramers = new HashMap<>();
            paramers.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
            paramers.put("Name", tvName.getText().toString().trim());
            paramers.put("Sex", sex);
            paramers.put("ProvinceName", ProvinceName);
            paramers.put("Province_Id","1");//省id
            paramers.put("City_Id","1");//市id
            paramers.put("Region_Id","3610");//区id
            paramers.put("CityName", CityName);
            paramers.put("RegionName", RegionName);
            paramers.put("Street", tvAdressDesc.getText().toString().trim());
            paramers.put("Address", tvHouseNo.getText().toString().trim());
            paramers.put("Mobile", tvPhone.getText().toString().trim());
            paramers.put("Lng", Longitude);
            paramers.put("Lat", Latitude);
            paramers.put("IsDefaultAddress","0");
            if (actionCode == ACTION_CODE_ADD) {
                addUserAddress(paramers);
            } else{
                paramers.put("Address_Id",adressBean.getAddress_Id()+"");
                editUserAddress(paramers);
            }
        }
    }

}
