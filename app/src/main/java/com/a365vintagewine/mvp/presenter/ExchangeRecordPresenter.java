package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.ExchangeRecord;
import com.a365vintagewine.mvp.model.ExchangeRecordModel;
import com.a365vintagewine.mvp.view.ExchangeRecordView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class ExchangeRecordPresenter extends BasePresenter<ExchangeRecordView,ExchangeRecordModel> {
    public ExchangeRecordPresenter(ExchangeRecordView mView) {
        super(mView);
    }

    @Override
    public ExchangeRecordModel createModel() {
        return new ExchangeRecordModel();
    }

    public void getExchangeRecord(){
        mModel.getExchangeRecord(new ModelCallBack<List<ExchangeRecord>>() {

            @Override
            public void onSuccess(List<ExchangeRecord> model) {
                mView.setMyAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
