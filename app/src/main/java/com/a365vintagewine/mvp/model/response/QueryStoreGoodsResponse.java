package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：查询店铺/商品列表
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月18日  13:04
 * 版本：V1.0
 */
public class QueryStoreGoodsResponse extends BaseResponse{

    private List<QueryBean> Data;

    public List<QueryBean> getData() {
        return Data;
    }

    public void setData(List<QueryBean> data) {
        Data = data;
    }
}
