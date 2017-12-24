package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.FollowGoods;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public class FollowGoodsModel extends BaseModel2 {

    public void getFoloowGoods(ModelCallBack callBack){
        List<FollowGoods> goodses = new ArrayList<>();
        FollowGoods goods1 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","茅台",1000);
        FollowGoods goods2 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","杜康",200);
        FollowGoods goods3 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山",100);
        FollowGoods goods4 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","链酒",1000);
        FollowGoods goods5 = new FollowGoods("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","老村长",50);
        goodses.add(goods1);
        goodses.add(goods2);
        goodses.add(goods3);
        goodses.add(goods4);
        goodses.add(goods5);
        callBack.onSuccess(goodses);
    }

    /**
     * 删除关注的商品
     */
    public void deleteGodds(String goodsId,ModelCallBack callBack){
        callBack.onSuccess(null);
    }
}
