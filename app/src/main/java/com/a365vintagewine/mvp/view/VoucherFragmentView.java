package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.VoucherBean;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  10:26
 * 版本：3.0
 */

public interface VoucherFragmentView extends BaseView{

    /**获取优惠券列表*/
     void GetUserCouponList();
    /**优惠券获列表获取结果*/
     void GetUserCouponListResult(boolean success, String msg,List<VoucherBean> list);
}
