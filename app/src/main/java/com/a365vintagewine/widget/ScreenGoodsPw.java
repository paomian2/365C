package com.a365vintagewine.widget;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.DeliveryAdapter;
import com.a365vintagewine.adapter.ScreenBrandAdapter;
import com.a365vintagewine.mvp.model.bean.BranchBen;
import com.a365vintagewine.mvp.model.bean.DeliveryBean;
import com.a365vintagewine.mvp.model.bean.FacetsBean;
import com.a365vintagewine.mvp.model.bean.KeyValBean;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 搜索筛选
 */

public class ScreenGoodsPw extends PopupWindow{


    private List<BranchBen> brandList = new ArrayList<>(); //记录选择的品牌
    private List<DeliveryBean> deliveryBeanList=new ArrayList<>();//配送方式
    private Activity context;
    private ViewHolderScreen viewHolder;
    private ScreenBrandAdapter screenBrandAdapter;
    private DeliveryAdapter deliveryAdapter;
    //点击确定回调
    private CallbackSreenGoods callbackSreenGoods;


    public void setCallbackScreenGoods(CallbackSreenGoods callbackScreenGoods) {
        this.callbackSreenGoods = callbackScreenGoods;
    }


    public ScreenGoodsPw(final Activity context,FacetsBean facetsBean) {
        this.context = context;
        //设置配送方式
        if (facetsBean!=null && facetsBean.getDelivryName()!=null){
            deliveryBeanList.clear();
            for (KeyValBean keyValBean:facetsBean.getDelivryName()){
                DeliveryBean deliveryBean=new DeliveryBean();
                deliveryBean.setId(keyValBean.getKey());
                deliveryBean.setName(keyValBean.getValue());
                deliveryBeanList.add(deliveryBean);
            }
        }
        //设置品牌
        if (facetsBean!=null && facetsBean.getBranchName()!=null){
            brandList.clear();
            for (KeyValBean keyValBean:facetsBean.getBranchName()){
                BranchBen branchBen=new BranchBen();
                branchBen.setBrand_Id(Integer.parseInt(keyValBean.getKey()));
                branchBen.setBrandNameCn(keyValBean.getValue());
                brandList.add(branchBen);
            }

        }
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = layoutInflater.inflate(R.layout.pw_screen_goods, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(h);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为白色
//        ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.white));
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
//        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreviewLeft);
        viewHolder = new ViewHolderScreen(conentView);
        setAdapter(brandList,deliveryBeanList);
        OnClicks();
    }

    public void setAdapter(List<BranchBen> brandList,List<DeliveryBean> deliveryBeanList) {
        deliveryAdapter=new DeliveryAdapter(context);
        deliveryAdapter.setMlist(deliveryBeanList);
        viewHolder.gvDelivery.setAdapter(deliveryAdapter);
        viewHolder.gvDelivery.setOnItemClickListener(mDeliveryClickListener);
        //品牌
        screenBrandAdapter = new ScreenBrandAdapter(context);
        screenBrandAdapter.setMlist(brandList);
        viewHolder.gvScreenBrand.setAdapter(screenBrandAdapter);
    }

    private void OnClicks() {
        //重置按钮监听
        viewHolder.btnScreenReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (DeliveryBean deliveryBean:deliveryBeanList){
                    deliveryBean.setSelect(false);
                }
                deliveryAdapter.notifyDataSetChanged();
                viewHolder.etScreenEndPrice.setText("");
                viewHolder.etScreenStartPrice.setText("");
                for (BranchBen branchBen:screenBrandAdapter.getAdapterData()){
                    branchBen.setSelect(false);
                }
                screenBrandAdapter.notifyDataSetChanged();

            }
        });

        //点击确定按钮回调
        viewHolder.btnScreenConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackSreenGoods != null) {
                    String startPrice = (viewHolder.etScreenStartPrice.getText().toString().trim());
                    String endPrice = viewHolder.etScreenEndPrice.getText().toString().trim();
                    callbackSreenGoods.setSreenGoods(deliveryBeanList, startPrice, endPrice, brandList);
                }
                dimissPopuwindow();
            }
        });
        viewHolder.llScreenGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimissPopuwindow();
            }
        });
    }


    /**
     * 隐藏popupWindow
     */
    private void dimissPopuwindow() {
        if (this.isShowing()) {
            this.dismiss();
        }
    }

    /**
     * 显示popupWindow
     *
     * @param parent:显示在指定的控件下
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
//            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }



    /**配送方式选择*/
    private AdapterView.OnItemClickListener mDeliveryClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (DeliveryBean deliveryBean:deliveryBeanList){
                deliveryBean.setSelect(false);
            }
            deliveryBeanList.get(position).setSelect(true);
            deliveryAdapter.notifyDataSetChanged();
        }
    };


    public interface CallbackSreenGoods {
        void setSreenGoods(List<DeliveryBean> deliveryBeanList, String startPrice, String endPrice, List<BranchBen> brandName);
    }


    static class ViewHolderScreen {
        @Bind(R.id.gvDelivery)
        NoScrollGridView gvDelivery;
        @Bind(R.id.et_screen_start_price)
        EditText etScreenStartPrice;
        @Bind(R.id.et_screen_end_price)
        EditText etScreenEndPrice;
        @Bind(R.id.gv_screen_brand)
        GridView gvScreenBrand;
        @Bind(R.id.btn_screen_reset)
        Button btnScreenReset;
        @Bind(R.id.btn_screen_confirm)
        Button btnScreenConfirm;
        @Bind(R.id.ll_screen_goods)
        LinearLayout llScreenGoods;

        ViewHolderScreen(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
