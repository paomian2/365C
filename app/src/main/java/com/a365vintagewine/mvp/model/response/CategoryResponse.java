package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月18日  10:07
 * 版本：V1.0
 */
public class CategoryResponse extends BaseResponse{

    private List<CategoryBean> Data;

    public List<CategoryBean> getData() {
        return Data;
    }

    public void setData(List<CategoryBean> data) {
        Data = data;
    }
}
