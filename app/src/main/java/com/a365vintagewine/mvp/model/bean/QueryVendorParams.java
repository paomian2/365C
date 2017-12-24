package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：搜索附近商家参数
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月14日  17:12
 * 版本：3.0
 */

public class QueryVendorParams {

    /**商品id code 名称 或关键词*/
    private String Q;
    /**排序 0默认(如果geo不为null 则按距离倒序列) 1销量降序 2评论降序*/
    private String Sort;
    /**经纬度*/
    private Geo Geo;
    /**页数*/
    private String Page;
    /**分页大小 最大50*/
    private String Take;
    /**配送方式*/
    private Integer DeliveryId;

    public String getQ() {
        return Q;
    }

    public void setQ(String Q) {
        this.Q = Q;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String Sort) {
        this.Sort = Sort;
    }

    public Geo getGeo() {
        return Geo;
    }

    public void setGeo(Geo Geo) {
        this.Geo = Geo;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String Page) {
        this.Page = Page;
    }

    public String getTake() {
        return Take;
    }

    public void setTake(String Take) {
        this.Take = Take;
    }

    public Integer getDeliveryId() {
        return DeliveryId;
    }

    public void setDeliveryId(Integer DeliveryId) {
        this.DeliveryId = DeliveryId;
    }
}
