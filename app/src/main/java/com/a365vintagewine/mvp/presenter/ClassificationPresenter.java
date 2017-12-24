package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.a365vintagewine.mvp.view.ClassificationView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;
import java.util.Map;

/**
 * 分类列表
 */

public class ClassificationPresenter extends BasePresenter<ClassificationView,CmsContentModel> {
    public ClassificationPresenter(ClassificationView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**分类首页*/
    public void Category(Map<String,Object> params){
        mModel.Category(params, new ModelCallBack<List<CategoryBean>>() {
            @Override
            public void onSuccess(List<CategoryBean> model) {
                mView.CategoryResult(true,"获取分类成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.CategoryResult(false,msg,null);
            }
        });
    }
}
