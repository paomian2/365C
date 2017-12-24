package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.ConsignorBasicInfo;
import com.commsdk.module.response.base.BaseResponse;
/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  11:43
 * 版本：3.0
 */

public class GetConsignorBasicInfoResponse extends BaseResponse{


    private ConsignorBasicInfo Data;

    public ConsignorBasicInfo getData() {
        return Data;
    }

    public void setData(ConsignorBasicInfo data) {
        Data = data;
    }
}
