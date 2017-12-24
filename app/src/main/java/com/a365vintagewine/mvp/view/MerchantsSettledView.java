package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

import java.util.Map;

/**
 * 申请开店
 */

public interface MerchantsSettledView extends BaseView {


    void ApplyShop();
    void ApplyShopResult(boolean success,String msg);

}
