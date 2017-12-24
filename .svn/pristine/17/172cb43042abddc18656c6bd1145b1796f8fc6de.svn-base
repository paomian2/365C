package com.a365vintagewine.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.common.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class MsgSharePw extends PopupWindow {

    private ViewHolder viewHolder;
    private Activity context;

    public MsgSharePw(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.pw_msg_share, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w/5);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(h/4);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        viewHolder = new ViewHolder(conentView);
        OnClicks();
    }

    private void OnClicks() {
        //消息点击
        viewHolder.tvPwMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(context,"消息");
                dimissPopuwindow();
            }
        });

        //客服点击
        viewHolder.tvPwCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(context,"客服");
                dimissPopuwindow();
            }
        });

        //分享点击
        viewHolder.tvPwCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(context,"分享");
                dimissPopuwindow();
            }
        });
    }

    /**
     * 隐藏popupWindow
     */
    public void dimissPopuwindow(){
        if (this.isShowing()){
            this.dismiss();
        }
    }
    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }


    static class ViewHolder {
        @Bind(R.id.tv_pw_msg)
        TextView tvPwMsg;
        @Bind(R.id.tv_pw_customer_service)
        TextView tvPwCustomerService;
        @Bind(R.id.tv_pw_share)
        TextView tvPwShare;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
