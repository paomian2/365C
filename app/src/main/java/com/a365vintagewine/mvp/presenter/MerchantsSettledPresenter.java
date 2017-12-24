package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.MerchantsSettledModel;
import com.a365vintagewine.mvp.view.MerchantsSettledView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.Map;

/**
 * 申请开店
 */

public class MerchantsSettledPresenter extends BasePresenter<MerchantsSettledView,CmsContentModel> {
    public MerchantsSettledPresenter(MerchantsSettledView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }


    public void ApplyShop(Map<String,Object> params){
        mModel.ApplyShop(params, new ModelCallBack<String>() {
            @Override
            public void onSuccess(String model) {
                mView.ApplyShopResult(true,model);
            }

            @Override
            public void onFailure(String msg) {
                mView.ApplyShopResult(false,msg);
            }
        });
    }
}
