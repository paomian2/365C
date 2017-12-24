package com.a365vintagewine.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.a365vintagewine.R;
import com.commsdk.BuildConfig;
import com.commsdk.base.BaseFragment;
import com.commsdk.base.Constant;
import com.commsdk.common.StringUtils;
import com.commsdk.common.observers.AffairObserver;
import com.commsdk.common.observers.AffairObserverableExcute;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商品详情
 */
public class GoodsDetailFragment extends BaseFragment implements AffairObserver {


    /**商品详情组件*/
    @Bind(R.id.webView)
    WebView webView;
    /**无数据*/
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**商品详情*/
    private String Description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_goods_detail, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        AffairObserverableExcute.getInstance().attach(this);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        AffairObserverableExcute.getInstance().detach(this);
        super.onDestroy();
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }

    @Override
    public String setTag() {
        return null;
    }


    @Override
    public void updateAffair(String tag, Object object) {
        if (Constant.TAG_GOODS_DESC.equals(tag)) {
            if (StringUtils.isEmpty(Description)){
                Description=object+"";
            }
            if (!StringUtils.isEmpty(Description)){
                Description=Description.replace("/upload/Editor", BuildConfig.IMAGE_SERVER_URL+"/upload/Editor");
                webView.loadData(Description, "text/html; charset=UTF-8", null);
                webView.setVisibility(View.VISIBLE);
                layoutDataEmpty.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
