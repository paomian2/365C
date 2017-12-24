package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.GoodsEvaluate;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class GoodsEvaluateModel extends BaseModel2 {

    /**
     * 后台获取商品评价信息
     */
    public void getGoodsEvaluate(ModelCallBack callBack){
        List<GoodsEvaluate> evaluateList = new ArrayList<>();
        GoodsEvaluate evaluate1 = new GoodsEvaluate();
        evaluate1.setHeadImaUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        evaluate1.setEvaluateContent("这个酒不错，价格也不贵，最重要的是口感好");
        evaluate1.setEvaluateTime("2017.07.22");
        evaluate1.setEvaluateType(1);
        evaluateList.add(evaluate1);
        GoodsEvaluate evaluate2 = new GoodsEvaluate();
        evaluate2.setHeadImaUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        evaluate2.setEvaluateContent("这个酒不错，价格也不贵，最重要的是口感好");
        evaluate2.setEvaluateTime("2017.07.22");
        evaluate2.setEvaluateType(2);
        evaluateList.add(evaluate2);
        GoodsEvaluate evaluate3 = new GoodsEvaluate();
        evaluate3.setHeadImaUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        evaluate3.setEvaluateContent("这个酒不错，价格也不贵，最重要的是口感好");
        evaluate3.setEvaluateTime("2017.07.22");
        evaluate3.setEvaluateType(3);
        evaluateList.add(evaluate3);
        GoodsEvaluate evaluate4 = new GoodsEvaluate();
        evaluate4.setHeadImaUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        evaluate4.setEvaluateContent("这个酒不错，价格也不贵，最重要的是口感好");
        evaluate4.setEvaluateTime("2017.07.22");
        evaluate4.setEvaluateType(1);
        evaluateList.add(evaluate4);
        callBack.onSuccess(evaluateList);
    }
}