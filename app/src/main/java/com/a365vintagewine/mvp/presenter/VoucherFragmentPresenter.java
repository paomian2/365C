package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.VoucherBean;
import com.a365vintagewine.mvp.view.VoucherFragmentView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  10:36
 * 版本：3.0
 */

public class VoucherFragmentPresenter extends BasePresenter<VoucherFragmentView,CmsContentModel>{


    public VoucherFragmentPresenter(VoucherFragmentView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**获取优惠券列表*/
    public void GetUserCouponList(Map<String,Object> params){
        mModel.GetUserCouponList(params, new ModelCallBack<List<VoucherBean>>() {
            @Override
            public void onSuccess(List<VoucherBean> model) {
                mView.GetUserCouponListResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetUserCouponListResult(false,msg,null);
            }
        });
    }
}
