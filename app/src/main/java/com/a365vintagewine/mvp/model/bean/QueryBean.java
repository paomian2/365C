package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * 描述：搜索商家或商品实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月15日  18:19
 * 版本：3.0
 */

public class QueryBean {


    /**商家分数*/
    private int Score;
    /**配送方式*/
    private String DeliveryIdPath;
    /**最小配送费*/
    private double MinFee;
    /**配送费*/
    private double DeliveryFee;
    /**积分*/
    private String JiFen;
    /**分销*/
    private String FenXiang;
    /**满减*/
    private String ManJian;
    /**折扣*/
    private String ZheKou;
    /***/
    private String DuoBao;
    /**砍价*/
    private String KanJia;
    /**商家Id*/
    private int Id;
    /**商家名称*/
    private String Name;
    /**店铺图片*/
    private String Image;
    /**经度*/
    private String Lng;
    /**纬度*/
    private String Lat;
    /**距离*/
    private String Distance;
    /**销量*/
    private int SaleCount;
    /**评论*/
    private int CommentCount;
    /**配送范围 单位km*/
    private double DisScope;
    private Object Ext;
    /**分类*/
    private List<CategorityBean> Categories;
    /**商品列表*/
    private List<ProductsBean> Products;



    //搜索商品展开专用
    private boolean showMoreTag;


    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getDeliveryIdPath() {
        return DeliveryIdPath;
    }

    public void setDeliveryIdPath(String deliveryIdPath) {
        DeliveryIdPath = deliveryIdPath;
    }

    public double getMinFee() {
        return MinFee;
    }

    public void setMinFee(double minFee) {
        MinFee = minFee;
    }

    public double getDeliveryFee() {
        return DeliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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

    public int getSaleCount() {
        return SaleCount;
    }

    public void setSaleCount(int saleCount) {
        SaleCount = saleCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public double getDisScope() {
        return DisScope;
    }

    public void setDisScope(double disScope) {
        DisScope = disScope;
    }

    public Object getExt() {
        return Ext;
    }

    public void setExt(Object ext) {
        Ext = ext;
    }

    public List<CategorityBean> getCategories() {
        return Categories;
    }

    public void setCategories(List<CategorityBean> categories) {
        Categories = categories;
    }

    public List<ProductsBean> getProducts() {
        return Products;
    }

    public void setProducts(List<ProductsBean> products) {
        Products = products;
    }

    public boolean isShowMoreTag() {
        return showMoreTag;
    }

    public void setShowMoreTag(boolean showMoreTag) {
        this.showMoreTag = showMoreTag;
    }
}
