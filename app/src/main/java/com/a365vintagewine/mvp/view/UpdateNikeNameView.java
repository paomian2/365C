package com.a365vintagewine.mvp.view;

import com.commsdk.base.view.BaseView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public interface UpdateNikeNameView extends BaseView{

    //修改用户昵称
    void updateNickName(String Client_Id,String Nickname);
    //修改用户昵称结果
    void updateNickNameResult(boolean success,String msg);
}
