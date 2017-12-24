package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.BalanceBean;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.commsdk.base.view.BaseView;

/**
 * 描述：余额
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  13:08
 * 版本：3.0
 */

public interface BalanceHomeView extends BaseView{

    //获取用户余额
    void GetUserBaseBalance();
    //获取用户信息结果
    void GetUserBaseBalanceResult(boolean success,String msg,BalanceBean balanceBean);

}
