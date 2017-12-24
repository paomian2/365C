package com.a365vintagewine.mvp.model.response;

import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月28日  10:33
 * 版本：3.0
 */

public class GetFavoriteProductListResponse extends BaseResponse{

    /**
     * State : null
     * Dynamic : null
     * Msg : null
     * Data : {"PageIndex":1,"PageSize":5,"TotalRecords":82,"TotalPages":17,"PagedData":[{"Products_Id":172,"ProductCode":"PI3985","ProductName":"牛栏山二锅头 经典黄龙","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3985/黄龙二锅头.jpg","ProductType":null,"CreateDate":"2017/9/26 11:35:57"},{"Products_Id":3,"ProductCode":"PI3982","ProductName":"牛栏山百年红12年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3982/niulanshan12.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":4,"ProductCode":"PI3983","ProductName":"牛栏山百年红10年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3983/牛栏山10年.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":5,"ProductCode":"PI3984","ProductName":"牛栏山百年红8年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3984/牛栏山8年.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":7,"ProductCode":"PI3986","ProductName":"余力斯窖藏魅力赤霞珠3号红葡萄酒13.5度750ml","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3986/余力斯窖藏魅力赤霞珠3号.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"}]}
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
         * TotalRecords : 82
         * TotalPages : 17
         * PagedData : [{"Products_Id":172,"ProductCode":"PI3985","ProductName":"牛栏山二锅头 经典黄龙","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3985/黄龙二锅头.jpg","ProductType":null,"CreateDate":"2017/9/26 11:35:57"},{"Products_Id":3,"ProductCode":"PI3982","ProductName":"牛栏山百年红12年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3982/niulanshan12.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":4,"ProductCode":"PI3983","ProductName":"牛栏山百年红10年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3983/牛栏山10年.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":5,"ProductCode":"PI3984","ProductName":"牛栏山百年红8年","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3984/牛栏山8年.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"},{"Products_Id":7,"ProductCode":"PI3986","ProductName":"余力斯窖藏魅力赤霞珠3号红葡萄酒13.5度750ml","ProductPrice":null,"ProductImg":"/Upload/WebPic/ProductInfo/PI//PI3986/余力斯窖藏魅力赤霞珠3号.jpg","ProductType":null,"CreateDate":"2017/9/20 12:50:40"}]
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
             * Products_Id : 172
             * ProductCode : PI3985
             * ProductName : 牛栏山二锅头 经典黄龙
             * ProductPrice : null
             * ProductImg : /Upload/WebPic/ProductInfo/PI//PI3985/黄龙二锅头.jpg
             * ProductType : null
             * CreateDate : 2017/9/26 11:35:57
             */

            private int Products_Id;
            private String ProductCode;
            private String ProductName;
            private Object ProductPrice;
            private String ProductImg;
            private Object ProductType;
            private String CreateDate;

            public int getProducts_Id() {
                return Products_Id;
            }

            public void setProducts_Id(int Products_Id) {
                this.Products_Id = Products_Id;
            }

            public String getProductCode() {
                return ProductCode;
            }

            public void setProductCode(String ProductCode) {
                this.ProductCode = ProductCode;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public Object getProductPrice() {
                return ProductPrice;
            }

            public void setProductPrice(Object ProductPrice) {
                this.ProductPrice = ProductPrice;
            }

            public String getProductImg() {
                return ProductImg;
            }

            public void setProductImg(String ProductImg) {
                this.ProductImg = ProductImg;
            }

            public Object getProductType() {
                return ProductType;
            }

            public void setProductType(Object ProductType) {
                this.ProductType = ProductType;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }
        }
    }
}
