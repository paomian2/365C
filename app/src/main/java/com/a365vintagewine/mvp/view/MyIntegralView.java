package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.MyIntegral;
import com.a365vintagewine.mvp.model.bean.PointBean;
import com.a365vintagewine.mvp.model.response.GetUserPointResponse;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public interface MyIntegralView extends BaseView {

    /**获取积分列表*/
    public void getUserPoint();
    /**获取积分列表结果*/
    public void getUserPointResult(boolean success, GetUserPointResponse.DataBean dataBean, String msg);
}
