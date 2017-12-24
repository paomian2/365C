package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.commsdk.base.view.BaseView;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  2:43
 * 版本：3.0
 */

public interface AdressHomeView extends BaseView{

    /**地址列表获取*/
    public void getAdressList();
    /**地址列表获取结果*/
    public void onGetAdressListResult(boolean success, List<AdressBean> adressBeanList,String msg);
    /**删除地址*/
    public void deleteAdressRecord(Map<String,Object> params);
    /**删除指定地址结果*/
    public void onDeleteAdressRecordResult(boolean success,String msg);

}
