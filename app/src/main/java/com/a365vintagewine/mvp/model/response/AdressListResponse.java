package com.a365vintagewine.mvp.model.response;
import com.a365vintagewine.mvp.model.bean.AdressBean;
import com.commsdk.module.response.base.BaseResponse;
import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月26日  12:16
 * 版本：3.0
 */

public class AdressListResponse extends BaseResponse {

    /**
     * Data : {"PageIndex":1,"PageSize":5,"TotalRecords":2,"TotalPages":1,"PagedData":[{"Client_Id":1952,"Address_Id":17,"Name":"林校章","Province_Id":1,"ProvinceName":"0","City_Id":3596,"CityName":"北京市","Region_Id":3596,"RegionName":"密云县","Street":"西统路","Address":"北京北京市密云县西统路","Mobile":"15810846124","IsDefaultAddress":1,"Longitude":0,"Latitude":0},{"Client_Id":1952,"Address_Id":16,"Name":"林校章","Province_Id":1,"ProvinceName":"0","City_Id":3596,"CityName":"北京市","Region_Id":3596,"RegionName":"密云县","Street":"西统路","Address":"北京北京市密云县西统路","Mobile":"15810846124","IsDefaultAddress":0,"Longitude":0,"Latitude":0}]}
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
         * TotalRecords : 2
         * TotalPages : 1
         * PagedData : [{"Client_Id":1952,"Address_Id":17,"Name":"林校章","Province_Id":1,"ProvinceName":"0","City_Id":3596,"CityName":"北京市","Region_Id":3596,"RegionName":"密云县","Street":"西统路","Address":"北京北京市密云县西统路","Mobile":"15810846124","IsDefaultAddress":1,"Longitude":0,"Latitude":0},{"Client_Id":1952,"Address_Id":16,"Name":"林校章","Province_Id":1,"ProvinceName":"0","City_Id":3596,"CityName":"北京市","Region_Id":3596,"RegionName":"密云县","Street":"西统路","Address":"北京北京市密云县西统路","Mobile":"15810846124","IsDefaultAddress":0,"Longitude":0,"Latitude":0}]
         */

        private int PageIndex;
        private int PageSize;
        private int TotalRecords;
        private int TotalPages;
        private List<AdressBean> PagedData;

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

        public List<AdressBean> getPagedData() {
            return PagedData;
        }

        public void setPagedData(List<AdressBean> PagedData) {
            this.PagedData = PagedData;
        }


    }
}
