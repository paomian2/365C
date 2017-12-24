package com.a365vintagewine.mvp.activity.setting;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.conf.Contans;
import com.a365vintagewine.mvp.presenter.MerchantsSettledPresenter;
import com.a365vintagewine.mvp.view.MerchantsSettledView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.observers.AffairObserverableExcute;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MerchantsSettledActivity extends BaseMVPActivity<MerchantsSettledPresenter> implements MerchantsSettledView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    /**门店名称*/
    @Bind(R.id.et_merchants_settled_name)
    EditText etMerchantsSettledName;
    /**详细地址*/
    @Bind(R.id.et_merchants_settled_detail_address)
    EditText etMerchantsSettledDetailAddress;
    @Bind(R.id.tv_merchants_settled_tyle)
    TextView tvMerchantsSettledTyle;
    @Bind(R.id.et_merchants_settled_person_in_charge)
    EditText etMerchantsSettledPersonInCharge;
    @Bind(R.id.et_merchants_settled_person_phone)
    EditText etMerchantsSettledPersonPhone;
    @Bind(R.id.btn_apply_admission)
    Button btnApplyAdmission;

    @Override
    protected MerchantsSettledPresenter createPresenter() {
        return new MerchantsSettledPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_merchants_settled);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("入驻申请");
        etMerchantsSettledName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etMerchantsSettledDetailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etMerchantsSettledPersonInCharge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etMerchantsSettledPersonPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tvMerchantsSettledTyle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judgeIsEmpty();
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


    @Override
    public void ApplyShop() {
        Map<String,Object> params=new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("ShopName","");
        params.put("ShopTypeName","");
        params.put("Province_Id","");
        params.put("ProvinceName","");
        params.put("City_Id","");
        params.put("CityName","");
        params.put("Region_Id","");
        params.put("RegionName","");
        params.put("Address","");
        params.put("Contacts","");
        params.put("Mobile","");
        params.put("Address","");
        mvpPresenter.ApplyShop(params);
    }

    @Override
    public void ApplyShopResult(boolean success, String msg) {
        showToast(msg);
        if (success){
            AffairObserverableExcute.getInstance().notifyAffairObserver(Contans.UPDATE_USER_INFO,null);
            finish();
        }
    }

    //省市区三级列表的点击事件
    public void chooseArea(View view) {
        //判断输入法的隐藏状态
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            selectAddress();//调用CityPicker选取区域

        }
    }

    private void selectAddress() {
        CityPicker cityPicker = new CityPicker.Builder(this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
//                .titleTextColor("#696969")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("北京市")
                .city("北京市")
                .district("通州区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                tvMerchantsSettledTyle.setText(province.trim() + "  " + city.trim() + "  " + district.trim());
            }
        });
    }

    /**
     * 根据输入情况，判断申请入驻按钮是否可以点击
     */
    public void judgeIsEmpty() {
        String name = etMerchantsSettledName.getText().toString().trim();
        String city = tvMerchantsSettledTyle.getText().toString().trim();
        String detailAddress = etMerchantsSettledDetailAddress.getText().toString().trim();
        String personInCharge = etMerchantsSettledPersonInCharge.getText().toString().trim();
        String phone = etMerchantsSettledPersonPhone.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(city)|| TextUtils.isEmpty(detailAddress)|| TextUtils.isEmpty(personInCharge)|| TextUtils.isEmpty(phone)) {
            btnApplyAdmission.setEnabled(false);
            btnApplyAdmission.setBackgroundResource(R.drawable.btn_background_ddd);
            return;
        }
        btnApplyAdmission.setBackgroundResource(R.drawable.btn_background_black);
        btnApplyAdmission.setEnabled(true);
    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 选择省市区
     */
    @OnClick(R.id.tv_merchants_settled_tyle)
    public void chooseCity() {
        chooseArea(tvMerchantsSettledTyle);
    }


}
