package com.a365vintagewine.mvp.activity.personal;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.MyIntegralAdapter;
import com.a365vintagewine.mvp.model.bean.PointBean;
import com.a365vintagewine.mvp.model.response.GetUserPointResponse;
import com.a365vintagewine.mvp.presenter.MyIntegralPresenter;
import com.a365vintagewine.mvp.view.MyIntegralView;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.view.BaseMVPActivity;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.PagedLoader;
import java.util.HashMap;
import java.util.Map;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 描述：我的积分
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月22日  10:07
 * 版本：3.0
 */
public class MyIntegralActivity extends BaseMVPActivity<MyIntegralPresenter> implements
        MyIntegralView, SwipeRefreshLayout.OnRefreshListener, PagedLoader.OnLoadListener {

    /**
     * 返回控件
     */
    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    /**
     * 标题
     */
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    /**
     * 标题布局
     */
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    /**
     * 积分列表
     */
    @Bind(R.id.lv_shop_integral)
    ListView lvShopIntegral;
    /**
     * 列表刷新组件
     */
    @Bind(R.id.layoutRefresh)
    SwipeRefreshLayout layoutRefresh;
    /**
     * 空数据列表布局
     */
    @Bind(R.id.layoutDataEmpty)
    RelativeLayout layoutDataEmpty;
    /**
     * 分页加载组件
     */
    private PagedLoader pagedLoader;
    private int page = 1;
    private boolean refresh=true;


    private TextView tvMyIntegralSum; //我的总积分
    private ImageView imgPlatformIngegral; //平台头像
    private TextView tvPlatformSumIntegral;//平台总积分

    private MyIntegralAdapter adapter;
    /**平台数据*/
    private PointBean ptPointBean;

    @Override

    protected MyIntegralPresenter createPresenter() {
        return new MyIntegralPresenter(this);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_my_integral);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("我的积分");
        layoutRefresh.setOnRefreshListener(this);
        pagedLoader = PagedLoader.from(lvShopIntegral).setOnLoadListener(this).builder();
        adapter = new MyIntegralAdapter(activity);
        pagedLoader.setAdapter(adapter);
        View headerView = View.inflate(this, R.layout.header_my_integral, null);
        tvMyIntegralSum = (TextView) headerView.findViewById(R.id.tv_my_integral_sum);
        imgPlatformIngegral = (ImageView) headerView.findViewById(R.id.img_platform_ingegral);
        tvPlatformSumIntegral = (TextView) headerView.findViewById(R.id.tv_platform_sum_integral);
        LinearLayout llPlatformIntegral = (LinearLayout) headerView.findViewById(R.id.ll_platform_integral);
        lvShopIntegral.addHeaderView(headerView);
        lvShopIntegral.setAdapter(adapter);
        lvShopIntegral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    IntegralDetailActivity.launch(activity,adapter.getAdapterData().get(position));
                }
            }
        });
        llPlatformIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntegralDetailActivity.launch(activity,ptPointBean);
            }
        });
    }

    @Override
    protected void initData() {
        page = 1;
        layoutRefresh.setRefreshing(true);
        getUserPoint();
    }

    @Override
    public BaseActivity getMyContext() {
        return activity;
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void getUserPoint() {
        Map<String, Object> params = new HashMap<>();
        params.put("Client_Id", SharePreferenceUtils2.getClient_Id(activity));
        params.put("Page", page + "");
        params.put("Take", 20 + "");
        mvpPresenter.getMyIntegral(params);
    }

    @Override
    public void getUserPointResult(boolean success, GetUserPointResponse.DataBean dataBean, String msg) {
        layoutRefresh.setRefreshing(false);
        pagedLoader.setLoading(false);
        if(!success){
            showToast(msg);
        }
        if (refresh){
            //设置平台积分数据
            ptPointBean=dataBean.getPingTaiConsignorPoint().get(0);
            tvMyIntegralSum.setText(dataBean.getTotalPoint() + "");
            UIHelper.imageNet(activity, ptPointBean.getConsignorImg(), imgPlatformIngegral, false);
            tvPlatformSumIntegral.setText(ptPointBean.getPoint() + "");
            adapter.clearAdapter();
        }
        //设置商家积分数据
        if (success && dataBean.getConsignorPoint() != null && dataBean.getConsignorPoint().getPagedData() != null) {
            adapter.addAdapterData(dataBean.getConsignorPoint().getPagedData());
            page++;
        }
    }

    @Override
    public void onRefresh() {
        refresh = true;
        page = 1;
        getUserPoint();
    }

    @Override
    public void onLoading(PagedLoader pagedLoader, boolean isAutoLoad) {
        refresh = false;
        getUserPoint();
    }

    /**
     * 返回上级页面
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }


}
