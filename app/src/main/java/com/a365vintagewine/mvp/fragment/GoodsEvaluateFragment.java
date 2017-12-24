package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a365vintagewine.R;
import com.a365vintagewine.adapter.GoodsEvaluateAdapter;
import com.a365vintagewine.mvp.model.bean.GoodsEvaluate;
import com.a365vintagewine.mvp.presenter.goods.GoodsEvaluatePresenter;
import com.a365vintagewine.mvp.view.goods.GoodsEvaluateView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商品评价
 */
public class GoodsEvaluateFragment extends BaseMVPFragment<GoodsEvaluatePresenter> implements GoodsEvaluateView {

    @Bind(R.id.lv_goods_evaluate)
    ListView lvGoodsEvaluate;
//    @Bind(R.id.sf_lv_goods_evaluate)
//    SwipeRefreshLayout sfLvGoodsEvaluate;

    private GoodsEvaluateAdapter adapter;

    @Override
    protected GoodsEvaluatePresenter createPresenter() {
        return new GoodsEvaluatePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_goods_evaluate, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    public void initUI() {
        adapter = new GoodsEvaluateAdapter(activity);
        lvGoodsEvaluate.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lvGoodsEvaluate);
    }

    //解决ScrollView嵌套ListView只显示一行
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        if (adapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = adapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = adapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

        @Override
    public void initData() {
        mvpPresenter.getGoodsEvaluate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
    public void setGoodsEvaluateAdapter(List<GoodsEvaluate> list) {
        adapter.setMlist(list);
        adapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(lvGoodsEvaluate);
    }
}
