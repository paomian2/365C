package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.ProfitDetail;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public interface ProfitDetailView extends BaseView {
    //适配我的团队个人收益列表
    void setProfitDetialAdapter(List<ProfitDetail> list);
}
