package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class ThreeLevelList {
    private String TwoLevelname;
    private List<Brand> brandList;

    public String getTwoLevelname() {
        return TwoLevelname;
    }

    public void setTwoLevelname(String twoLevelname) {
        TwoLevelname = twoLevelname;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
