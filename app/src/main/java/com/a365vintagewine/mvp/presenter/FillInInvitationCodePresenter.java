package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.FillInInvitationCodeModel;
import com.a365vintagewine.mvp.view.FillInInvitationCodeView;
import com.commsdk.base.presenter.BasePresenter;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class FillInInvitationCodePresenter extends BasePresenter<FillInInvitationCodeView,FillInInvitationCodeModel> {
    public FillInInvitationCodePresenter(FillInInvitationCodeView mView) {
        super(mView);
    }

    @Override
    public FillInInvitationCodeModel createModel() {
        return new FillInInvitationCodeModel();
    }
}
