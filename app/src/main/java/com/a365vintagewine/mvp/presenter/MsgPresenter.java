package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.MsgModel;
import com.a365vintagewine.mvp.view.MsgView;
import com.commsdk.base.presenter.BasePresenter;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月12日  3:14
 * 版本：3.0
 */

public class MsgPresenter extends BasePresenter<MsgView,MsgModel>{

    public MsgPresenter(MsgView mView) {
        super(mView);
    }

    @Override
    public MsgModel createModel() {
        return new MsgModel();
    }
}
