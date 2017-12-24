package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.BanlanceOrderBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBalanceOrderBean;
import com.a365vintagewine.mvp.model.bean.StoreBean;
import com.a365vintagewine.mvp.model.bean.TeamUserBean;
import com.a365vintagewine.mvp.model.BalanceModel;
import com.a365vintagewine.mvp.view.BalanceFragmentView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  17:01
 * 版本：3.0
 */

public class BalanceFragmentPresenter extends BasePresenter<BalanceFragmentView,CmsContentModel>{

    public BalanceFragmentPresenter(BalanceFragmentView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**获取平台余额列表*/
    public void GetPlatformUserBalance(Map<String,Object> params){
        mModel.GetPlatformUserBalance(params, new ModelCallBack<List<BanlanceOrderBean>>() {
            @Override
            public void onSuccess(List<BanlanceOrderBean> model) {
                mView.GetPlatformUserBalanceResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetConsignorUserBalanceResult(false,msg,null);
            }
        });
    }


    /**获取充值余额列表*/
    public void GetConsignorUserBalance(Map<String,Object> params){
        mModel.GetPlatformUserBalance(params, new ModelCallBack<List<ConsignorBalanceOrderBean>>() {
            @Override
            public void onSuccess(List<ConsignorBalanceOrderBean> model) {
                mView.GetConsignorUserBalanceResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.GetConsignorUserBalanceResult(false,msg,null);
            }
        });

    }
}
