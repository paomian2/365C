package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.ExchangeRecord;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public interface ExchangeRecordView extends BaseView{
    //设置适配器数据
    void setMyAdapter(List<ExchangeRecord> list);
}

