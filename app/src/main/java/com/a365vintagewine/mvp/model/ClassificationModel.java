package com.a365vintagewine.mvp.model;


import com.a365vintagewine.mvp.model.bean.Brand;
import com.a365vintagewine.mvp.model.bean.ThreeLevelList;
import com.a365vintagewine.mvp.model.bean.TwoLevelList;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class ClassificationModel extends BaseModel2 {

    public static final String[] toolsList = { "特价", "潮流女装", "品牌男装", "内衣配饰",
            "精品童装", "家用电器", "手机数码", "电脑办公", "个护化妆", "母婴频道", "美食", "海鲜", "家居家纺",
            "整车车品", "鞋靴箱包", "运动户外", "图书", "玩具乐器", "钟表", "居家生活", "珠宝饰品", "音像制品",
            "家具建材", "营养保健", "奢侈礼品", "生活服务", "旅游出行" };

    public void getThreeLevelList(ModelCallBack modelCallBack){
        TwoLevelList twoLevelList = new TwoLevelList();
        twoLevelList.setTwoLevelImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        List<ThreeLevelList> threeLevelLists = new ArrayList<>();
        ThreeLevelList threeLevelList1 = new ThreeLevelList();
        threeLevelList1.setTwoLevelname("白酒");
        List<Brand> spirit = new ArrayList<>();
        Brand maotai = new Brand();
        maotai.setBrandImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        maotai.setBrandName("茅台");
        Brand dukang = new Brand();
        dukang.setBrandImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        dukang.setBrandName("杜康");
        Brand wuliangye = new Brand();
        wuliangye.setBrandImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        wuliangye.setBrandName("五粮液");
        Brand niulanshan = new Brand();
        niulanshan.setBrandImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        niulanshan.setBrandName("茅台");
        spirit.add(maotai);
        spirit.add(dukang);
        spirit.add(wuliangye);
        spirit.add(niulanshan);
        spirit.add(maotai);
        spirit.add(dukang);
        spirit.add(wuliangye);
        spirit.add(niulanshan);
        threeLevelList1.setBrandList(spirit);
        threeLevelLists.add(threeLevelList1);

        ThreeLevelList threeLevelList2 = new ThreeLevelList();
        threeLevelList2.setTwoLevelname("啤酒");
        List<Brand> beer = new ArrayList<>();
        Brand xuehua = new Brand();
        xuehua.setBrandImgUrl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2792355287,3061988672&fm=117&gp=0.jpg");
        xuehua.setBrandName("雪花");
        Brand qingdao = new Brand();
        qingdao.setBrandImgUrl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4021260395,2827773590&fm=117&gp=0.jpg");
        qingdao.setBrandName("青岛");
        Brand jinmaiwang = new Brand();
        jinmaiwang.setBrandImgUrl("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2277853943,2887919315&fm=117&gp=0.jpg");
        jinmaiwang.setBrandName("金麦王");
        beer.add(xuehua);
        beer.add(qingdao);
        beer.add(jinmaiwang);
        threeLevelList2.setBrandList(beer);
        threeLevelLists.add(threeLevelList2);

        twoLevelList.setThreeLevelLists(threeLevelLists);
        modelCallBack.onSuccess(twoLevelList);
    }

}
