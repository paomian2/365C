package com.a365vintagewine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.commsdk.common.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月16日  10:51
 * 版本：3.0
 */

public abstract class BaseRecyViewAdapter<E> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public LayoutInflater inflater;
    public Context context;
    /**多种数据公用一个adapter，标识当前adapter是哪个数据的标志*/
    public String actionCode= StringUtils.EMPTY;

    public List<E> mlist=new ArrayList<>();


    public BaseRecyViewAdapter(Context context){
        this.context=context;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**添加列表数据*/
    public void addAdapterData(List<E> mlist){
        if(mlist!=null){
            this.mlist.addAll(mlist);
        }
        notifyDataSetChanged();
    }

    /**添加数组数据*/
    public void addAdapterData(E[] mlist){
        if(mlist!=null){
            Collections.addAll(this.mlist, mlist);
        }
        notifyDataSetChanged();
    }


    public void addAdapterData(List<E> mlist,String actionCode){
        if(mlist!=null){
            this.mlist.addAll(mlist);
            this.actionCode=actionCode;
        }
        notifyDataSetChanged();
    }

    /**数据从指定位置插入*/
    public void addAdapterData(int index,List<E> mlist){
        if(mlist!=null){
            this.mlist.addAll(index,mlist);
        }
        notifyDataSetChanged();
    }

    public void addAdapterData(int index, E mObject) {
        if (mlist != null) {
            this.mlist.add(index, mObject);
        }
        notifyDataSetChanged();
    }

    public void resetListAdapterData(List<?extends E> mlist){
        this.mlist.clear();
        this.mlist.addAll(mlist);
        notifyDataSetChanged();
    }

    /**与Activity中的list同步*/
    public void setMlist(List<E> mlist){
        this.mlist=mlist;
    }

    public void setMlist(List<E> mlist,String actionCode){
        this.mlist=mlist;
        this.actionCode=actionCode;
        notifyDataSetChanged();
    }

    public void addAdapterData(E e){
        if(mlist!=null){
            mlist.add(e);
        }
        notifyDataSetChanged();
    }

    public List<E> getMlist(){
        return  mlist;
    }

    public void removeAdapterData(E e){
        if(mlist!=null&&mlist.contains(e)){
            mlist.remove(e);
        }
        notifyDataSetChanged();
    }

    public void removeAdapterData(int position){
        if(mlist!=null&&mlist.size()>=position){
            mlist.remove(position);
        }
        notifyDataSetChanged();
    }


    public void clearAdapter(){
        if(mlist!=null){
            mlist.clear();
        }
        notifyDataSetChanged();
    }

    public int getAdapterSize(){
        if(mlist!=null){
            return mlist.size();
        }else{
            return 0;
        }
    }

    public List<E> getAdapterData(){
        return  mlist;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public E getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
