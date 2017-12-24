package com.a365vintagewine.mvp.view;
import com.a365vintagewine.mvp.model.response.GetUserConsignorPointListResponse;
import com.commsdk.base.view.BaseView;

public interface IntegralDetailView extends BaseView {
    //适配积分明细
    void getUserConsignorPointList();
    void getUserConsignorPointListResult(boolean success, String msg, GetUserConsignorPointListResponse.PointListData pointListData);
}
