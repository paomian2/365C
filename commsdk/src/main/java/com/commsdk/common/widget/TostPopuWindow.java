package com.commsdk.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.commsdk.R;
import com.commsdk.common.PopupHelper;

/**
 * @Destription:在布局中间显示的提示，类似于吐司
 * @auther:lstreamlet
 * @date:2016/12/17
 */
public class TostPopuWindow{

    private static TostPopuWindow instance=null;
    private static PopupWindow tostPopuWindow=null;

    private Context context;

    private TostPopuWindow(Context context){
        this.context=context;
        tostPopuWindow= PopupHelper.getInstance().newBasicPopupWindow(context, PopupHelper.PopStyle.WRAP_CONTENT);
    }

    synchronized public static TostPopuWindow getInstance(Context context){
        if (instance!=null){
            instance.dismiss();
        }
        instance=new TostPopuWindow(context);
        return instance;
    }

    public void showTostPopupWind(View anchor, PopupHelper.PopGravity gravity, String message){
        LayoutInflater inflater=LayoutInflater.from(context);
        View contentView=inflater.inflate(R.layout.dialog_tost,null);
        TextView tv_load= (TextView) contentView.findViewById(R.id.tv_load);
        tv_load.setText(""+message);
        tostPopuWindow.setContentView(contentView);
        PopupHelper.getInstance().showLocationPop(tostPopuWindow,anchor,gravity);
    }
    public void dismiss(){
        if (tostPopuWindow!=null)
            tostPopuWindow.dismiss();
    }


}
