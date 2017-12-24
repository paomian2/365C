package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ProductInfoBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  12:06
 * 版本：V1.0
 */
public class GetProductInfoResponse extends BaseResponse{

    private ProductInfoBean Data;

    public ProductInfoBean getData() {
        return Data;
    }

    public void setData(ProductInfoBean data) {
        Data = data;
    }
}
