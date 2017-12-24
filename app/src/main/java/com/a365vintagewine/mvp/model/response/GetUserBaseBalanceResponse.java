package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.BalanceBean;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  17:09
 * 版本：V1.0
 */
public class GetUserBaseBalanceResponse extends BaseResponse{

    private BalanceBean Data;

    public BalanceBean getData() {
        return Data;
    }

    public void setData(BalanceBean data) {
        Data = data;
    }
}
