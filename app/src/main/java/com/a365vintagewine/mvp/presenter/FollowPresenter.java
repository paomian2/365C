package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.response.GetFavoriteProductListResponse;
import com.a365vintagewine.mvp.view.FollowGoodsView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;
import java.util.Map;


public class FollowPresenter extends BasePresenter<FollowGoodsView,UserModel> {

    public FollowPresenter(FollowGoodsView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 获取关注的商品
     */
    public void getFollowGoods(Map<String,Object> params){
        mModel.getFavoriteProductList(params,new ModelCallBack<List<GetFavoriteProductListResponse.DataBean.PagedDataBean>>() {

            @Override
            public void onSuccess(List<GetFavoriteProductListResponse.DataBean.PagedDataBean> model) {
                mView.getFavoriteProductListResult(true,model,"获取成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.getFavoriteProductListResult(false,null,msg);
            }
        });
    }

    /**
     * 删除关注的商品
     */
    public void deleteGoods(Map<String,Object> params){
        mModel.delFavoriteProductList(params, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                mView.delFavoriteProductListResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.delFavoriteProductListResult(false,msg);
            }
        });
    }
}
