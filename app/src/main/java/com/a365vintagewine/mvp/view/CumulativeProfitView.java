package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.CumulativeDetail;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public interface CumulativeProfitView extends BaseView {
    //适配累计收益明细列表
    void setCumulativeAdapter(List<CumulativeDetail> list);
}
