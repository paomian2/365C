package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：签名秘钥
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月27日  14:24
 * 版本：3.0
 */

public class SignKey {

    /**
     * SignKey_Token : 3jv91D9Jxg54FGnv
     * SignKey_TokenValidTimeStamp : 1514649600
     * SignKey_TokenValidDate : 2017/12/31 0:00:00
     */

    private String SignKey_Token= StringUtils.EMPTY;
    private String SignKey_TokenValidTimeStamp=StringUtils.EMPTY;
    private String SignKey_TokenValidDate=StringUtils.EMPTY;

    public String getSignKey_Token() {
        return SignKey_Token;
    }

    public void setSignKey_Token(String SignKey_Token) {
        this.SignKey_Token = SignKey_Token;
    }

    public String getSignKey_TokenValidTimeStamp() {
        return SignKey_TokenValidTimeStamp;
    }

    public void setSignKey_TokenValidTimeStamp(String SignKey_TokenValidTimeStamp) {
        this.SignKey_TokenValidTimeStamp = SignKey_TokenValidTimeStamp;
    }

    public String getSignKey_TokenValidDate() {
        return SignKey_TokenValidDate;
    }

    public void setSignKey_TokenValidDate(String SignKey_TokenValidDate) {
        this.SignKey_TokenValidDate = SignKey_TokenValidDate;
    }
}
