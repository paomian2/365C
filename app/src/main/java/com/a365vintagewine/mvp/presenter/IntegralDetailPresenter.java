package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.bean.IntegralDetail;
import com.a365vintagewine.mvp.model.IntegralDetailModel;
import com.a365vintagewine.mvp.model.response.GetUserConsignorPointListResponse;
import com.a365vintagewine.mvp.view.IntegralDetailView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;
import java.util.Map;

public class IntegralDetailPresenter extends BasePresenter<IntegralDetailView,UserModel> {
    public IntegralDetailPresenter(IntegralDetailView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 获取积分详情数据
     */
    public void GetUserConsignorPointList(Map<String,Object> params){
        mModel.getUserConsignorPointList(params,new ModelCallBack<GetUserConsignorPointListResponse.PointListData>() {

            @Override
            public void onSuccess(GetUserConsignorPointListResponse.PointListData model) {
                mView.getUserConsignorPointListResult(true,"获取明细成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.getUserConsignorPointListResult(false,"获取明细成功",null);
            }
        });
    }
}
