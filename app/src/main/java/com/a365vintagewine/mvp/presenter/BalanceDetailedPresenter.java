package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.BalanceDetaileBean;
import com.a365vintagewine.mvp.model.BalanceModel;
import com.a365vintagewine.mvp.view.BalanceDetailedView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  19:25
 * 版本：3.0
 */

public class BalanceDetailedPresenter extends BasePresenter<BalanceDetailedView,BalanceModel>{

    public BalanceDetailedPresenter(BalanceDetailedView mView) {
        super(mView);
    }

    @Override
    public BalanceModel createModel() {
        return new BalanceModel();
    }

    /**获取余额列表数据*/
    public void getCustBalanceList(String custId,int page,int size){
       mModel.getCustBalanceList(custId, page, size, new ModelCallBack<List<BalanceDetaileBean>>() {
           @Override
           public void onSuccess(List<BalanceDetaileBean> model) {
               mView.onGetBalanceDetailedListResult(true,model);
           }

           @Override
           public void onFailure(String msg) {
               mView.onGetBalanceDetailedListResult(false,null);
           }
       });
    }
}
