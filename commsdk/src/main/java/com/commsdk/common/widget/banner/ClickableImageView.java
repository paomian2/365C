package com.commsdk.common.widget.banner;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ClickableImageView extends ImageView {
    public ClickableImageView(Context context) {
        super(context);
        this.setOnTouchListener(VIEW_TOUCH_DARK);
    }

    public ClickableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(VIEW_TOUCH_DARK);
    }

    public ClickableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnTouchListener(VIEW_TOUCH_DARK);
    }
    public OnTouchListener VIEW_TOUCH_DARK = new OnTouchListener() {
        public final float[] BT_SELECTED_DARK = new float[] { 1, 0, 0, 0, -50,
                0, 1, 0, 0, -50, 0, 0, 1, 0, -50, 0, 0, 0, 1, 0 };
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ImageView iv = (ImageView) v;
                iv.setColorFilter(new ColorMatrixColorFilter(BT_SELECTED_DARK));
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                ImageView iv = (ImageView) v;
                iv.clearColorFilter();
                mPerformClick();
            } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                ImageView iv = (ImageView) v;
                iv.clearColorFilter();
            }
            return true; 
        }
    };
    private void mPerformClick() {
        ClickableImageView.this.performClick();
    }

}
