package com.a365vintagewine.mvp.model.response;

import com.commsdk.common.StringUtils;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月09日  10:56
 * 版本：3.0
 */

public class GetHotSearchKeyResponse extends BaseResponse{


    /**
     * State : null
     * Dynamic : null
     * Msg : null
     * Data : [{"Content_Id":28,"Title":"牛栏山标题","SubTitle":null,"URLaddress":null,"PicURL":null}]
     */

    private List<DataBean> Data;

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Content_Id : 28
         * Title : 牛栏山标题
         * SubTitle : null
         * URLaddress : null
         * PicURL : null
         */

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

        public Object getSubTitle() {
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
}
