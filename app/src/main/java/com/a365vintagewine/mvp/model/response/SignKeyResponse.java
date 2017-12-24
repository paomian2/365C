package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.SignKey;
import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月27日  14:26
 * 版本：3.0
 */

public class SignKeyResponse extends BaseResponse{

    private SignKey Data;

    public SignKey getData() {
        return Data;
    }

    public void setData(SignKey data) {
        Data = data;
    }
}
