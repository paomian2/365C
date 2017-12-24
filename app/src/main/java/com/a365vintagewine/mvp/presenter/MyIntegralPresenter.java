package com.a365vintagewine.mvp.presenter;
import com.a365vintagewine.mvp.model.UserModel;
import com.a365vintagewine.mvp.model.response.GetUserPointResponse;
import com.a365vintagewine.mvp.view.MyIntegralView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import java.util.Map;

public class MyIntegralPresenter extends BasePresenter<MyIntegralView,UserModel> {
    public MyIntegralPresenter(MyIntegralView mView) {
        super(mView);
    }

    @Override
    public UserModel createModel() {
        return new UserModel();
    }

    /**
     * 获取积分列表
     */
    public void getMyIntegral(Map<String,Object> params){
         mModel.getUserPoint(params, new ModelCallBack<GetUserPointResponse.DataBean>() {
             @Override
             public void onSuccess(GetUserPointResponse.DataBean model) {
                  mView.getUserPointResult(true,model,"获取成功");
             }

             @Override
             public void onFailure(String msg) {
                 mView.getUserPointResult(false,null,msg);
             }
         });
    }
}
