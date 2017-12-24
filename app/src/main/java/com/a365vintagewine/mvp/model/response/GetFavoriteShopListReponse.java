package com.a365vintagewine.mvp.model.response;

import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  14:10
 * 版本：3.0
 */

public class GetFavoriteShopListReponse extends BaseResponse{

    /**
     * Result : true
     * State : null
     * Dynamic : null
     * Msg : null
     * Data : {"PageIndex":1,"PageSize":5,"TotalRecords":3,"TotalPages":1,"PagedData":[{"Shops_Id":269,"Consignor_Id":1,"ConsignorShop_Name":"365管理平台","Consignor_Start":"0","Consignor_Img":""},{"Shops_Id":266,"Consignor_Id":27,"ConsignorShop_Name":"东城门店2","Consignor_Start":"0","Consignor_Img":""},{"Shops_Id":267,"Consignor_Id":30,"ConsignorShop_Name":"东城门店1","Consignor_Start":"0","Consignor_Img":""}]}
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
         * PageIndex : 1
         * PageSize : 5
         * TotalRecords : 3
         * TotalPages : 1
         * PagedData : [{"Shops_Id":269,"Consignor_Id":1,"ConsignorShop_Name":"365管理平台","Consignor_Start":"0","Consignor_Img":""},{"Shops_Id":266,"Consignor_Id":27,"ConsignorShop_Name":"东城门店2","Consignor_Start":"0","Consignor_Img":""},{"Shops_Id":267,"Consignor_Id":30,"ConsignorShop_Name":"东城门店1","Consignor_Start":"0","Consignor_Img":""}]
         */

        private int PageIndex;
        private int PageSize;
        private int TotalRecords;
        private int TotalPages;
        private List<PagedDataBean> PagedData;

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

        public List<PagedDataBean> getPagedData() {
            return PagedData;
        }

        public void setPagedData(List<PagedDataBean> PagedData) {
            this.PagedData = PagedData;
        }

        public static class PagedDataBean {
            /**
             * Shops_Id : 269
             * Consignor_Id : 1
             * ConsignorShop_Name : 365管理平台
             * Consignor_Start : 0
             * Consignor_Img :
             */

            private int Shops_Id;
            private int Consignor_Id;
            private String ConsignorShop_Name;
            private String Consignor_Start;
            private String Consignor_Img;

            public int getShops_Id() {
                return Shops_Id;
            }

            public void setShops_Id(int Shops_Id) {
                this.Shops_Id = Shops_Id;
            }

            public int getConsignor_Id() {
                return Consignor_Id;
            }

            public void setConsignor_Id(int Consignor_Id) {
                this.Consignor_Id = Consignor_Id;
            }

            public String getConsignorShop_Name() {
                return ConsignorShop_Name;
            }

            public void setConsignorShop_Name(String ConsignorShop_Name) {
                this.ConsignorShop_Name = ConsignorShop_Name;
            }

            public String getConsignor_Start() {
                return Consignor_Start;
            }

            public void setConsignor_Start(String Consignor_Start) {
                this.Consignor_Start = Consignor_Start;
            }

            public String getConsignor_Img() {
                return Consignor_Img;
            }

            public void setConsignor_Img(String Consignor_Img) {
                this.Consignor_Img = Consignor_Img;
            }
        }
    }
}
