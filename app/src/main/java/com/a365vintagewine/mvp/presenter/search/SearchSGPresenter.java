package com.a365vintagewine.mvp.presenter.search;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.QueryBean;
import com.a365vintagewine.mvp.model.bean.ShopGoods;
import com.a365vintagewine.mvp.model.SearchSGModel;
import com.a365vintagewine.mvp.model.response.QueryResponse;
import com.a365vintagewine.mvp.view.search.SearchSGView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;
import java.util.Map;

/**
 * 店铺商品搜索
 */

public class SearchSGPresenter extends BasePresenter<SearchSGView,CmsContentModel> {


    public SearchSGPresenter(SearchSGView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }


    /**店铺商品搜索*/
    public void StoreGoodsQuery(Map<String,Object> params){
        mModel.StoreGoodsQuery(params, new ModelCallBack<QueryResponse>() {
            @Override
            public void onSuccess(QueryResponse model) {
                mView.StoreGoodsQueryResult(true,"搜索成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.StoreGoodsQueryResult(true,msg,null);
            }
        });
    }

}
