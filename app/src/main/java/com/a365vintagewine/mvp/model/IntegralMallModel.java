package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.IntegralMall;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class IntegralMallModel extends BaseModel2 {
    public void getIntegralGoods(ModelCallBack modelCallBack){
        List<IntegralMall> goodsList = new ArrayList<>();
        goodsList.add(new IntegralMall("茅台","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        goodsList.add(new IntegralMall("杜康","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        goodsList.add(new IntegralMall("五粮液","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        goodsList.add(new IntegralMall("干红","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        goodsList.add(new IntegralMall("拉菲","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        goodsList.add(new IntegralMall("牛栏山","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg",2000));
        modelCallBack.onSuccess(goodsList);
    }
}
