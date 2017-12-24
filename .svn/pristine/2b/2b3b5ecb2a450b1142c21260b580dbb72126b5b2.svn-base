package com.a365vintagewine.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.commsdk.common.FileUtils;
import com.imagepicker.ImagePicker;
import com.imagepicker.data.ImagePickType;
import com.imagepicker.utils.GlideImagePickerDisplayer;



/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class ChoosePhotoPw extends PopupWindow{

    public static final int REQUEST_CODE_ALBUM = 100; //调用系统相册
    public static final int REQUEST_CODE_PHOTOGRAPH = 101; //调用系统相机
    TextView pwChoosePhotograph;
    TextView pwChooseAlbum;
    TextView pwChoosephotoCancle;
    private View conentView;
    private Activity context;

    public ChoosePhotoPw(final Activity context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.pw_choose_photograph, null);
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
        OnClicks();
    }

    private void OnClicks() {
        pwChoosePhotograph = (TextView) conentView.findViewById(R.id.pw_choose_photograph);
        pwChoosePhotograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimissPopuwindow();
                new ImagePicker()
                        .pickType(ImagePickType.ONLY_CAMERA) //设置选取类型(拍照ONLY_CAMERA、单选SINGLE、多选MUTIL)
                        .maxNum(9) //设置最大选择数量(此选项只对多选生效，拍照和单选都是1，修改后也无效)
                        .needCamera(true) //是否需要在界面中显示相机入口(类似微信那样)
                        .cachePath(FileUtils.getSDPATH()) //自定义缓存路径(拍照和裁剪都需要用到缓存)
                        //     .doCrop(1,1,300,300) //裁剪功能需要调用这个方法，多选模式下无效，参数：aspectX,aspectY,outputX,outputY
                        .displayer(new GlideImagePickerDisplayer()) //自定义图片加载器，默认是Glide实现的,可自定义图片加载器
                        .start(context, REQUEST_CODE_PHOTOGRAPH); //自定义RequestCode
            }
        });
        pwChooseAlbum = (TextView) conentView.findViewById(R.id.pw_choose_album);
        pwChooseAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimissPopuwindow();
                new ImagePicker()
                        .pickType(ImagePickType.SINGLE) //设置选取类型(拍照ONLY_CAMERA、单选SINGLE、多选MUTIL)
                        .maxNum(9) //设置最大选择数量(此选项只对多选生效，拍照和单选都是1，修改后也无效)
                        .needCamera(true) //是否需要在界面中显示相机入口(类似微信那样)
                        .cachePath(FileUtils.getSDPATH()) //自定义缓存路径(拍照和裁剪都需要用到缓存)
                        //     .doCrop(1,1,300,300) //裁剪功能需要调用这个方法，多选模式下无效，参数：aspectX,aspectY,outputX,outputY
                        .displayer(new GlideImagePickerDisplayer()) //自定义图片加载器，默认是Glide实现的,可自定义图片加载器
                        .start(context, REQUEST_CODE_ALBUM); //自定义RequestCode
            }
        });
        pwChoosephotoCancle = (TextView) conentView.findViewById(R.id.pw_choosephoto_cancle);
        pwChoosephotoCancle.setOnClickListener(new View.OnClickListener() {
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
}
