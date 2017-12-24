package com.a365vintagewine.mvp.view;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.commsdk.base.view.BaseView;

import java.util.List;

/**
 * 分类首页
 */

public interface ClassificationView extends BaseView {

    /**分类首页*/
    void Category();
    /**分类首页结果回调*/
    void CategoryResult(boolean success, String msg, List<CategoryBean> list);

}
