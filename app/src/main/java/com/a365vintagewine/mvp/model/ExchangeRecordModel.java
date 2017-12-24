package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.ExchangeRecord;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class ExchangeRecordModel extends BaseModel2 {
    public void getExchangeRecord(ModelCallBack modelCallBack){
        List<ExchangeRecord> records = new ArrayList<>();
        ExchangeRecord record = new ExchangeRecord();
        record.setGoodsIntegral(2000);
        record.setGoodsName("茅台");
        record.setGoodsnum(2);
        record.setOrderstatus(1);
        record.setSumGoodsIntegral(4000);
        record.setSumGoodsnum(2);
        record.setShopname("365名酒汇");
        record.setImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        records.add(record);
        ExchangeRecord record2 = new ExchangeRecord();
        record2.setGoodsIntegral(2000);
        record2.setGoodsName("五粮液");
        record2.setGoodsnum(2);
        record2.setOrderstatus(2);
        record2.setSumGoodsIntegral(4000);
        record2.setSumGoodsnum(2);
        record2.setShopname("365名酒汇");
        record2.setImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        records.add(record2);
        ExchangeRecord record3 = new ExchangeRecord();
        record3.setGoodsIntegral(1000);
        record3.setGoodsName("牛栏山");
        record3.setGoodsnum(2);
        record3.setOrderstatus(3);
        record3.setSumGoodsIntegral(2000);
        record3.setSumGoodsnum(2);
        record3.setShopname("365名酒汇");
        record3.setImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=177572737,1180578037&fm=26&gp=0.jpg");
        records.add(record3);
        modelCallBack.onSuccess(records);
    }
}
