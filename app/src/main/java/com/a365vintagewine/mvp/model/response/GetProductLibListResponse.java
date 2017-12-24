package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ProductLibBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月20日  0:40
 * 版本：V1.0
 */
public class GetProductLibListResponse extends BaseResponse{

    private List<ProductLibBean> Data;

    public List<ProductLibBean> getData() {
        return Data;
    }

    public void setData(List<ProductLibBean> data) {
        Data = data;
    }
}
