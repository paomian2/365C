package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.IntegralMall;
import com.a365vintagewine.mvp.model.IntegralMallModel;
import com.a365vintagewine.mvp.view.IntegralMallView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class IntegralMallPresenter extends BasePresenter<IntegralMallView,IntegralMallModel> {
    public IntegralMallPresenter(IntegralMallView mView) {
        super(mView);
    }

    @Override
    public IntegralMallModel createModel() {
        return new IntegralMallModel();
    }

    public void getIntegralGoods(){
        mModel.getIntegralGoods(new ModelCallBack<List<IntegralMall>>() {

            @Override
            public void onSuccess(List<IntegralMall> model) {
                mView.setListAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
