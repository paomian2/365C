package com.a365vintagewine.mvp.activity.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.response.GetHotSearchKeyResponse;
import com.a365vintagewine.mvp.presenter.search.SearchPresenter;
import com.a365vintagewine.mvp.view.search.SearchView;
import com.a365vintagewine.widget.HotSearchLayout;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.UIHelper;

import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseMVPActivity<SearchPresenter> implements SearchView {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.et_title_search)
    EditText etTitleSearch;
    @Bind(R.id.tv_title_search)
    RelativeLayout tvTitleSearch;
    @Bind(R.id.hot_search_layout)
    HotSearchLayout hotSearchLayout;
    @Bind(R.id.rl_delete_history)
    RelativeLayout rlDeleteHistory;
    @Bind(R.id.ll_history)
    LinearLayout llHistory;
    @Bind(R.id.lv_search_history)
    ListView lvSearchHistory;
    private LayoutInflater mInflater;
    /************
     * 以上为流式标签相关
     ************/
    private List<String> mHistoryKeywords = new ArrayList<>();
    private ArrayAdapter<String> mArrAdapter;//搜索历史适配器

    @Override
    protected SearchPresenter createPresenter() {
        return new SearchPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_search);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        mInflater = LayoutInflater.from(this);
        //输入完后按键盘上的搜索键【回车键改为了搜索键】
        etTitleSearch.setOnKeyListener(mOnKeyListener);
        //搜索框内容监听
        etTitleSearch.addTextChangedListener(mTextWatcher);
        //搜索历史记录
        mArrAdapter = new ArrayAdapter<>(this, R.layout.item_search_history, mHistoryKeywords);
        lvSearchHistory.setAdapter(mArrAdapter);
        lvSearchHistory.setOnItemClickListener(mOnItemClickListener);
    }

    /**
     * 将数据放入流式布局
     */
    @Override
    protected void initData() {
        getHistorySearchData();
        getHotsearchData();
    }

    @Override
    public void getHistorySearchData() {
        mvpPresenter.getHistorySearch();
    }

    @Override
    public void getHotsearchData(){
        mvpPresenter.getHotSearch();
    }

    @Override
    public void getHistorySearchDataResult(List<String> historyList) {
        mHistoryKeywords.clear();
        mHistoryKeywords.addAll(historyList);
        mArrAdapter.notifyDataSetChanged();
    }

    @Override
    public void saveHistorySearchData(String historySearch) {
        mvpPresenter.saveHistorySearch(historySearch);
    }

    /**
     * 清除历史纪录
     */
    @Override
    public void cleanHistory() {
        SharedPreferenceUtil.getInstance(activity).remove(SharedPreferenceUtil.SEARCH_HISTORY);
        mHistoryKeywords.clear();
        mArrAdapter.notifyDataSetChanged();
        llHistory.setVisibility(View.GONE);
        showToast("清除搜索历史成功");
    }

    @Override
    public void getHotsearchDataResult(boolean success, String msg, List<GetHotSearchKeyResponse.DataBean> dataBeanList) {
        if (success) {
            for (GetHotSearchKeyResponse.DataBean databean : dataBeanList) {
                final TextView tv = (TextView) mInflater.inflate(
                        R.layout.search_label_tv, hotSearchLayout, false);
                tv.setText(databean.getTitle());
                final String str = tv.getText().toString().trim();
                //点击事件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //加入搜索历史纪录记录
                        saveHistorySearchData(str);
                        SearchShopGoodsActivity.launch(activity,"",str,"","");
                    }
                });
                hotSearchLayout.addView(tv);
            }
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

    /**搜索框回车键点击监听*/
    private View.OnKeyListener mOnKeyListener=new View.OnKeyListener(){
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {//修改回车键功能
                String keywords = etTitleSearch.getText().toString();
                if (!TextUtils.isEmpty(keywords)) {
                    saveHistorySearchData(keywords);
                    SearchShopGoodsActivity.launch(activity,"",keywords,"","");
                } else {
                    showToast("请输入搜索内容");
                }
            }
            return false;
        }
    };

    /**
     * 搜索框内容监听
     * */
    private TextWatcher mTextWatcher=new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str = etTitleSearch.getText().toString().trim();
            if (str.length() > 0) {
                if (mHistoryKeywords.size() > 0) {
                    llHistory.setVisibility(View.VISIBLE);
                } else {
                    llHistory.setVisibility(View.GONE);
                }
            } else {
                llHistory.setVisibility(View.GONE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**搜索历史列表点击事件监听*/
    private AdapterView.OnItemClickListener mOnItemClickListener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            SearchShopGoodsActivity.launch(activity,"",mHistoryKeywords.get(position),"","");
        }
    };

    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.rl_delete_history)
    public void setRlDeleteHistory() {
        UIHelper.showTowButtonDialog(activity, "温馨提示", "是否要清除搜索历史记录", "确定", "取消", new UIHelper.OnDialogClickListener() {
            @Override
            public void onClick() {
                cleanHistory();
            }
        }, null);
    }

    @OnClick(R.id.tv_title_search)
    public void search() {
        String keywords = etTitleSearch.getText().toString();
        if (!TextUtils.isEmpty(keywords)) {
            saveHistorySearchData(keywords);
            SearchShopGoodsActivity.launch(activity,"",keywords,"","");
        } else {
           showToast("请输入搜索内容");
        }
    }


}
