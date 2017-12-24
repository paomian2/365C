package com.a365vintagewine.mvp.model;
import com.a365vintagewine.mvp.model.bean.VoucherBean;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.TimeUtil;
import java.util.ArrayList;
import java.util.List;
/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  9:43
 * 版本：3.0
 */

public class MyVoucherModel extends BaseModel2{

    /**获取优惠券三种状态的数据*/
    public void getVoucherCount(ModelCallBack modelCallBack){
        modelCallBack.onSuccess(null);
    }

    /**根据优惠券状态获取优惠券列表*/

}
