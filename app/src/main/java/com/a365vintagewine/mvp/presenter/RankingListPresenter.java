package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.a365vintagewine.mvp.model.RankingListModel;
import com.a365vintagewine.mvp.view.RankingListView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class RankingListPresenter extends BasePresenter<RankingListView,RankingListModel> {
    public RankingListPresenter(RankingListView mView) {
        super(mView);
    }

    @Override
    public RankingListModel createModel() {
        return new RankingListModel();
    }

    /**
     * 获取我的团队列表信息
     */
    public void getRankingList(){
        mModel.getRankingList(new ModelCallBack<List<MyTeam>>() {

            @Override
            public void onSuccess(List<MyTeam> model) {
                mView.setRankingListAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
