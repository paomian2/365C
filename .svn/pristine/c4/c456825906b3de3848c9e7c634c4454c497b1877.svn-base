package com.commsdk.common;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.commsdk.base.BaseActivity;

public class PopupHelper {

	public enum PopGravity {//horizontal
		BOTTOM_RIGHT, BOTTOM, LEFT, CENTER, TOP, TOP_CENTER,HORIZONTAL_CENTER;
	}

	public enum PopStyle {
		MATCH_PARENT, WRAP_CONTENT, MATCH_WIDTH
	}

   private static PopupHelper instance;

	private PopupHelper(){}
	public static PopupHelper getInstance(){
		instance=new PopupHelper();
		return instance;
	}

	public  PopupWindow newBasicPopupWindow(Context context, PopStyle popStyle) {
		final PopupWindow window = new PopupWindow(context);

		// when a touch even happens outside of the window
		// make the window go away
		/*window.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					window.dismiss();
					return true;
				}
				return false;
			}
		});*/

		if (popStyle == PopStyle.MATCH_PARENT) {
			window.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
			window.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
		} else if (popStyle == PopStyle.MATCH_WIDTH) {
			window.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
			window.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		} else {
			window.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
			window.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		}
		window.setTouchable(false);
		window.setFocusable(true);
		window.setOutsideTouchable(false);
		window.setBackgroundDrawable(new BitmapDrawable());
		return window;
	}

	/**显示在整个布局的顶部、中间、底部*/
	public  void showLocationPop(PopupWindow window, View anchor, PopGravity gravity) {
		int paddingTop = UIHelper.dip2px(anchor.getContext(),65);
		if (gravity == PopGravity.TOP_CENTER) {
			window.showAtLocation(anchor, Gravity.TOP | Gravity.CENTER, 0, paddingTop);
		} else if (gravity == PopGravity.CENTER) {
			window.showAtLocation(anchor, Gravity.CENTER, 0, 0);
		} else if (gravity == PopGravity.TOP) {
			window.showAtLocation(anchor, Gravity.TOP, 0, 0);
		} else if (gravity == PopGravity.BOTTOM_RIGHT) {
			window.showAtLocation(anchor, Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
		} else if (gravity == PopGravity.BOTTOM) {
			window.showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
		}else if (gravity== PopGravity.HORIZONTAL_CENTER){
			window.showAtLocation(anchor,Gravity.CENTER_HORIZONTAL,0,0);
		}
	}

	/**显示在指定控件的周围*/
	public static void showAsDropDown(PopupWindow popupWindow,View anchor){
        popupWindow.showAsDropDown(anchor);
	}



	public static void setBackGroundlpha(BaseActivity activity, PopupWindow window){
		backgroundAlpha(activity,0.4f);
		window.setOnDismissListener(new PoponDismissListener(activity));
	}

	/**
	 * 设置添加屏幕的背景透明度
	 * @param bgAlpha
	 */
	private static void backgroundAlpha(BaseActivity activity, float bgAlpha)
	{
		WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
		lp.alpha = bgAlpha; //0.0-1.0
		activity.getWindow().setAttributes(lp);
	}

	/**
	 * 弹出的popWin关闭的事件，主要是为了将背景透明度改回来
	 *
	 */
	static class PoponDismissListener implements PopupWindow.OnDismissListener{
		BaseActivity activity;
		public PoponDismissListener(BaseActivity activity){
           this.activity=activity;
		}

		@Override
		public void onDismiss() {
			// TODO Auto-generated method stub
			backgroundAlpha(activity,1f);
		}

	}

}
