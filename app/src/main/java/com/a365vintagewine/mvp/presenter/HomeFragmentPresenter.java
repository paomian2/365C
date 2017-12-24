package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.SearchModel;
import com.a365vintagewine.mvp.model.bean.BannerBean;
import com.a365vintagewine.mvp.model.bean.ProductLibBean;
import com.a365vintagewine.mvp.model.bean.QueryVendorBean;
import com.a365vintagewine.mvp.model.bean.QueryVendorParams;
import com.a365vintagewine.mvp.view.HomeFragmentView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import java.util.ArrayList;
import java.util.List;
/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月11日  15:47
 * 版本：3.0
 */

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentView,CmsContentModel> {

    private SearchModel searchModel;
    public HomeFragmentPresenter(HomeFragmentView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        searchModel=new SearchModel();
        return new CmsContentModel();
    }

    /**获取banner图*/
    public void GetIndexBanner(){
        mModel.GetIndexBanner(new ModelCallBack<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> model) {
                ArrayList<com.commsdk.common.widget.banner.BannerBean> bannerBeanList=new ArrayList<>();
                for (BannerBean bannerBean:model){
                    com.commsdk.common.widget.banner.BannerBean bannerBean1=new com.commsdk.common.widget.banner.BannerBean();
                    bannerBean1.setAdId(bannerBean.getContent_Id()+"");
                    bannerBean1.setTheme(bannerBean.getTitle());
                    bannerBean1.setContent(bannerBean.getSubTitle());
                    bannerBean1.setAdPic(bannerBean.getPicURL());
                    bannerBean1.setJumpUrl(bannerBean.getURLaddress());
                    bannerBeanList.add(bannerBean1);
                }
               mView.CmsActivityBannerRequestModelResult(true,bannerBeanList,"获取轮播图成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.CmsActivityBannerRequestModelResult(false,null,msg);
            }
        });
    }

    /**获取四个活动*/
    public void GetIndexIcon(){
        mModel.GetIndexIcon(new ModelCallBack<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> model) {
                mView.GetIndexIconResult(true,model,"获取轮播图成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.GetIndexIconResult(false,null,msg);
            }
        });
    }

    /**获取首页广告位*/
    public void GetIndexAd(){
        mModel.GetIndexAd(new ModelCallBack<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> model) {
                mView.GetIndexAdResult(true,model,"获取轮播图成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.GetIndexAdResult(false,null,msg);
            }
        });
    }

    /**热卖产品*/
    public void GetProductLibList(){
        mModel.GetProductLibList(new ModelCallBack<List<ProductLibBean>>() {
            @Override
            public void onSuccess(List<ProductLibBean> model) {
                mView.GetProductLibListResult(true,"获取热卖产品成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetProductLibListResult(false,msg,null);
            }
        });
    }

    /**搜索附近商家*/
    public void QueryVendor(QueryVendorParams params){
        searchModel.QueryVendor(params, new ModelCallBack<List<QueryVendorBean>>() {
            @Override
            public void onSuccess(List<QueryVendorBean> model) {
               mView.QueryVendorResulst(true,"",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.QueryVendorResulst(false,msg,null);
            }
        });
    }



    @Override
    public void detachView() {
        searchModel.onUnsubscribe();
        super.detachView();
    }
}
