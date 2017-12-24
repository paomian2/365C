package com.a365vintagewine.mvp.model.response;

import com.a365vintagewine.mvp.model.bean.PointBean;
import com.commsdk.module.response.base.BaseResponse;

import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  12:44
 * 版本：V1.0
 */
public class GetUserConsignorPointListResponse extends BaseResponse{


    private PointListData Data;

    public PointListData getData() {
        return Data;
    }

    public void setData(PointListData data) {
        Data = data;
    }

    public class PointListData{
        private int PageIndex;
        private int PageSize;
        private int TotalRecords;
        private int TotalPages;
        private List<PointBean> PagedData;

        public int getPageIndex() {
            return PageIndex;
        }

        public void setPageIndex(int pageIndex) {
            PageIndex = pageIndex;
        }

        public int getPageSize() {
            return PageSize;
        }

        public void setPageSize(int pageSize) {
            PageSize = pageSize;
        }

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            TotalRecords = totalRecords;
        }

        public int getTotalPages() {
            return TotalPages;
        }

        public void setTotalPages(int totalPages) {
            TotalPages = totalPages;
        }

        public List<PointBean> getPagedData() {
            return PagedData;
        }

        public void setPagedData(List<PointBean> pagedData) {
            PagedData = pagedData;
        }
    }
}
