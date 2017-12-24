package com.a365vintagewine.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a365vintagewine.mvp.fragment.ProTypeFragment;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.google.gson.Gson;

import java.util.List;

/**
 * 二级分类
 */

public class ClassificationVPAdapter  extends FragmentPagerAdapter {
    private List<CategoryBean> list;
    public ClassificationVPAdapter(FragmentManager fm,List<CategoryBean> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int index) {
        String categoryJson=new Gson().toJson(list);
        Fragment fragment = new ProTypeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        bundle.putString("categoryBeanList", categoryJson);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
