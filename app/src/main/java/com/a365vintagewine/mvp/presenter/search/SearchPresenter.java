package com.a365vintagewine.mvp.presenter.search;
import com.a365vintagewine.mvp.model.CmsContentModel;
import com.a365vintagewine.mvp.model.response.GetHotSearchKeyResponse;
import com.a365vintagewine.mvp.view.search.SearchView;
import com.commsdk.base.presenter.BasePresenter;
import com.commsdk.base.retrofit.ModelCallBack;
import com.commsdk.common.SharedPreferenceUtil;
import com.commsdk.common.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter extends BasePresenter<SearchView,CmsContentModel> {


    public SearchPresenter(SearchView mView) {
        super(mView);
    }

    @Override
    public CmsContentModel createModel() {
        return new CmsContentModel();
    }

    /**
     * 获取热门搜索数据
     */
    public void getHotSearch(){
        mModel.GetHotSearchKey(new ModelCallBack<List<GetHotSearchKeyResponse.DataBean>>() {

            @Override
            public void onSuccess(List<GetHotSearchKeyResponse.DataBean> model) {
                mView.getHotsearchDataResult(true,"获取成功",model);
            }

            @Override
            public void onFailure(String msg) {
                mView.getHotsearchDataResult(false,msg,null);
            }
        });
    }

    /**
     * 获取搜索历史数据
     */
    public void getHistorySearch(){
        String searchContent=SharedPreferenceUtil.getInstance(mView.getMyContext()).getString(SharedPreferenceUtil.SEARCH_HISTORY);
        if (!StringUtils.isEmpty(searchContent)){
            List<String> searchList=new Gson().fromJson(searchContent,new TypeToken<ArrayList<String>>(){}.getType());
            if (searchList!=null && searchList.size()>0){
                 mView.getHistorySearchDataResult(searchList);
            }
        }
    }

    /**
     * 存储历史搜索数据
     */
    public void saveHistorySearch(String searchStr){
        if (!StringUtils.isEmpty(searchStr)){
            String searchContentOld=SharedPreferenceUtil.getInstance(mView.getMyContext()).getString(SharedPreferenceUtil.SEARCH_HISTORY);
            if(!StringUtils.isEmpty(searchContentOld)){
                List<String> searchList=new Gson().fromJson(searchContentOld,new TypeToken<ArrayList<String>>(){}.getType());
                if(searchList!=null && searchList.size()>0){
                    for(String string:searchList){
                        if (string.equals(searchStr)){
                            searchList.remove(searchStr);
                        }
                    }
                }
                searchList.add(0,searchStr);
                String searchContentNew=new Gson().toJson(searchList);
                SharedPreferenceUtil.getInstance(mView.getMyContext()).putString(SharedPreferenceUtil.SEARCH_HISTORY,searchContentNew);
            }else{
                List<String> newsWordList=new ArrayList<>();
                newsWordList.add(searchStr);
                String searchContentNew=new Gson().toJson(newsWordList);
                SharedPreferenceUtil.getInstance(mView.getMyContext()).putString(SharedPreferenceUtil.SEARCH_HISTORY,searchContentNew);
            }
        }
    }




    @Override
    public void detachView() {
        super.detachView();
    }
}
