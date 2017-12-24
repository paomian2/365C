package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

/**
 * 描述：活动、Banner实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月11日  16:28
 * 版本：3.0
 */

public class BannerBean {

    private int Content_Id;
    private String Title= StringUtils.EMPTY;
    private String SubTitle= StringUtils.EMPTY;
    private String URLaddress= StringUtils.EMPTY;
    private String PicURL= StringUtils.EMPTY;

    public int getContent_Id() {
        return Content_Id;
    }

    public void setContent_Id(int Content_Id) {
        this.Content_Id = Content_Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String SubTitle) {
        this.SubTitle = SubTitle;
    }

    public String getURLaddress() {
        return URLaddress;
    }

    public void setURLaddress(String URLaddress) {
        this.URLaddress = URLaddress;
    }

    public String getPicURL() {
        return PicURL;
    }

    public void setPicURL(String PicURL) {
        this.PicURL = PicURL;
    }
}
