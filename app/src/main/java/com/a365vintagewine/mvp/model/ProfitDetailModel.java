package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.ProfitDetail;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class ProfitDetailModel extends BaseModel2 {
    /**
     * 获取我的团队个人收益详情
     */
    public void getProfitDetail(ModelCallBack callBack){
        List<ProfitDetail> detailList = new ArrayList<>();
        ProfitDetail detail = new ProfitDetail("购物消费返利","07-10",1.2);
        ProfitDetail detai2 = new ProfitDetail("购物消费返利","07-20",2.2);
        ProfitDetail detai3 = new ProfitDetail("购物消费返利","07-30",1.5);
        ProfitDetail detai4 = new ProfitDetail("购物消费返利","08-12",0.8);
        ProfitDetail detai5 = new ProfitDetail("购物消费返利","08-18",1.6);
        ProfitDetail detai6 = new ProfitDetail("购物消费返利","08-26",2.8);
        detailList.add(detail);
        detailList.add(detai2);
        detailList.add(detai3);
        detailList.add(detai4);
        detailList.add(detai5);
        detailList.add(detai6);
        callBack.onSuccess(detailList);
    }

}
