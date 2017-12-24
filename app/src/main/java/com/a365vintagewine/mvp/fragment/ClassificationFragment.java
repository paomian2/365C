package com.a365vintagewine.mvp.fragment;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.ClassificationVPAdapter;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.a365vintagewine.mvp.presenter.ClassificationPresenter;
import com.a365vintagewine.mvp.activity.search.SearchActivity;
import com.a365vintagewine.mvp.view.ClassificationView;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;
import com.commsdk.common.UIHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 分类列表
 */
public class ClassificationFragment extends BaseMVPFragment<ClassificationPresenter> implements ClassificationView {

    @Bind(R.id.ll_classification)
    LinearLayout llClassification;
    @Bind(R.id.scroll_classification)
    ScrollView scrollClassification;
    @Bind(R.id.vp_classification)
    ViewPager vpClassification;
    @Bind(R.id.tv_title_search)
    TextView tvTitleSearch;

    private int currentItem = 0; //当前选中的id
    private ClassificationVPAdapter classificationVPAdapter; //左边二级分类列表适配器

    /**
     * 动态生成显示items中的textview
     */
    private TextView[] tvList; //左边二级分类名称
    private View[] views; //左边二级分类视图
    /**分类列表*/
    private List<CategoryBean> categoryBeanList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classification, null);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    protected ClassificationPresenter createPresenter() {
        return new ClassificationPresenter(this);
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        UIHelper.showProgressDialog(activity,"数据加载中...");
        Category();
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
    public void Category() {
        Map<String, Object> params = new HashMap<>();
        mvpPresenter.Category(params);
    }

    @Override
    public void CategoryResult(boolean success, String msg, List<CategoryBean> list) {
        UIHelper.cancleProgressDialog();
        if (success && list != null && list.size() > 0) {
            categoryBeanList.clear();
            categoryBeanList.addAll(list);
            showToolsView(list);
        }
    }



    private void showToolsView(List<CategoryBean> list) {
        //设置左边二级分类
        tvList = new TextView[list.size()];
        views = new View[list.size()];
        for (int i = 0; i < list.size(); i++) {
            View view = inflater.inflate(R.layout.item_classification_list, null);
            view.setTag(i);
            view.setOnClickListener(toolsItemListener);
            TextView textView = (TextView) view.findViewById(R.id.tv_classification_scrollview_item);
            textView.setText(list.get(i).getName());
            llClassification.addView(view);
            tvList[i] = textView;
            views[i] = view;
            tvList[i].setTag(i);
        }
        changeTextColor(0);
        //设置右边二级分类
        classificationVPAdapter = new ClassificationVPAdapter(getChildFragmentManager(), list);
        vpClassification.setAdapter(classificationVPAdapter);
        vpClassification.addOnPageChangeListener(onPageChangeListener);
    }

    private View.OnClickListener toolsItemListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index= (int) v.getTag();
            vpClassification.setCurrentItem(index);
        }
    };

    /**
     * OnPageChangeListener<br/>
     * 监听ViewPager选项卡变化事的事件
     */
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int arg0) {
            if (vpClassification.getCurrentItem() != arg0)
                vpClassification.setCurrentItem(arg0);
            if (currentItem != arg0) {
                changeTextColor(arg0);
                changeTextLocation(arg0);
            }
            currentItem = arg0;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    };

    /**
     * 改变textView的颜色
     *
     * @param id:类目Id
     */
    private void changeTextColor(int id) {
        for (TextView aTvList : tvList) {
            int index = (int) aTvList.getTag();
            if (index != id) {
                aTvList.setBackgroundColor(0x00000000);
                aTvList.setTextColor(0xFF000000);
            } else {
                aTvList.setBackgroundColor(0xFFFFFFFF);
                aTvList.setTextColor(0xFFFF5D5E);
            }
        }
    }

    /**
     * 改变栏目位置
     *
     * @param clickPosition:改变栏目的位置
     */
    private void changeTextLocation(int clickPosition) {
        int x = (views[clickPosition].getTop());
        scrollClassification.smoothScrollTo(0, x);
    }


    /**
     * 跳转到搜索页面
     */
    @OnClick(R.id.tv_title_search)
    public void search() {
        AppActivityManager.getInstance().goTo(activity, SearchActivity.class);
    }


}
