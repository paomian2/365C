package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.QueryVendorBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：附近的商家
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月13日  23:02
 * 版本：3.0
 */

public class QueryVendorResponse extends BaseResponse{

    private List<QueryVendorBean> Data;

    public List<QueryVendorBean> getData() {
        return Data;
    }

    public void setData(List<QueryVendorBean> data) {
        Data = data;
    }
}
