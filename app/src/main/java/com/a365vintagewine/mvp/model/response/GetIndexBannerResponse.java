package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月11日  16:30
 * 版本：3.0
 */

public class GetIndexBannerResponse extends BaseResponse{

    private List<BannerBean> Data;

    public List<BannerBean> getData() {
        return Data;
    }

    public void setData(List<BannerBean> data) {
        Data = data;
    }
}
