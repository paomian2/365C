package com.a365vintagewine.mvp.model.bean;

import com.commsdk.module.response.base.BaseResponse;

/**
 * 用户基本信息
 */

public class UserData extends BaseResponse{

    private UserBean Data;

    public UserBean getData() {
        return Data;
    }

    public void setData(UserBean data) {
        Data = data;
    }

}
