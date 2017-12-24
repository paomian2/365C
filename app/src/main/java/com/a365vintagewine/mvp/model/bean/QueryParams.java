package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：搜索商家商品列表参数
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  16:53
 * 版本：3.0
 */

public class QueryParams {

    /**商品id code 名称 或关键词*/
    private String Q;
    /**品牌id 多个以','分隔*/
    private String B;
    /**类目id 多个以','分隔*/
    private String C;
    /**配送方式id 多个以','分隔*/
    private String D;
    /**经纬度*/
    private Geo Geo;
    /**排序 0默认(如果geo不为null 则按距离倒序列) 1销量降序 2价格升序 3价格降序 4 评论降序*/
    private String Sort;
    /**页数*/
    private String Page;
    /**分页大小*/
    private String Take;
    /**商家Id*/
    private String Vendor;
    /**区间价起始值*/
    private String PriceF;
    /**区间价结束值*/
    private String PriceT;
    /**是否按商家分组*/
    private boolean Group;
    /**是否聚合品牌和配送方式*/
    private boolean Facet;

    //公共参数

    private String FromClient;
    private String PlatformAccount;
    private String AccessToken;
    private String TimeStamp;
    private String Ver;
    private String DeviceIMEINumber;
    private String Sign;
    private String Method;
    private String SignKeyToken;

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public com.a365vintagewine.mvp.model.bean.Geo getGeo() {
        return Geo;
    }

    public void setGeo(com.a365vintagewine.mvp.model.bean.Geo geo) {
        Geo = geo;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    public String getTake() {
        return Take;
    }

    public void setTake(String take) {
        Take = take;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public String getPriceF() {
        return PriceF;
    }

    public void setPriceF(String priceF) {
        PriceF = priceF;
    }

    public String getPriceT() {
        return PriceT;
    }

    public void setPriceT(String priceT) {
        PriceT = priceT;
    }

    public boolean isGroup() {
        return Group;
    }

    public void setGroup(boolean group) {
        Group = group;
    }

    public boolean isFacet() {
        return Facet;
    }

    public void setFacet(boolean facet) {
        Facet = facet;
    }

    public String getFromClient() {
        return FromClient;
    }

    public void setFromClient(String fromClient) {
        FromClient = fromClient;
    }

    public String getPlatformAccount() {
        return PlatformAccount;
    }

    public void setPlatformAccount(String platformAccount) {
        PlatformAccount = platformAccount;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getVer() {
        return Ver;
    }

    public void setVer(String ver) {
        Ver = ver;
    }

    public String getDeviceIMEINumber() {
        return DeviceIMEINumber;
    }

    public void setDeviceIMEINumber(String deviceIMEINumber) {
        DeviceIMEINumber = deviceIMEINumber;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public String getSignKeyToken() {
        return SignKeyToken;
    }

    public void setSignKeyToken(String signKeyToken) {
        SignKeyToken = signKeyToken;
    }
}
