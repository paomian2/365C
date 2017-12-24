package com.commsdk.common;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.commsdk.BuildConfig;
import com.commsdk.R;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.Config;
import com.commsdk.common.widget.CustomProgressDialog;
import com.commsdk.common.widget.ProgressWheel;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class UIHelper {

    public static final int ACT_TRAN_HEAD = 43;

    public static UIHelper getInstance() {
        return new UIHelper();
    }

    /**
     * 获取屏幕分辨率：宽
     *
     * @param context
     * @return
     */
    public static int getScreenPixWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        if (!(context instanceof Activity)) {
            dm = context.getResources().getDisplayMetrics();
            return dm.widthPixels;
        }

        WindowManager wm = ((Activity) context).getWindowManager();
        if (wm == null) {
            dm = context.getResources().getDisplayMetrics();
            return dm.widthPixels;
        }

        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕分辨率：高
     *
     * @param context
     * @return
     */
    public static int getScreenPixHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        if (!(context instanceof Activity)) {
            dm = context.getResources().getDisplayMetrics();
            return dm.heightPixels;
        }

        WindowManager wm = ((Activity) context).getWindowManager();
        if (wm == null) {
            dm = context.getResources().getDisplayMetrics();
            return dm.heightPixels;
        }

        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;

    }


    /**
     * 默认时间LENGTH_SHORT
     *
     * @param msg
     */
    public static void showToast(Context context, Toast toast, String msg) {
        showToast(context, toast, msg, Toast.LENGTH_SHORT);
    }

    /***
     * @param msg
     * @param length 显示时间
     */
    public static void showToast(Context context, Toast toast, String msg, int length) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, length);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 获取当前手机的独立像素
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * dp2px
     */
    public static int dip2px(Context context,float dipValue) {
        return (int) (dipValue * getDensity(context) + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dip(Context context,float pxValue) {
        return (int) (pxValue / getDensity(context) + 0.5f);
    }


    // 获取当前版本号
    public static int getVersionCode(Context context) {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo;
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int versionCode = packInfo.versionCode;
            return versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 获取当前版本号
    public static String getVersionName(Context context) {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo;
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String versionName = packInfo.versionName;
            return versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /********************************************
     * 滚动条对话框
     ***********************************************/

    public static CustomProgressDialog dialog;

    public static Dialog showProgressDialog(Context context, String message) {
        try {
            if (dialog != null) {
                dialog.cancel();
                dialog = null;
            }
            dialog = CustomProgressDialog.createDialog(context);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setMessage(message);
            dialog.show();
            return dialog;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static Dialog showProgressDialog(Context context) {
        return showProgressDialog(context, null);
    }

    // 去掉进度条
    public static void cancleProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog.cancel();
        }
    }

    /**
     /* * 滑动选择
     */
    private static String wheelTemp = "";
    private static int mposition = 0;

    public static Map<String, Object> convertBeanToMap(Object bean) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = bean.getClass().getDeclaredFields();
        HashMap<String, Object> data = new HashMap<String, Object>();
        for (Field field : fields) {
            field.setAccessible(true);
            data.put(field.getName(), field.get(bean));
        }
        return data;
    }

    public static void openBrowser(Context context, String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        LogUtil.d("down", "" + url);
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        context.startActivity(intent);
    }

    public static void cancleAllNotification(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancelAll();
    }

    public interface OnDialogClickListener {
        public void onClick();
    }

    /**带文本数据返回的Dialog右键监听*/
    public interface OnDialogClickForResultListener{
        public void onClick(String msg);
    }

    /**
     * 有两个按钮的对话框
     */
    public static Dialog showTowButtonDialog(Context context, String title, String message, String btn_right, String btn_left,
                                             final OnDialogClickListener rightListener, final OnDialogClickListener leftListener) {
        try {
            final Dialog dialog = new Dialog(context, R.style.CustomDialog);
            View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_tow_button, null);
            TextView tvTitle = (TextView) contentView.findViewById(R.id.tv_title);
            TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_msg);
            TextView btn1 = (TextView) contentView.findViewById(R.id.btn1);
            TextView btn2 = (TextView) contentView.findViewById(R.id.btn2);
            tvTitle.setText(title);
            tvMsg.setText(message);
            btn1.setText(btn_right);
            btn2.setText(btn_left);
            btn1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (rightListener != null)
                        rightListener.onClick();
                }
            });
            btn2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (leftListener != null)
                        leftListener.onClick();
                }
            });
            dialog.setContentView(contentView);
            dialog.show();
            return dialog;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    /**
     * 一个按钮的对话框
     */
    public static Dialog showOneButtonDialog(Context context, String title, String message, String btnStr, final OnDialogClickListener lis,
                                             boolean isCenter, boolean isHide) {
        try {
            final Dialog dialog = new Dialog(context, R.style.CustomDialog);
            dialog.setCanceledOnTouchOutside(isHide);
            View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_one_button, null);
            TextView tvTitle = (TextView) contentView.findViewById(R.id.tv_title);
            TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_msg);
            Button btnOk = (Button) contentView.findViewById(R.id.btn_ok);
            tvTitle.setText(title);
            tvMsg.setText(message);
            if (isCenter)
                tvMsg.setGravity(Gravity.CENTER);
            if (!StringUtils.isEmpty(btnStr))
                btnOk.setText(btnStr);
            btnOk.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (lis != null)
                        lis.onClick();
                }
            });
            dialog.setContentView(contentView);
            dialog.show();
            return dialog;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }


//    /**
//     * 从页面底部弹出dialog窗口
//     * flag点击的是加入购物车还是立即购买 1：加入购物车  2：立即购买
//     */
//    public static Dialog showButtonDialog(final BaseActivity activity, final List<ConfrigOrderGoodsBean> goodses, final String branchname, final String branchid) {
//        LayoutInflater inflater = activity.getLayoutInflater();
//        View view = inflater.inflate(R.layout.row_dialog_style_bottom, null);
//        final Dialog dialog = new AlertDialog.Builder(activity,R.style.car_dialog_style).create();
//        dialog.show();
//        dialog.setContentView(view);
//        WindowManager m = activity.getWindowManager();
//        Window dialogWindow = dialog.getWindow();
//
//        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
//        final WindowManager.LayoutParams windowLP = activity.getWindow().getAttributes();
//        windowLP.alpha = 0.5f;
//        activity.getWindow().setAttributes(windowLP);
//        final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = d.getWidth();
//        params.height = (int)(d.getHeight()*0.4);
//        dialogWindow.setGravity(Gravity.BOTTOM);
//        //设置bottom的偏移量
//        //params.y=30;
//        dialog.getWindow().setAttributes(params);
//
//        ImageView imageView = (ImageView) view.findViewById(R.id.img_dialog_goods);
//        UIHelper.imageNet(activity,goodses.get(0).getGoodsPicUrl(),imageView,false);
//        TextView goodsName = (TextView) view.findViewById(R.id.tv_dialog_goods_goodsname);
//        goodsName.setText(goodses.get(0).getGoodsName());
//        TextView unit = (TextView) view.findViewById(R.id.tv_dialog_goods_unit);
//        unit.setText("售卖单位"+goodses.get(0).getUnit());
//        TextView outprice = (TextView) view.findViewById(R.id.tv_dialog_goods_bazaarprice);
//        outprice.setText("市场价"+goodses.get(0).getOutprice());
//        outprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//        TextView inprice = (TextView) view.findViewById(R.id.tv_dialog_goods_wholesaleprice);
//        inprice.setText("批发价："+goodses.get(0).getInprice());
//        final TextView tvGoodsNum = (TextView) view.findViewById(R.id.cart_goods_num);
//        TextView tvAddGoodsNum = (TextView) view.findViewById(R.id.cart_goods_add);
//        tvAddGoodsNum.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int goodsnum = Integer.valueOf(tvGoodsNum.getText().toString().trim());
//                goodsnum++;
//                tvGoodsNum.setText(""+goodsnum);
//            }
//        });
//
//        TextView tvsbbGoodsNum = (TextView) view.findViewById(R.id.cart_goods_subtract);
//        tvsbbGoodsNum.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int goodsnum = Integer.valueOf(tvGoodsNum.getText().toString().trim());
//                if (goodsnum > 0){
//                    goodsnum--;
//                    tvGoodsNum.setText(""+goodsnum);
//                }else{
//                    ToastHelper.getInstance()._toast("数量不能减少了");
//                }
//            }
//        });
//
//        Button confrimbtn = (Button) view.findViewById(R.id.btn_dialog_confrim);
//        confrimbtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int goodsnum = Integer.valueOf(tvGoodsNum.getText().toString().trim());
//                goodses.get(0).setQuantity(goodsnum);
//                double goodsprice = Double.valueOf(goodses.get(0).getInprice());
//                double subtotal = (double) goodsprice*goodsnum;
//                String goods = JSON.toJSONString(goodses);
//                OrderConfirmaAct.lunch(activity,branchname,branchid,goods,subtotal);
//                dialog.dismiss();
//            }
//        });
//        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                windowLP.alpha = 1.0f;
//                activity.getWindow().setAttributes(windowLP);
//            }
//        });
//        return dialog;
//    }


//    /**
//     * 从页面底部弹出dialog窗口
//     */
//    public static Dialog showButtonDialogPay(final BaseActivity activity, final OnDialogClickListener topListener, final OnDialogClickForResultListener OnDialogClickListener) {
////        LayoutInflater inflater = activity.getLayoutInflater();
////        View view = inflater.inflate(R.layout.view_pay, null);
////        final Dialog dialog = new AlertDialog.Builder(activity).create();
////        dialog.show();
////        dialog.setContentView(view);
////        WindowManager m = activity.getWindowManager();
////        Window dialogWindow = dialog.getWindow();
////        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
////        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
////        params.width = d.getWidth();
////        params.height = params.height;
////        dialogWindow.setGravity(Gravity.BOTTOM | Gravity.CENTER_VERTICAL);
//        //设置bottom的偏移量
//        //params.y=30;
//
//        LayoutInflater inflater = activity.getLayoutInflater();
//        View view = inflater.inflate(R.layout.view_pay, null);
//        final Dialog dialog = new AlertDialog.Builder(activity, R.style.car_dialog_style).create();
//        dialog.show();
//        dialog.setContentView(view);
//        final WindowManager.LayoutParams windowLP = activity.getWindow().getAttributes();
//        windowLP.alpha = 0.5f;
//        activity.getWindow().setAttributes(windowLP);
//        WindowManager m = activity.getWindowManager();
//        Window dialogWindow = dialog.getWindow();
//        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = d.getWidth();
//        params.height = (int) (d.getHeight() * 0.5);
//        dialogWindow.setGravity(Gravity.BOTTOM);
//        //设置bottom的偏移量
//        //params.y=30;
//        dialog.getWindow().setAttributes(params);
//
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.getWindow().setAttributes(params);
//
//        final RadioButton rbWeChat= (RadioButton) view.findViewById(R.id.rb_wechat);
//        final RadioButton rbAlipay= (RadioButton) view.findViewById(R.id.rb_alipay);
//        rbWeChat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    rbAlipay.setChecked(false);
//                }
//            }
//        });
//        rbAlipay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    rbWeChat.setChecked(false);
//                }
//            }
//        });
//        view.findViewById(R.id.btnConFirm).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (OnDialogClickListener!=null){
//                    LJPay ljPay=LJPay.WXPAY;
//                    if (rbWeChat.isChecked()){
//                        ljPay=LJPay.WXPAY;
//                    }else if (rbAlipay.isChecked()){
//                        ljPay=LJPay.ALIPAY;
//                    }
//                    if (LJPay.ALIPAY==ljPay){
//                        activity.showToast("目前仅支持支付宝支付");
//                    }else{
//                        OnDialogClickListener.onClick(ljPay.toString());
//                        dialog.dismiss();
//                    }
//                }
//            }
//        });
//        view.findViewById(R.id.img_back).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                windowLP.alpha = 1.0f;
//                activity.getWindow().setAttributes(windowLP);
//            }
//        });
//        return dialog;
//    }



    /**
     * 从中间弹出两个按钮的提示框,简单提示，没有编辑功能
     */
    public static Dialog showButtonDialogInCenter(BaseActivity activity, String noticeMsg, final OnDialogClickListener leftClick, final OnDialogClickListener rightClick) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_notice, null);
        final Dialog dialog = new Dialog(activity,R.style.Translucent_NoTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        dialog.setContentView(view);
        WindowManager m = activity.getWindowManager();
        Window dialogWindow = dialog.getWindow();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = d.getWidth();
        params.height = params.height;
        dialogWindow.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        //设置bottom的偏移量
        //params.y=30;
        dialog.getWindow().setAttributes(params);
        //设置文本信息
        TextView tv_notice= (TextView) view.findViewById(R.id.tv_notice);
        tv_notice.setText(noticeMsg);
        //左右两个控件的点击事件
        view.findViewById(R.id.tv_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftClick != null)
                    leftClick.onClick();
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_right).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightClick != null)
                    rightClick.onClick();
                dialog.dismiss();
            }
        });
        return dialog;
    }


    /**
     * 从中间弹出两个按钮的提示框,简单提示，没有编辑功能
     */
    public static Dialog showButtonDialogInCenter(BaseActivity activity, String noticeMsg,String leftMsg,String rightMsg,final OnDialogClickListener leftClick, final OnDialogClickListener rightClick) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_notice, null);
        //final Dialog dialog = new AlertDialog.Builder(activity).create();
        final Dialog dialog=new Dialog(activity,R.style.Translucent_NoTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        dialog.setContentView(view);
        WindowManager m = activity.getWindowManager();
        Window dialogWindow = dialog.getWindow();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
      //  params.width = d.getWidth();
        params.width=UIHelper.dip2px(activity,270);
        params.height = params.height;
        dialogWindow.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        //设置bottom的偏移量
        //params.y=30;
        dialog.getWindow().setAttributes(params);
        //设置文本信息
        TextView tv_notice= (TextView) view.findViewById(R.id.tv_notice);
        tv_notice.setText(noticeMsg);
        TextView tvLeft=(TextView) view.findViewById(R.id.tv_left);
        tvLeft.setText(leftMsg);
        TextView tvRight=(TextView) view.findViewById(R.id.tv_right);
        tvRight.setText(rightMsg);

        //左右两个控件的点击事件
        view.findViewById(R.id.tv_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftClick != null)
                    leftClick.onClick();
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_right).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightClick != null)
                    rightClick.onClick();
                dialog.dismiss();
            }
        });
        return dialog;
    }

    /**
     * 从中间弹出两个按钮的提示框，商家同意退款，输入退款金额
     * */
    public static Dialog showDiaologRefunMoney(BaseActivity activity, String noticeMsg,final OnDialogClickListener leftClick, final OnDialogClickForResultListener rightClick) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_notice_money, null);
        final Dialog dialog =new Dialog(activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        dialog.show();
        dialog.setContentView(view);
        WindowManager windowManager =activity.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

        lp.width = (int) (display.getWidth()*0.8); // 设置宽度
        //dialogWindow.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        //设置bottom的偏移量
        //params.y=30;
        lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;//显示dialog的时候,就显示软键盘
        dialog.getWindow().setAttributes(lp);
        //设置文本信息
        final TextView tv_notice= (TextView) view.findViewById(R.id.tv_notice);
        tv_notice.setText(noticeMsg);
        //左右两个控件的点击事件
        view.findViewById(R.id.tv_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftClick != null)
                    leftClick.onClick();
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_right).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightClick != null)
                    rightClick.onClick(tv_notice.getText().toString().trim());
                dialog.dismiss();
            }
        });
        return dialog;
    }

    /**
     * 版本更新，显示加载的进度框
     */
    public static void showProgress(Context context,int maxProgress,OnDialogClickListener loadListener)
    {
        ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置水平的进度
        progressDialog.setMax(maxProgress);
        progressDialog.show();
        loadListener.onClick();
    }



    public static void initLoadView(SwipeRefreshLayout mSwipeLayout, final ProgressWheel progressWheel) {
        mSwipeLayout.setColorSchemeResources(R.color.top_bg);
        mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeLayout.setEnabled(false);
        progressWheel.spin();
//        progressWheel.setBarWidth(2);
        progressWheel.setBarWidth(dip2px(mSwipeLayout.getContext(),2));
    }

    public static void initLoadView(SwipeRefreshLayout mSwipeLayout) {
        mSwipeLayout.setColorSchemeResources(R.color.top_bg);
        mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeLayout.setEnabled(false);
    }

    public static void initRefreshView(SwipeRefreshLayout mSwipeLayout) {
        mSwipeLayout.setColorSchemeResources(R.color.top_bg);
        mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }

    /**带默认图*/
    public static void imageNet(Context context, String url, ImageView view, boolean isLocal, int defaltIcon) {
        if (!StringUtils.isEmpty(url) && url.startsWith("http")) {
            imageNet2(context, url, view, isLocal, defaltIcon);
        } else {
            Glide.with(context).load(isLocal ? url : getImgUrl(url)).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().placeholder(defaltIcon).into(view);
        }

    }

    /**不带默认图*/
    public static void imageNet(Context context, String url, ImageView view, boolean isLocal) {
        if (!StringUtils.isEmpty(url) && url.startsWith("http")) {
            imageNet2(context, url, view, isLocal);
        } else {
            Glide.with(context).load(isLocal ? url : getImgUrl(url)).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().into(view);
        }

    }

    public static void imageNet2(Context context, String url, ImageView view, boolean isLocal, int defaltIcon) {
        Glide.with(context).load(isLocal ? url : url).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().placeholder(defaltIcon).into(view);
    }

    /**不带默认图*/
    public static void imageNet2(Context context, String url, ImageView view, boolean isLocal ) {
        Glide.with(context).load(isLocal ? url : url).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().into(view);
    }

    public static String getImgUrl(String url) {
       // return Config.TEST_IMG_BASE_URL + url;
        return BuildConfig.IMAGE_SERVER_URL + url;
    }

    /*
     * 按正方形裁切图片
     */
    public static Bitmap ImageCrop(Bitmap bitmap) {
        int w = bitmap.getWidth(); // 得到图片的宽，高
        int h = bitmap.getHeight();

        if (w == h) {
            return bitmap;
        } else {
            int wh = w > h ? h : w;// 裁切后所取的正方形区域边长

            int retX = w > h ? (w - h) / 2 : 0;// 基于原图，取正方形左上角x坐标
            int retY = w > h ? 0 : (h - w) / 2;

            // 下面这句是关键
            return Bitmap.createBitmap(bitmap, retX, retY, wh, wh, null, false);
        }

    }

    public static String getApplicationName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
    }

    public static void setRatingbarScore(RatingBar ratingBar, float score) {
        float scoreNum = (float) 3.5;
        if (score >= 1 && score < 1.5) {
            scoreNum = 1;
        } else if (score >= 1.5 && score < 2) {
            scoreNum = (float) 1.5;
        } else if (score >= 2 && score < 2.5) {
            scoreNum = (float) 2;
        } else if (score >= 2.5 && score < 3) {
            scoreNum = (float) 2.5;
        } else if (score >= 3 && score < 3.5) {
            scoreNum = (float) 3;
        } else if (score >= 3.5 && score < 4) {
            scoreNum = (float) 3.5;
        } else if (score >= 4 && score < 4.5) {
            scoreNum = (float) 4;
        } else if (score >= 4.5 && score < 5) {
            scoreNum = (float) 4.5;
        } else if (score >= 5) {
            scoreNum = (float) 5;
        }
        ratingBar.setRating(scoreNum);
        ratingBar.setVisibility(View.VISIBLE);
    }

    /**
     * 电话号码验证
     */
    public static boolean checkPhoneAvalible(BaseActivity activity, String phoneNum, String msg) {
        try {
            if (!StringUtils.phoneNumberValid(phoneNum)) {
                activity.showToast(msg);
                return false;
            }
        } catch (Exception e) {
            activity.showToast("请输入正确的电话号码");
            return false;
        }
        return true;
    }

    /**有动画效果的电话号验证*/
    public static boolean checkPhoneAvalibleWithAnim(BaseActivity activity,TextView textView, String msg){
        try {
            if (!StringUtils.phoneNumberValid(textView.getText().toString().toString())) {
                activity.showToast(msg);
                startShakeAnimation(textView);
                return false;
            }
        } catch (Exception e) {
            activity.showToast("请输入正确的电话号码");
            return false;
        }
        return true;
    }

    /**
     * 拨打电话
     */
    public static void callPhone(BaseActivity context, String phoneNum) {
        if (StringUtils.isEmpty(phoneNum)) {
            context.showToast("商家还未开通电话服务");
        } else {
            Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            context.startActivity(intent1);
        }
    }

    /**
     * TextView非空校验
     */
    public static boolean checkTv(BaseActivity activity, TextView ...tv) {
        for (TextView textView:tv){
            String temp = textView.getText().toString().trim();
            if (StringUtils.isEmpty(temp)) {
                return false;
            }
        }

        return true;
    }

    /**
     * TextView非空校验，空则吐司提示
     */
    public static boolean checkTv(BaseActivity activity, TextView tv, String msg) {
        String temp = tv.getText().toString().trim();
        if (StringUtils.isEmpty(temp)) {
            activity.showToast(msg);
            return false;
        }
        return true;
    }


    /**
     * TextView非空校验，空则添加晃动动画效果+吐司提示
     * */
    public static boolean checkTvWithAnim(BaseActivity activity, TextView tv, String msg) {
        String temp = tv.getText().toString().trim();
        if (StringUtils.isEmpty(temp)) {
            startShakeAnimation(tv);
            activity.showToast(msg);
            return false;
        }
        return true;
    }

    /**验证TextView中的文本长度至少N个字符*/
    public static boolean checkTvLimit(BaseActivity activity,TextView tv,int limit,String msg){
        String temp = tv.getText().toString().trim();
        if (temp.length()<limit){
            startShakeAnimation(tv);
            activity.showToast(msg);
            return false;
        }
        return true;
    }

    /**验证TextView中的文本长度至少N个字符*/
    public static boolean checkTvLimit(BaseActivity activity,TextView tv,int limitlef,int limitright,String msg){
        String temp = tv.getText().toString().trim();
        if (temp.length()<limitlef||temp.length()>limitright){
            startShakeAnimation(tv);
            activity.showToast(msg);
            return false;
        }
        return true;
    }


    /**
     * 开始晃动动画
     */
    public static void startShakeAnimation(TextView textView) {
        if (textView.getAnimation() == null) {
            textView.setAnimation(shakeAnimation(4));
        }
        textView.startAnimation(textView.getAnimation());
    }

    /**
     * 晃动动画
     *
     * @param counts 0.5秒钟晃动多少下
     */
    public static Animation shakeAnimation(int counts) {
        TranslateAnimation animation = new TranslateAnimation(0, 10, 0, 0);
        animation.setInterpolator(new CycleInterpolator(counts));
        animation.setDuration(500);
        return animation;
    }


    /**验证手机号码是否正确，不正确则提示，并晃动窗口*/
    public static boolean checkPhoneNumberAvailable(BaseActivity activity,TextView phoneView){
        String phoneNum=phoneView.getText().toString().trim();
        if (StringUtils.isEmpty(phoneNum)){
            activity.showToast("手机号不能为空");
            startShakeAnimation(phoneView);
            return false;
        }else if (!StringUtils.phoneNumberValid(phoneNum)){
            activity.showToast("请输入正确的手机号");
            startShakeAnimation(phoneView);
             return false;
        }
        return true;
    }

    /**
     * 判断密码是否一致
     */
    public static boolean checkPwdSame(BaseActivity activity,TextView tv,TextView tvConfirm,String msg){
        String temp=tv.getText().toString().trim();
        String tempConfirm=tvConfirm.getText().toString().trim();
        if(temp.equals(tempConfirm)){
            return true;
        }
        activity.showToast(msg);
        return false;
    }
    private Drawable drawable_def[] = new Drawable[5];//系统生成默认的logo

   /* *//**
     * 将一个布局转换为一个图片：商家没有设置头像的时候，随机生成一张包含商家名字第一个字的图片
     *//*
    public Bitmap getRandomBitmap(BaseActivity activity, String companyName) {
        //商家没有提供图片时，随机显示颜色
        drawable_def[0] = activity.getResources().getDrawable(R.color.logo1);
        drawable_def[1] = activity.getResources().getDrawable(R.color.logo2);
        drawable_def[2] = activity.getResources().getDrawable(R.color.logo3);
        drawable_def[3] = activity.getResources().getDrawable(R.color.logo4);
        drawable_def[4] = activity.getResources().getDrawable(R.color.logo5);
        View view = activity.getLayoutInflater().inflate(R.layout.view_change_to_image, null);
        TextView tv_companyName = (TextView) view.findViewById(R.id.tv_companyName);
        tv_companyName.setText(companyName.substring(0, 1));
        int number = new Random().nextInt(5);
        tv_companyName.setBackground(drawable_def[number]);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }*/



}
