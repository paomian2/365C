package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.IntegralDetail;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class IntegralDetailModel extends BaseModel2 {
    public void getIntegralDetail(ModelCallBack modelCallBack){
        List<IntegralDetail> mlist = new ArrayList<>();
        mlist.add(new IntegralDetail("订单抵扣","-78","20051255634","07-12"));
        mlist.add(new IntegralDetail("消费奖励","+98","20051251565","07-14"));
        mlist.add(new IntegralDetail("消费奖励","+98","20051252724","07-25"));
        mlist.add(new IntegralDetail("消费奖励","+98","20051255773","08-10"));
        mlist.add(new IntegralDetail("消费奖励","+98","20051252753","08-25"));
        mlist.add(new IntegralDetail("消费奖励","+98","20051257527","08-30"));
        modelCallBack.onSuccess(mlist);
    }
}
