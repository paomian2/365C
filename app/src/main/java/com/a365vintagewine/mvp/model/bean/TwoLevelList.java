package com.a365vintagewine.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class TwoLevelList {
    private String twoLevelImgUrl;
    private List<ThreeLevelList> threeLevelLists;

    public String getTwoLevelImgUrl() {
        return twoLevelImgUrl;
    }

    public void setTwoLevelImgUrl(String twoLevelImgUrl) {
        this.twoLevelImgUrl = twoLevelImgUrl;
    }

    public List<ThreeLevelList> getThreeLevelLists() {
        return threeLevelLists;
    }

    public void setThreeLevelLists(List<ThreeLevelList> threeLevelLists) {
        this.threeLevelLists = threeLevelLists;
    }
}
