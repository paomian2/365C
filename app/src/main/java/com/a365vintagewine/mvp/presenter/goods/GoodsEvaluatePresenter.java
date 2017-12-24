package com.a365vintagewine.mvp.presenter.goods;

import com.a365vintagewine.mvp.model.bean.GoodsEvaluate;
import com.a365vintagewine.mvp.model.GoodsEvaluateModel;
import com.a365vintagewine.mvp.view.goods.GoodsEvaluateView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class GoodsEvaluatePresenter extends BasePresenter<GoodsEvaluateView,GoodsEvaluateModel> {
    public GoodsEvaluatePresenter(GoodsEvaluateView mView) {
        super(mView);
    }

    @Override
    public GoodsEvaluateModel createModel() {
        return new GoodsEvaluateModel();
    }

    /**
     * 获取商品评价数据
     */
    public void getGoodsEvaluate(){
        mModel.getGoodsEvaluate(new ModelCallBack<List<GoodsEvaluate>>() {
            @Override
            public void onSuccess(List<GoodsEvaluate> model) {
                mView.setGoodsEvaluateAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
