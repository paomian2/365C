package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.VoucherCountBean;
import com.a365vintagewine.mvp.view.MyVoucherView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  9:42
 * 版本：3.0
 */

public class MyVoucherPresenter extends BasePresenter<MyVoucherView,CmsContentModel>{

    public MyVoucherPresenter(MyVoucherView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**获取优惠券三种状态的数据*/
    public void GetUserCouponNum(Map<String,Object> params){
        mModel.GetUserCouponNum(params,new ModelCallBack<VoucherCountBean>() {
            @Override
            public void onSuccess(VoucherCountBean model) {
                 mView.GetUserCouponNumResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
