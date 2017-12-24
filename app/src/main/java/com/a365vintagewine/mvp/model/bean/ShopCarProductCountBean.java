package com.a365vintagewine.mvp.model.bean;

/**
 * 描述：获取商家购物车商品总数量
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  22:35
 * 版本：V1.0
 */
public class ShopCarProductCountBean {


    /**
     * DealerShortName : sample string 1
     * SumProductCount : 2
     * SumProductPrice : 3.0
     * JSProductCount : 4
     * NoJSProductCount : 5
     * SumJiFen : 6
     * PeiSongFei : 7.0
     */

    /**
     * 卖家名称
     */
    private String DealerShortName;
    /**
     * 商品总数
     */
    private int SumProductCount;
    /**
     * 商品总价格
     */
    private double SumProductPrice;
    /***/
    private int JSProductCount;
    /***/
    private int NoJSProductCount;
    /**
     * 总积分
     */
    private int SumJiFen;
    /**
     * 配送费
     */
    private double PeiSongFei;

    public String getDealerShortName() {
        return DealerShortName;
    }

    public void setDealerShortName(String DealerShortName) {
        this.DealerShortName = DealerShortName;
    }

    public int getSumProductCount() {
        return SumProductCount;
    }

    public void setSumProductCount(int SumProductCount) {
        this.SumProductCount = SumProductCount;
    }

    public double getSumProductPrice() {
        return SumProductPrice;
    }

    public void setSumProductPrice(double SumProductPrice) {
        this.SumProductPrice = SumProductPrice;
    }

    public int getJSProductCount() {
        return JSProductCount;
    }

    public void setJSProductCount(int JSProductCount) {
        this.JSProductCount = JSProductCount;
    }

    public int getNoJSProductCount() {
        return NoJSProductCount;
    }

    public void setNoJSProductCount(int NoJSProductCount) {
        this.NoJSProductCount = NoJSProductCount;
    }

    public int getSumJiFen() {
        return SumJiFen;
    }

    public void setSumJiFen(int SumJiFen) {
        this.SumJiFen = SumJiFen;
    }

    public double getPeiSongFei() {
        return PeiSongFei;
    }

    public void setPeiSongFei(double PeiSongFei) {
        this.PeiSongFei = PeiSongFei;
    }
}
