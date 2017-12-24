package com.a365vintagewine.mvp.presenter;

import com.a365vintagewine.mvp.model.TokenModel;
import com.a365vintagewine.mvp.model.bean.SignKey;
import com.a365vintagewine.mvp.view.LaunchView;
import com.commsdk.base.model.BaseModel;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年07月24日  15:27
 * 版本：3.0
 */

public class LaunchPresenter extends BasePresenter<LaunchView,TokenModel> {

    String guide;
    public LaunchPresenter(LaunchView mView) {
        super(mView);
    }

    @Override
    public TokenModel createModel() {
        return new TokenModel();
    }

    /**获取signKey*/
    public void getSignKey(){
        mModel.getSignKey(new ModelCallBack<SignKey>() {
            @Override
            public void onSuccess(SignKey model) {
                mView.getSignKeyResult(true,"获取成功");
            }

            @Override
            public void onFailure(String msg) {
                mView.getSignKeyResult(false,msg);
            }
        });
    }

    public void checkUserInfo(){
        guide = SharedPreferenceUtil.getInstance(mView.getMyContext()).getString(SharedPreferenceUtil.GUIDE);
        if (isGuide()){
           mView.activityStart(mView.GUIDE);
        }else{
            //判断本地是否有用户数据
            if (!StringUtils.isEmpty(SharedPreferenceUtil.getInstance(mView.getMyContext()).getString(SharedPreferenceUtil.USERINFO))){
                 mView.activityStart(mView.HOME);
            }else{
                mView.activityStart(mView.LOGIN);
            }
        }
    }

    boolean isGuide() {
        if ("".equals(guide)) {
            return true;
        }
        return false;
    }
}
