package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.VoucherCountBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  14:52
 * 版本：V1.0
 */
public class GetUserCouponNumResponse extends BaseResponse{

    private VoucherCountBean Data;

    public VoucherCountBean getData() {
        return Data;
    }

    public void setData(VoucherCountBean data) {
        Data = data;
    }
}
