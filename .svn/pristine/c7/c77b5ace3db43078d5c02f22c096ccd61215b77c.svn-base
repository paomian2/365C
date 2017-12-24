package com.a365vintagewine.widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;

import com.a365vintagewine.R;

/**
 * 描述：带图标的TextView
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月03日  16:28
 * 版本：3.0
 */

public class ImgTextView extends android.support.v7.widget.AppCompatTextView{

    private  Context context;
    /**TextView设置的字符串值*/
    private String mTextContent;
    /**TextView设置的图标*/
    private int mTextDrawble;
    /**图标设置在字符串前面*/
    public static boolean POISITION_START;

    public ImgTextView(Context context) {
        super(context);
        this.context=context;
    }

    public ImgTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImgTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ImgTextView,defStyleAttr,0);
        this.mTextContent=typedArray.getString(R.styleable.ImgTextView_mTextContent);
        this.mTextDrawble=typedArray.getResourceId(R.styleable.ImgTextView_mTextDrawble,0);
        this.POISITION_START=typedArray.getBoolean(R.styleable.ImgTextView_positionStart,false);
        typedArray.recycle();
        if(mTextContent!=null && !mTextContent.equals("") && mTextDrawble>0){
            setTextViewDrawble(mTextContent,POISITION_START,mTextDrawble);
        }
    }

    public void setTextViewDrawble(String textContent,boolean positionStart,final int drawble) {

        //也可以这样
        //Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        //drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //ImageSpan imageSpan1 = new ImageSpan(drawable);
        //将index为6、7的字符用图片替代
        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        VerticalImageSpan imageSpan = new VerticalImageSpan(context, drawble);
        String temp="";
        if (positionStart){
            temp="  替代"+textContent;
            spannableString.append(temp);
            spannableString.setSpan(imageSpan, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else{
            temp=textContent+"  替代";
            spannableString.append(temp);
            spannableString.setSpan(imageSpan, temp.length()-2, temp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        this.setText(spannableString);
    }

    private class VerticalImageSpan extends ImageSpan {

        public VerticalImageSpan(Context arg0, int arg1) {
            super(arg0, arg1);
        }
        public int getSize(Paint paint, CharSequence text, int start, int end,
                           Paint.FontMetricsInt fm) {
            Drawable d = getDrawable();
            Rect rect = d.getBounds();
            if (fm != null) {
                Paint.FontMetricsInt fmPaint=paint.getFontMetricsInt();
                int fontHeight = fmPaint.bottom - fmPaint.top;
                int drHeight=rect.bottom-rect.top;

                int top= drHeight/2 - fontHeight/4;
                int bottom=drHeight/2 + fontHeight/4;

                fm.ascent=-bottom;
                fm.top=-bottom;
                fm.bottom=top;
                fm.descent=top;
            }
            return rect.right;
        }

        @Override
        public void draw(Canvas canvas, CharSequence text, int start, int end,
                         float x, int top, int y, int bottom, Paint paint) {
            Drawable b = getDrawable();
            canvas.save();
            int transY = 0;
            transY = ((bottom-top) - b.getBounds().bottom)/2+top;
            canvas.translate(x, transY);
            b.draw(canvas);
            canvas.restore();
        }
    }

}
