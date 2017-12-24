package com.a365vintagewine.mvp.view;

import com.a365vintagewine.mvp.model.bean.UserBean;
import com.commsdk.base.view.BaseView;

/**
 * 我的钱包
 */

public interface MyWalletView extends BaseView {

    void GetUserBasicInfo();
    void GetUserBasicInfoResult(boolean success, String msg, UserBean userBean);
}
