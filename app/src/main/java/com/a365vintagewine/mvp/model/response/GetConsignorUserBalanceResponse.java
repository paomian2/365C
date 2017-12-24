package com.a365vintagewine.mvp.model.response;
import com.a365vintagewine.mvp.model.bean.ConsignorBalanceOrderBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  17:36
 * 版本：V1.0
 */
public class GetConsignorUserBalanceResponse extends BaseResponse{

    private List<ConsignorBalanceOrderBean> Data;

    public List<ConsignorBalanceOrderBean> getData() {
        return Data;
    }

    public void setData(List<ConsignorBalanceOrderBean> data) {
        Data = data;
    }
}
