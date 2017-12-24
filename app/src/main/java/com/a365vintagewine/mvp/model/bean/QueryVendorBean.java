package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：附近商家实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月13日  22:47
 * 版本：3.0
 */

public class QueryVendorBean {

    /**商品或店铺Id*/
    private Integer Id;
    /**商品或店铺名称*/
    private String Name;
    /**商品或店铺图片*/
    private String Image;
    /**经度*/
    private String Lng;
    /**纬度*/
    private String Lat;
    /**距离*/
    private String Distance;
    /**商品或店铺销量*/
    private Integer SaleCount;
    /**商品或店铺评论*/
    private Integer CommentCount;
    /**配送范围 单位km*/
    private double DisScope;
    private String Ext;
    /**打分*/
    private Integer Score;
    private String DeliveryIdPath;
    /**快递最小费用*/
    private String MinFee;
    /**快递费*/
    private String DeliveryFee;
    /**积分*/
    private String JiFen;
    /**分销*/
    private String FenXiang;
    /**满减*/
    private String ManJian;
    /**折扣*/
    private String ZheKou;
    private String DuoBao;
    /**砍价*/
    private String KanJia;
    private List<CategorityBean> Categories;
    /**商品*/
    //Products


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public Integer getSaleCount() {
        return SaleCount;
    }

    public void setSaleCount(Integer saleCount) {
        SaleCount = saleCount;
    }

    public Integer getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Integer commentCount) {
        CommentCount = commentCount;
    }

    public double getDisScope() {
        return DisScope;
    }

    public void setDisScope(double disScope) {
        DisScope = disScope;
    }

    public String getExt() {
        return Ext;
    }

    public void setExt(String ext) {
        Ext = ext;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public String getDeliveryIdPath() {
        return DeliveryIdPath;
    }

    public void setDeliveryIdPath(String deliveryIdPath) {
        DeliveryIdPath = deliveryIdPath;
    }

    public String getMinFee() {
        return MinFee;
    }

    public void setMinFee(String minFee) {
        MinFee = minFee;
    }

    public String getDeliveryFee() {
        return DeliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        DeliveryFee = deliveryFee;
    }

    public String getJiFen() {
        return JiFen;
    }

    public void setJiFen(String jiFen) {
        JiFen = jiFen;
    }

    public String getFenXiang() {
        return FenXiang;
    }

    public void setFenXiang(String fenXiang) {
        FenXiang = fenXiang;
    }

    public String getManJian() {
        return ManJian;
    }

    public void setManJian(String manJian) {
        ManJian = manJian;
    }

    public String getZheKou() {
        return ZheKou;
    }

    public void setZheKou(String zheKou) {
        ZheKou = zheKou;
    }

    public String getDuoBao() {
        return DuoBao;
    }

    public void setDuoBao(String duoBao) {
        DuoBao = duoBao;
    }

    public String getKanJia() {
        return KanJia;
    }

    public void setKanJia(String kanJia) {
        KanJia = kanJia;
    }

    public List<CategorityBean> getCategories() {
        return Categories;
    }

    public void setCategories(List<CategorityBean> categories) {
        Categories = categories;
    }
}
