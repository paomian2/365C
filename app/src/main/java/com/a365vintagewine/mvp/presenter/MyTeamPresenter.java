package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.a365vintagewine.mvp.model.MyteamModel;
import com.a365vintagewine.mvp.view.MyTeamView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class MyTeamPresenter extends BasePresenter<MyTeamView,MyteamModel> {
    public MyTeamPresenter(MyTeamView mView) {
        super(mView);
    }

    @Override
    public MyteamModel createModel() {
        return new MyteamModel();
    }

    /**
     * 获取我的团队列表信息
     */
    public void getMyTeamList(){
        mModel.getMyTeamList(new ModelCallBack<List<MyTeam>>() {

            @Override
            public void onSuccess(List<MyTeam> model) {
                mView.setMyTeamAdapter(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
