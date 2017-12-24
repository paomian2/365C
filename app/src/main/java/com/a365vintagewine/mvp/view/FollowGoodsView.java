package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.FollowGoods;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.commsdk.base.view.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public interface FollowGoodsView extends BaseView {
    /**获取商品关注列表*/
    public void getFavoriteProductList();
    /**获取商品关注列表*/
    public void getFavoriteProductListResult(boolean success, List<GetFavoriteProductListResponse.DataBean.PagedDataBean> dataBeanList,String msg);
    /**取消关注的商品*/
    public void delFavoriteProductList(String Products_Id);
    /**取消关注结果回调*/
    public void delFavoriteProductListResult(boolean success,String msg);
}
