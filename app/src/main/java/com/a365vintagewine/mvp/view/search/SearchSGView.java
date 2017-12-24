package com.a365vintagewine.mvp.view.search;

import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.a365vintagewine.mvp.model.bean.ShopGoods;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * 店铺商品搜索
 */

public interface SearchSGView extends BaseView {
    /**店铺商品搜索*/
    void StoreGoodsQuery();
    /**店铺商品搜索结果回调*/
    void StoreGoodsQueryResult(boolean success, String msg,QueryResponse queryResponse);
}
