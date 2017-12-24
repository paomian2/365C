package com.a365vintagewine.mvp.model;

import com.a365vintagewine.mvp.model.bean.BalanceBean;
import com.a365vintagewine.mvp.model.bean.BalanceDetaileBean;
import com.a365vintagewine.mvp.model.bean.StoreBean;
import com.a365vintagewine.mvp.model.bean.TeamUserBean;
import com.commsdk.base.retrofit.ModelCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月29日  13:18
 * 版本：3.0
 */

public class BalanceModel extends BaseModel2{



    /**获取平台余额列表*/
    public void getBalancePlatfromList(int page, int size, ModelCallBack<List<TeamUserBean>> modelCallBack){
        List<TeamUserBean> teamUserBeanList=new ArrayList<>();
        for (int i=0;i<5;i++){
            TeamUserBean teamUserBean=new TeamUserBean();
            if(i==0){
                teamUserBean.setUserId("1001");
                teamUserBean.setUserName("樱桃小丸子");
                teamUserBean.setUserHeadUrl("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1503997629&di=72e380c8bcffdfbf6ea9397af0dc9ea7&src=http://img.mp.itc.cn/upload/20160613/8a093d55771147708503db726cc0407d_th.jpg");
                teamUserBean.setBalanceDesc("分佣");
                teamUserBean.setBalancePrice("+12");
                teamUserBean.setTime("07-12");
            }else if(i==1){
                teamUserBean.setUserId("1002");
                teamUserBean.setUserName("张祎博");
                teamUserBean.setUserHeadUrl("http://img5.imgtn.bdimg.com/it/u=3551563550,2594280103&fm=26&gp=0.jpg");
                teamUserBean.setBalanceDesc("分佣");
                teamUserBean.setBalancePrice("+12");
                teamUserBean.setTime("07-12");
            }else if (i==2){
                teamUserBean.setUserId("1003");
                teamUserBean.setUserName("刘嘉华");
                teamUserBean.setUserHeadUrl("http://img1.imgtn.bdimg.com/it/u=2806246229,1795628784&fm=26&gp=0.jpg");
                teamUserBean.setBalanceDesc("分佣");
                teamUserBean.setBalancePrice("+12");
                teamUserBean.setTime("07-12");
            }else if (i==3){
                teamUserBean.setUserId("1004");
                teamUserBean.setUserName("streamlet");
                teamUserBean.setUserHeadUrl("http://img1.imgtn.bdimg.com/it/u=1164532359,1691253195&fm=214&gp=0.jpg");
                teamUserBean.setBalanceDesc("分佣");
                teamUserBean.setBalancePrice("+24");
                teamUserBean.setTime("08-30");
            }else{
                teamUserBean.setUserId("1005");
                teamUserBean.setUserName("李明磊");
                teamUserBean.setUserHeadUrl("http://img0.imgtn.bdimg.com/it/u=356577683,2191207399&fm=26&gp=0.jpg");
                teamUserBean.setBalanceDesc("分佣");
                teamUserBean.setBalancePrice("+24");
                teamUserBean.setTime("09-01");
            }
            teamUserBeanList.add(teamUserBean);
        }
        modelCallBack.onSuccess(teamUserBeanList);
    }

    /**获取充值余额*/
    public void getBalanceRechargeList(int page, int size, ModelCallBack<List<StoreBean>> modelCallBack){
        List<StoreBean> storeBeanList=new ArrayList<>();
        for (int i=0;i<5;i++){
            StoreBean storeBean=new StoreBean();
            if(i==0){
                storeBean.setCustId("1003");
                storeBean.setCustImg("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1764940613,1711033350&fm=26&gp=0.jpg");
                storeBean.setCustName("365直营店");
                storeBean.setBanlancePrice("¥200");
            }else if(i==2){
                storeBean.setCustId("1002");
                storeBean.setCustImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504034004542&di=7327956fd3592e851bc2c584f390d550&imgtype=0&src=http%3A%2F%2Fcpic2.edushi.com%2Fcn%2Fhz%2Fzh-chs%2FLocalInfo%2FCompanys%2F284594%2FWindows%2FPhoto20100608174406.JPG");
                storeBean.setCustName("海天烟酒店");
                storeBean.setBanlancePrice("¥200");
            }else if (i==3){
                storeBean.setCustId("1001");
                storeBean.setCustImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504011825823&di=51d4cf90f2f3a84558b40155822699dc&imgtype=0&src=http%3A%2F%2Fwww.jianiang.cn%2Fuploads%2F150721%2F8495-150H1141I13X.jpg");
                storeBean.setCustName("自在烟酒店");
                storeBean.setBanlancePrice("¥188");
            }else{
                storeBean.setCustId("1001");
                storeBean.setCustImg("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1764940613,1711033350&fm=26&gp=0.jpg");
                storeBean.setCustName("明磊红酒专卖店");
                storeBean.setBanlancePrice("¥100");
            }
            storeBeanList.add(storeBean);
        }
        modelCallBack.onSuccess(storeBeanList);
    }

    /**获取具体商家的余额明细列表*/
    public void getCustBalanceList(String custid, int page, int size, ModelCallBack<List<BalanceDetaileBean>> callBack){
        List<BalanceDetaileBean> balanceDetaileBeanList=new ArrayList<>();
        for (int i=0;i<5;i++){
            BalanceDetaileBean balanceDetaileBean=new BalanceDetaileBean();
            balanceDetaileBean.setOrderId("20170829011102");
            balanceDetaileBean.setBalanceType("消费");
            balanceDetaileBean.setBalancePrice("-100");
            balanceDetaileBeanList.add(balanceDetaileBean);
        }
        callBack.onSuccess(balanceDetaileBeanList);
    }
}
