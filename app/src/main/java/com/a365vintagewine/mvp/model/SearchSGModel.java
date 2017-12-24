package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.FollowGoods;
import com.a365vintagewine.mvp.model.bean.FollowShop;
import com.a365vintagewine.mvp.model.bean.ShopGoods;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/1 0001.
 */

public class SearchSGModel extends BaseModel2 {

    /**
     * 获取商家商品数据
     */
    public void getShopGoods(ModelCallBack callBack){
        List<ShopGoods> shopGoodses = new ArrayList<>();
        //商家一的信息
        FollowShop shop1 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台专卖店",4.6f);
        shop1.setShopDistance(900);
        List<FollowGoods> goodses1 = new ArrayList<>();
        FollowGoods goods11 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台",1000);
        FollowGoods goods12 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康",200);
        FollowGoods goods13 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山",100);
        FollowGoods goods14 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","链酒",1000);
        FollowGoods goods15 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","老村长",50);
        goodses1.add(goods11);
        goodses1.add(goods12);
        goodses1.add(goods13);
        goodses1.add(goods14);
        goodses1.add(goods15);
        shopGoodses.add(new ShopGoods(shop1,goodses1));

        //商家二的信息
        FollowShop shop2 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康专卖店",4.8f);
        shop2.setShopDistance(2800);
        List<FollowGoods> goodses2 = new ArrayList<>();
        FollowGoods goods21 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台",1000);
        FollowGoods goods22 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康",200);
        FollowGoods goods23 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山",100);
        goodses2.add(goods11);
        goodses2.add(goods22);
        goodses2.add(goods23);
        shopGoodses.add(new ShopGoods(shop2,goodses2));
        FollowShop shop3 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","老村长专卖店",3.2f);
        shop3.setShopDistance(3000);
        List<FollowGoods> goodses3 = new ArrayList<>();
        FollowGoods goods31 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台",1000);
        FollowGoods goods32 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康",200);
        FollowGoods goods33 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山",100);
        goodses3.add(goods31);
        goodses3.add(goods32);
        goodses3.add(goods33);
        shopGoodses.add(new ShopGoods(shop3,goodses3));
        callBack.onSuccess(shopGoodses);
    }

    /**
     * 获取筛选中品牌数据
     */
    public void getBrand(ModelCallBack callBack){
        List<String> brandList = new ArrayList<>();
        brandList.add("茅台");
        brandList.add("五粮液");
        brandList.add("汾酒");
        brandList.add("牛栏山");
        brandList.add("二锅头");
        brandList.add("老村长");
        brandList.add("天之蓝");
        brandList.add("杜康");
        brandList.add("海之蓝");
        brandList.add("梦之蓝");
        callBack.onSuccess(brandList);
    }
}
