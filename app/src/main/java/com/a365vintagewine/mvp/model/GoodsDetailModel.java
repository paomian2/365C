package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.GoodsDetail;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class GoodsDetailModel extends BaseModel2 {
    /**
     * 获取商品详情信息
     */
    public void getGoodsDetail(ModelCallBack callBack){
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setCollect(false);
        goodsDetail.setGoodsCartNum(0);
        goodsDetail.setGoodsName("长城干红葡萄酒750ml");
        goodsDetail.setGoodsPrice(100);
        goodsDetail.setMonthSell(3000);
        goodsDetail.setRecommendedPrice(110);
        goodsDetail.setShippingfee(5);
        List<String> imgUrls = new ArrayList<>();
        imgUrls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        imgUrls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        goodsDetail.setGoodsImgUrls(imgUrls);
        List<String> goodsAttribute = new ArrayList<>();
        goodsAttribute.add("产地：法国");
        goodsAttribute.add("酒精度：16度");
        goodsAttribute.add("净含量：750ml");
        goodsAttribute.add("年份：2012");
        goodsAttribute.add("品牌：长城");
        goodsAttribute.add("树龄：7年");
        goodsAttribute.add("品质：优质");
        goodsDetail.setGoodsAttribute(goodsAttribute);
        callBack.onSuccess(goodsDetail);
    }
}
