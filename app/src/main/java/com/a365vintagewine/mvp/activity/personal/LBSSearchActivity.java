package com.a365vintagewine.mvp.activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.LBSSearchAdapter;
import com.a365vintagewine.mvp.model.bean.AddressSearchTextEntity;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.common.UIHelper;
import com.google.gson.Gson;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.a365vintagewine.mvp.activity.personal.LBSLatLngLocationActivity.RESULT_PAY_SUCCESS;

/**
 * @Destription:地图地理位置搜索
 * @auther:lstreamlet
 * @date:2017/3/10
 */
public class LBSSearchActivity extends BaseActivity {

    @Bind(R.id.ivBack)
    ImageView ivBack;
    @Bind(R.id.edtContent)
    EditText edtContent;
    @Bind(R.id.lvAdress)
    ListView lvAdress;
    private LBSSearchAdapter lbsSearchAdapter;
    //地理位置周边搜索（定位成功后根据当前经纬度获取周边地理信息）
    private PoiSearch.Query query;
    /**当前位置*/
    private LatLng latLng;

    public static void lunch(BaseActivity activity, LatLng latLng){
        Intent intent=new Intent();
        intent.putExtra("latLng",latLng);
        intent.setClass(activity,LBSSearchActivity.class);
        AppActivityManager.getInstance().goFoResult(activity,intent,RESULT_PAY_SUCCESS);
    }

    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        latLng=getIntent().getParcelableExtra("latLng");
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_lbs_search);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        lbsSearchAdapter = new LBSSearchAdapter(activity,latLng);
        lvAdress.setAdapter(lbsSearchAdapter);
        lvAdress.setOnItemClickListener(mOnItemClickListener);
        edtContent.addTextChangedListener(mTextWatcher);
        edtContent.setOnEditorActionListener(mOnEditorActionListener);
    }

    @Override
    protected void initData() {

    }

    @Override
    public String setTag() {
        return null;
    }


    private PoiSearch poiSearch;
    private int currentPage = 0;
    private String city = "";

    private TextWatcher mTextWatcher=new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (UIHelper.checkTv(activity,edtContent))
               doSearchQueryWithKeyWord(edtContent.getText().toString().trim());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**软键盘搜索*/
    private TextView.OnEditorActionListener mOnEditorActionListener=new TextView.OnEditorActionListener(){
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (UIHelper.checkTv(activity,edtContent))
                doSearchQueryWithKeyWord(edtContent.getText().toString().trim());
            return true;
        }
    };

    /**
     * 按照关键字搜索附近的poi信息
     *
     * @param key
     */
    protected void doSearchQueryWithKeyWord(String key) {
        currentPage = 0;
        query = new PoiSearch.Query(key, "", city);// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(50);// 设置每页最多返回多少条poiitem
        query.setPageNum(currentPage);// 设置查第一页

        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(mOnPoiSearchListener);   // 实现  onPoiSearched  和  onPoiItemSearched
        //  poiSearch.setBound(new PoiSearch.SearchBound(lp, 5000, true));//
        // 设置搜索区域为以lp点为圆心，其周围5000米范围
        poiSearch.searchPOIAsyn();// 异步搜索
    }

    private PoiSearch.OnPoiSearchListener mOnPoiSearchListener = new PoiSearch.OnPoiSearchListener() {
        @Override
        public void onPoiSearched(PoiResult result, int rcode) {
            if (rcode == 0 || rcode == 1000) {
                if (result != null && result.getQuery() != null) {// 搜索poi的结果
                    if (result.getQuery().equals(query)) {// 是否是同一条
                        lbsSearchAdapter.clearAdapter();
                        for (PoiItem poiItem : result.getPois()) {

                            AddressSearchTextEntity addressEntity = new AddressSearchTextEntity(poiItem.getProvinceName(),poiItem.getCityName(),poiItem.getAdName(),poiItem.getTitle(), poiItem.getSnippet(), false, poiItem.getLatLonPoint());
                            lbsSearchAdapter.addAdapterData(addressEntity);
                        }
                        lbsSearchAdapter.notifyDataSetChanged();
                    }
                } else {
                    showToast("对不起，没有搜索到相关数据！");
                }
            }

        }

        @Override
        public void onPoiItemSearched(PoiItem poiItem, int i) {

        }
    };


    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AddressSearchTextEntity addressSearchTextEntity = (AddressSearchTextEntity) parent.getAdapter().getItem(position);
            Intent intent = new Intent();
            intent.putExtra("SerachLocation", new Gson().toJson(addressSearchTextEntity));
            activity.setResult(RESULT_OK, intent);
            finish();
        }
    };

    @OnClick(R.id.ivBack)
    public void ivBackClick() {
        finish();
    }

    @OnClick(R.id.tvConfirm)
    public void confirm(){
        if (UIHelper.checkTv(activity,edtContent))
            doSearchQueryWithKeyWord(edtContent.getText().toString().trim());
        else
            showToast("请输入搜索内容");
    }
}
