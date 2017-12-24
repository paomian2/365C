package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.FollowShop;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public class FollowShopModel extends BaseModel2 {
    public void getFollowShop(ModelCallBack callBack){
        List<FollowShop> shopList = new ArrayList<>();
        FollowShop shop1 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台专卖店",4.6f);
        FollowShop shop2 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康专卖店",4.8f);
        FollowShop shop3 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山专卖店",3.6f);
        FollowShop shop4 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","链酒装卖店",4.9f);
        FollowShop shop5 = new FollowShop("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","老村长专卖店",3.2f);
        shopList.add(shop1);
        shopList.add(shop2);
        shopList.add(shop3);
        shopList.add(shop4);
        shopList.add(shop5);
        callBack.onSuccess(shopList);
    }

    /**
     * 删除关注的店铺
     */
    public void deleteShop(String shopId,ModelCallBack callBack){
        callBack.onSuccess(null);
    }
}
