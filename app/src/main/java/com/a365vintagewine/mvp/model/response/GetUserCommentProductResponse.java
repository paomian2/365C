package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.OrderCommentBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  16:23
 * 版本：V1.0
 */
public class GetUserCommentProductResponse extends BaseResponse{

    private OrderCommentBean Data;

    public OrderCommentBean getData() {
        return Data;
    }

    public void setData(OrderCommentBean data) {
        Data = data;
    }

}
