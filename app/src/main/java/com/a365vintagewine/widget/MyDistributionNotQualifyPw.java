package com.a365vintagewine.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.UserBean;
import com.a365vintagewine.mvp.model.bean.UserData;
import com.a365vintagewine.utils.SharePreferenceUtils2;
import com.commsdk.common.UIHelper;
import com.commsdk.common.sdk_qrqcoder.RQCoderHelper;
import com.commsdk.common.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyDistributionNotQualifyPw extends PopupWindow {

    private final View conentView;

    public MyDistributionNotQualifyPw(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.pw_my_distribution_not_qualify, null);
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
        this.setAnimationStyle(R.style.AnimationPreview);
//        this.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                final WindowManager.LayoutParams windowLP = context.getWindow().getAttributes();
//                windowLP.alpha = 1.0f;
//                context.getWindow().setAttributes(windowLP);
//            }
//        });
        //设置数据
        ViewHolder viewHolder=new ViewHolder(conentView);
        UserBean user = SharePreferenceUtils2.getBaseUser(context);
        UIHelper.imageNet(context,user.getUserHeadImgUrl(),viewHolder.imgMyHead,false,R.mipmap.myself_head_portrait);
        viewHolder.tvMyName.setText(user.getNickName());
        if ("1".equals(user.getFenXiaoState())){
            viewHolder.layoutFenxiaostate0.setVisibility(View.VISIBLE);
            viewHolder.layoutFenxiaostate1.setVisibility(View.GONE);
        }else{
            viewHolder.layoutFenxiaostate0.setVisibility(View.GONE);
            viewHolder.layoutFenxiaostate1.setVisibility(View.VISIBLE);
            RQCoderHelper.setRQCoderToImageView(context,viewHolder.imgRQCode,"http://hao123.com");
        }
        OnClicks();
    }

    private void OnClicks() {
        ImageView cancle = (ImageView) conentView.findViewById(R.id.img_canclePw);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimissPopuwindow();
            }
        });
    }

    /**
     * 隐藏popupWindow
     */
    public void dimissPopuwindow() {
        if (this.isShowing()) {
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
//            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }

    static class ViewHolder {
        @Bind(R.id.img_my_head)
        CircleImageView imgMyHead;
        @Bind(R.id.tv_my_name)
        TextView tvMyName;
        @Bind(R.id.layoutFenxiaostate0)
        LinearLayout layoutFenxiaostate0;
        @Bind(R.id.imgRQCode)
        ImageView imgRQCode;
        @Bind(R.id.tvInvitationCode)
        TextView tvInvitationCode;
        @Bind(R.id.layoutFenxiaostate1)
        RelativeLayout layoutFenxiaostate1;
        @Bind(R.id.img_canclePw)
        ImageView imgCanclePw;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
