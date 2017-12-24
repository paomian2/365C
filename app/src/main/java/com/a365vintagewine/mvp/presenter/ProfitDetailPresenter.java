package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.ProfitDetail;
import com.a365vintagewine.mvp.model.ProfitDetailModel;
import com.a365vintagewine.mvp.view.ProfitDetailView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class ProfitDetailPresenter extends BasePresenter<ProfitDetailView,ProfitDetailModel> {
    public ProfitDetailPresenter(ProfitDetailView mView) {
        super(mView);
    }

    @Override
    public ProfitDetailModel createModel() {
        return new ProfitDetailModel();
    }

    /**
     * 获取我的团队个人收益详情
     */
    public void getProfitDetail(){
        mModel.getProfitDetail(new ModelCallBack<List<ProfitDetail>>() {

            @Override
            public void onSuccess(List<ProfitDetail> model) {
                mView.setProfitDetialAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
