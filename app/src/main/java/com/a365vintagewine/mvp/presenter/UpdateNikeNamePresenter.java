package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.view.UpdateNikeNameView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.module.response.base.BaseResponse;

public class UpdateNikeNamePresenter extends BasePresenter<UpdateNikeNameView,UserModel> {
    public UpdateNikeNamePresenter(UpdateNikeNameView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**修改用户昵称*/
    public void updateNickName(String Client_Id,String Nickname){
        mModel.updateNickName(Client_Id, Nickname, new ModelCallBack<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse model) {
                 mView.updateNickNameResult(true,model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mView.updateNickNameResult(false,msg);
            }
        });
    }
}
