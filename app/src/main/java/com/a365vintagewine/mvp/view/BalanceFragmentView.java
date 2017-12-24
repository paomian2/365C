package com.a365vintagewine.mvp.view;
import com.a365vintagewine.mvp.model.bean.BanlanceOrderBean;
import com.a365vintagewine.mvp.model.bean.ConsignorBalanceOrderBean;
import com.a365vintagewine.mvp.model.bean.StoreBean;
import com.a365vintagewine.mvp.model.bean.TeamUserBean;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  15:34
 * 版本：3.0
 */

public interface BalanceFragmentView extends BaseView{

    /**获取平台余额列表*/
    void GetPlatformUserBalance();
    /**获取平台余额列表结果*/
     void GetPlatformUserBalanceResult(boolean success, String msg,List<BanlanceOrderBean> list);
    /**获取充值余额列表*/
     void GetConsignorUserBalance();
    /**获取充值余额列表结果*/
     void GetConsignorUserBalanceResult(boolean success, String msg,List<ConsignorBalanceOrderBean> list);
}
