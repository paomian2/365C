package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public interface RankingListView extends BaseView {
    //适配我的团队列表数据
    void setRankingListAdapter(List<MyTeam> list);
}