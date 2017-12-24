package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class GoodsEvaluate {
    private String headImaUrl;
    private String name;
    private String evaluateContent;
    private String evaluateTime;
    private int evaluateType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImaUrl() {
        return headImaUrl;
    }

    public void setHeadImaUrl(String headImaUrl) {
        this.headImaUrl = headImaUrl;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public int getEvaluateType() {
        return evaluateType;
    }

    public void setEvaluateType(int evaluateType) {
        this.evaluateType = evaluateType;
    }
}
