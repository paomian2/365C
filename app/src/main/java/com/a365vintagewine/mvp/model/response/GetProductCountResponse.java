package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ShopCarProductCountBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:38
 * 版本：V1.0
 */
public class GetProductCountResponse extends BaseResponse{

    private ShopCarProductCountBean Data;

    public ShopCarProductCountBean getData() {
        return Data;
    }

    public void setData(ShopCarProductCountBean data) {
        Data = data;
    }
}
