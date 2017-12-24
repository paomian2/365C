package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.B2COrderBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月24日  15:56
 * 版本：V1.0
 */
public class GetUserOrderDetailsResponse extends BaseResponse{

    private B2COrderBean Data;

    public B2COrderBean getData() {
        return Data;
    }

    public void setData(B2COrderBean data) {
        Data = data;
    }
}
