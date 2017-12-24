package com.commsdk.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import com.commsdk.R;
import com.commsdk.common.LogUtil;

/**
 * @Destription:自定义一个类似于吐司的Dialog
 * @auther:lstreamlet
 * @date:2016/12/17
 */
public class TostCenterDialog extends Dialog{
    public TostCenterDialog(Context context, int theme) {
        super(context, theme);
    }

    private static TostCenterDialog tostCenterDialog = null;

    public static TostCenterDialog createDialog(Context context) {
        tostCenterDialog = new TostCenterDialog(context, R.style.CustomDialog);
        tostCenterDialog.setContentView(R.layout.dialog_tost);
        tostCenterDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return tostCenterDialog;
    }

    public TostCenterDialog setTitile(String strTitle) {
        return tostCenterDialog;
    }

    public TostCenterDialog setMessage(String strMessage) {
        TextView tvMsg = (TextView) tostCenterDialog.findViewById(R.id.tv_load);
        if (tvMsg != null && strMessage != null) {
            tvMsg.setText(strMessage);
        }
        return tostCenterDialog;
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable t) {
            LogUtil.log(t);
        }
    }

}
