package com.a365vintagewine.mvp.view.search;

import com.a365vintagewine.mvp.model.response.GetHotSearchKeyResponse;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1 0001.
 */

public interface SearchView extends BaseView {
    //获取热门关键字
    void getHotsearchData();
    //获取热门搜关键字结果
    void getHotsearchDataResult(boolean success,String msg,List<GetHotSearchKeyResponse.DataBean> dataBeanList);
    //保存搜索历史数据
    void saveHistorySearchData(String historySearch);
    //获取搜索历史数据
    void getHistorySearchData();
    //获取搜索历史数据
    void getHistorySearchDataResult(List<String> historyList);
    //清除历史记录
    void cleanHistory();


}
