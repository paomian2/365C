package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ShopCarBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:07
 * 版本：V1.0
 */
public class AddProductResponse extends BaseResponse{


     private List<ShopCarBean> Data;

    public List<ShopCarBean> getData() {
        return Data;
    }

    public void setData(List<ShopCarBean> data) {
        Data = data;
    }
}
