package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月27日  17:29
 * 版本：3.0
 */

public interface AdressEditView extends BaseView{
    /**添加收货地址*/
    public void addUserAddress(Map<String,Object> params);
    /**添加收货地址*/
    public void addUserAddressResult(boolean success,String msg);
    /**编辑地址*/
    public void editUserAddress(Map<String,Object> params);
    /**编辑地址结果回调*/
    public void editUserAddressResult(boolean success,String msg);
}
