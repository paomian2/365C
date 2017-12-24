package com.a365vintagewine.mvp.model.bean;

import com.commsdk.module.response.base.BaseResponse;

/**
 * 描述：短信验证码
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月12日  0:53
 * 版本：3.0
 */

public class VerifyCodeBean extends BaseResponse {


    /**
     * Result : true
     * State : null
     * Dynamic : null
     * Msg : null
     * Data : {"VerificationCode":"735169"}
     */


    private DataBean Data;


    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * VerificationCode : 735169
         */

        private String VerificationCode;

        public String getVerificationCode() {
            return VerificationCode;
        }

        public void setVerificationCode(String VerificationCode) {
            this.VerificationCode = VerificationCode;
        }
    }
}
