package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.ProductLibBean;
import com.a365vintagewine.mvp.model.bean.QueryVendorBean;
import com.commsdk.base.view.BaseView;
import com.commsdk.common.widget.banner.BannerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月11日  15:37
 * 版本：3.0
 */

public interface HomeFragmentView extends BaseView{

    /**获取轮播图*/
     void CmsActivityBannerRequestModel();
    /**获取轮播图结果返回*/
     void CmsActivityBannerRequestModelResult(boolean success, ArrayList<BannerBean> bannerBeanList, String msg);
    /**获取首页四个活动*/
     void GetIndexIcon();
    /**获取首页四个活动结果回调*/
     void GetIndexIconResult(boolean success, List<com.a365vintagewine.mvp.model.bean.BannerBean> bannerBeanList,String msg);
    /**获取首页广告位*/
     void GetIndexAd();
    /**获取首页广告位结果回调*/
     void GetIndexAdResult(boolean success, List<com.a365vintagewine.mvp.model.bean.BannerBean> bannerBeanList,String msg);
     /**热卖产品*/
     void GetProductLibList();
     /**热卖产品结果回调*/
     void GetProductLibListResult(boolean success, String msg, List<ProductLibBean> list);
    /**搜索附近商家*/
     void QueryVendor();
    /**搜索附近商家结果回调*/
    void QueryVendorResulst(boolean success, String msg, List<QueryVendorBean> list);

}
