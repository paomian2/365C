package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.FollowShop;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public interface FollowShopView extends BaseView {
    //获取关注店铺列表数据
    void getFavoriteShopList();
    //获取店铺列表结果回调
    void getFavoriteShopListResult(boolean success,List<GetFavoriteShopListReponse.DataBean.PagedDataBean> pagedDataBeanList,String msg);
    //删除关注的店铺
    void deleteShop(String shopId);
    //删除关注店铺结果回调
    void deleteShopResult(boolean success,String msg);
}
