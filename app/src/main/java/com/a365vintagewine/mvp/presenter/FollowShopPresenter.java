package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.response.GetFavoriteShopListReponse;
import com.a365vintagewine.mvp.view.FollowShopView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;
import java.util.Map;


public class FollowShopPresenter extends BasePresenter<FollowShopView,UserModel> {
    public FollowShopPresenter(FollowShopView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 获取我收藏的店铺信息
     */
    public void getFollowShop(Map<String,Object> params){
        mModel.getFavoriteShopList(params,new ModelCallBack<List<GetFavoriteShopListReponse.DataBean.PagedDataBean>>() {

            @Override
            public void onSuccess(List<GetFavoriteShopListReponse.DataBean.PagedDataBean> model) {
                mView.getFavoriteShopListResult(true,model,"获取成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.getFavoriteShopListResult(false,null,msg);
            }
        });
    }

    /**
     * 删除收藏的店铺
     */
    public void deleteShop(Map<String,Object> params){
        mModel.delFavoriteShopList(params, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.deleteShopResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.deleteShopResult(false,msg);
            }
        });
    }
}
