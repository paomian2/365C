package com.a365vintagewine.mvp.model.bean;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class MyTeam {
    private String name;
    private int num;
    private double price;
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MyTeam(String name, int num, double price, int sort) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.sort = sort;
    }

    public MyTeam() {
    }
}
