package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.VoucherBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  15:11
 * 版本：V1.0
 */
public class GetUserCouponListResponse extends BaseResponse{

    private List<VoucherBean> Data;

    public List<VoucherBean> getData() {
        return Data;
    }

    public void setData(List<VoucherBean> data) {
        Data = data;
    }
}
