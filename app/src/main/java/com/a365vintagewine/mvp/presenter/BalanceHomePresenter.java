package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.BalanceBean;
import com.a365vintagewine.mvp.model.BalanceModel;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.view.BalanceHomeView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.google.gson.Gson;

import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  13:18
 * 版本：3.0
 */

public class BalanceHomePresenter extends BasePresenter<BalanceHomeView,CmsContentModel>{

    public BalanceHomePresenter(BalanceHomeView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    //获取用户余额
    public void GetUserBaseBalance(Map<String,Object> params){
        mModel.GetUserBaseBalance(params, new ModelCallBack<BalanceBean>() {
            @Override
            public void onSuccess(BalanceBean model) {
                mView.GetUserBaseBalanceResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetUserBaseBalanceResult(false,msg,null);
            }
        });
    }
}
