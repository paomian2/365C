package com.a365vintagewine.mvp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.ClassificationTwoLevelAdapter;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.a365vintagewine.mvp.presenter.ClassificationPresenter;
import com.a365vintagewine.mvp.view.ClassificationView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;
import com.commsdk.common.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * 二级分类列表
 * */

public class ProTypeFragment extends BaseMVPFragment<ClassificationPresenter> implements ClassificationView {

    @Bind(R.id.lv_classitication_right)
    ListView lvClassiticationRight;

    private ClassificationTwoLevelAdapter adapter;

    /**二级分类列表数据*/
    private List<CategoryBean> categoryBeanList=new ArrayList<>();
    /**当前分类*/
    private int index=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pro_type, null);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void onGetBundle(Bundle bundle) {
        super.onGetBundle(bundle);
        if (bundle!=null){
            String categoryJson=bundle.getString("categoryBeanList");
            if (!StringUtils.isEmpty(categoryJson)){
                List<CategoryBean> tempList=new Gson().fromJson(categoryJson,new TypeToken<List<CategoryBean>>(){}.getType());
                if (tempList!=null && tempList.size()>0){
                    categoryBeanList.clear();
                    categoryBeanList.addAll(tempList);
                }
            }
            index=bundle.getInt("index");
        }

    }

    @Override
    protected ClassificationPresenter createPresenter() {
        return new ClassificationPresenter(this);
    }

    @Override
    public void initUI() {
        adapter = new ClassificationTwoLevelAdapter(activity);
        lvClassiticationRight.setAdapter(adapter);
        //二级分类
        adapter.setMlist(categoryBeanList.get(index).getChildren());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {

    }

    @Override
    public String setTag() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
    public void Category() {

    }

    @Override
    public void CategoryResult(boolean success, String msg, List<CategoryBean> list) {

    }
}
