package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.OrderTrackBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:06
 * 版本：V1.0
 */
public class GetUserOrderTrackingResponse extends BaseResponse{

    private OrderTrackBean Data;

    public OrderTrackBean getData() {
        return Data;
    }

    public void setData(OrderTrackBean data) {
        Data = data;
    }
}
