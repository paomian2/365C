package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.MyTeam;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class RankingListModel extends BaseModel2 {
    /**
     * 获取我的团队列表信息
     */
    public void getRankingList(ModelCallBack callBack){
        List<MyTeam> teamList = new ArrayList<>();
        teamList.add(new MyTeam("南瓜林",6,40,7));
        teamList.add(new MyTeam("樱桃小丸子",24,240,1));
        teamList.add(new MyTeam("凹凸曼先森",20,220,2));
        teamList.add(new MyTeam("凹凸曼先森女朋友",19,200,3));
        teamList.add(new MyTeam("杨先森",18,180,4));
        teamList.add(new MyTeam("李先森",10,120,5));
        teamList.add(new MyTeam("王先森",8,80,6));
        callBack.onSuccess(teamList);
    }
}
