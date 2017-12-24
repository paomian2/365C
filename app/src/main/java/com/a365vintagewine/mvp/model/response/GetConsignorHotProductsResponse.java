package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ProductsBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：商家热销商品列表
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  16:38
 * 版本：3.0
 */

public class GetConsignorHotProductsResponse extends BaseResponse{

    private List<ProductsBean> Data;

    public List<ProductsBean> getData() {
        return Data;
    }

    public void setData(List<ProductsBean> data) {
        Data = data;
    }
}
