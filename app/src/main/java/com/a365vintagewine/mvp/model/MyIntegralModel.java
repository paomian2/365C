package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.MyIntegral;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class MyIntegralModel extends BaseModel2 {
    public void getMyIntegral(ModelCallBack modelCallBack){
        MyIntegral integral = new MyIntegral();
        integral.setSumIntegral(1000);
        integral.setPlatformImg("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        integral.setPlatformIntegral(200);
        integral.setPlatformName("365名酒汇");
        MyIntegral.ShopIntegral shopIntegral1 = new MyIntegral.ShopIntegral("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","外贸烟酒店",200);
        MyIntegral.ShopIntegral shopIntegral2 = new MyIntegral.ShopIntegral("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","如意烟酒店",200);
        MyIntegral.ShopIntegral shopIntegral3 = new MyIntegral.ShopIntegral("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","蓝河烟酒店",200);
        MyIntegral.ShopIntegral shopIntegral4 = new MyIntegral.ShopIntegral("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg","牛栏山专卖店",200);
        List<MyIntegral.ShopIntegral> shopIntegrals = new ArrayList<>();
        shopIntegrals.add(shopIntegral1);
        shopIntegrals.add(shopIntegral2);
        shopIntegrals.add(shopIntegral3);
        shopIntegrals.add(shopIntegral4);
        integral.setShopList(shopIntegrals);
        modelCallBack.onSuccess(integral);
    }
}
