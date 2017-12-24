package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.PointBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  14:54
 * 版本：3.0
 */

public class GetUserPointResponse extends BaseResponse{

    public DataBean Data;

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean data) {
        Data = data;
    }

    public static class DataBean {
        /**
         * Client_Id : 1950
         * TotalPoint : 0
         * PingTaiConsignorPoint : [{"Consignor_Id":1,"ConsignorCode":"HZ150001","ConsignorName":"系统商家","ConsignorImg":"","ConsignorType":"平台","Point":0}]
         * ConsignorPoint : {"PageIndex":1,"PageSize":5,"TotalRecords":4,"TotalPages":1,"PagedData":[{"Consignor_Id":27,"ConsignorCode":"HZ160001","ConsignorName":"东城门店2","ConsignorImg":"","ConsignorType":"门店","Point":0},{"Consignor_Id":30,"ConsignorCode":"HZ20170002","ConsignorName":"东城门店1","ConsignorImg":"","ConsignorType":"门店","Point":0},{"Consignor_Id":73,"ConsignorCode":"HZ20170005","ConsignorName":"牛栏山","ConsignorImg":"","ConsignorType":"厂商","Point":0},{"Consignor_Id":75,"ConsignorCode":"HZ20170007","ConsignorName":"北京省公司","ConsignorImg":"","ConsignorType":"省公司","Point":0}]}
         */

        private int Client_Id;
        private int TotalPoint;
        /**商家积分*/
        private ConsignorPointBean ConsignorPoint;
        /**平台积分*/
        private List<PointBean> PingTaiConsignorPoint;

        public int getClient_Id() {
            return Client_Id;
        }

        public void setClient_Id(int Client_Id) {
            this.Client_Id = Client_Id;
        }

        public int getTotalPoint() {
            return TotalPoint;
        }

        public void setTotalPoint(int TotalPoint) {
            this.TotalPoint = TotalPoint;
        }

        public ConsignorPointBean getConsignorPoint() {
            return ConsignorPoint;
        }

        public void setConsignorPoint(ConsignorPointBean ConsignorPoint) {
            this.ConsignorPoint = ConsignorPoint;
        }

        public List<PointBean> getPingTaiConsignorPoint() {
            return PingTaiConsignorPoint;
        }

        public void setPingTaiConsignorPoint(List<PointBean> PingTaiConsignorPoint) {
            this.PingTaiConsignorPoint = PingTaiConsignorPoint;
        }

        public static class ConsignorPointBean {
            /**
             * PageIndex : 1
             * PageSize : 5
             * TotalRecords : 4
             * TotalPages : 1
             * PagedData : [{"Consignor_Id":27,"ConsignorCode":"HZ160001","ConsignorName":"东城门店2","ConsignorImg":"","ConsignorType":"门店","Point":0},{"Consignor_Id":30,"ConsignorCode":"HZ20170002","ConsignorName":"东城门店1","ConsignorImg":"","ConsignorType":"门店","Point":0},{"Consignor_Id":73,"ConsignorCode":"HZ20170005","ConsignorName":"牛栏山","ConsignorImg":"","ConsignorType":"厂商","Point":0},{"Consignor_Id":75,"ConsignorCode":"HZ20170007","ConsignorName":"北京省公司","ConsignorImg":"","ConsignorType":"省公司","Point":0}]
             */

            private int PageIndex;
            private int PageSize;
            private int TotalRecords;
            private int TotalPages;
            private List<PointBean> PagedData;

            public int getPageIndex() {
                return PageIndex;
            }

            public void setPageIndex(int PageIndex) {
                this.PageIndex = PageIndex;
            }

            public int getPageSize() {
                return PageSize;
            }

            public void setPageSize(int PageSize) {
                this.PageSize = PageSize;
            }

            public int getTotalRecords() {
                return TotalRecords;
            }

            public void setTotalRecords(int TotalRecords) {
                this.TotalRecords = TotalRecords;
            }

            public int getTotalPages() {
                return TotalPages;
            }

            public void setTotalPages(int TotalPages) {
                this.TotalPages = TotalPages;
            }

            public List<PointBean> getPagedData() {
                return PagedData;
            }

            public void setPagedData(List<PointBean> PagedData) {
                this.PagedData = PagedData;
            }

        }

    }
}
