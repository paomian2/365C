package com.commsdk.base.view;

import android.content.Context;

import com.commsdk.base.BaseActivity;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月12日  21:08
 * 版本：3.0
 */

public interface BaseView {

    public BaseActivity getMyContext();

    void showProgress(String msg);

    void hideProgress();
}
