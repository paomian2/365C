package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.IntegralMall;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public interface IntegralMallView extends BaseView {
    //适配列表数据
    void setListAdapter(List<IntegralMall> goodsList);
}
