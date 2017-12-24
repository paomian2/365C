package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.VoucherCountBean;
import com.commsdk.base.view.BaseView;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  9:40
 * 版本：3.0
 */

public interface MyVoucherView extends BaseView{

    /**获取优惠券三种状态对于的数据*/
     void GetUserCouponNum();

    /**获取优惠券三种状态结果*/
     void GetUserCouponNumResult(boolean success, String msg,VoucherCountBean voucherCountBean);

}
