package com.a365vintagewine.mvp.model.response;
import com.a365vintagewine.mvp.model.bean.FacetsBean;
import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.commsdk.module.response.base.BaseResponse;
import java.util.List;
/**
 * 描述：查询商品返回（Group：true  Facet:true）
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  16:51
 * 版本：3.0
 */

public class QueryResponse extends BaseResponse {

    private List<QueryBean> Data;
    private FacetsBean Facets;

    public List<QueryBean> getData() {
        return Data;
    }

    public void setData(List<QueryBean> data) {
        Data = data;
    }

    public FacetsBean getFacets() {
        return Facets;
    }

    public void setFacets(FacetsBean facets) {
        Facets = facets;
    }
}
