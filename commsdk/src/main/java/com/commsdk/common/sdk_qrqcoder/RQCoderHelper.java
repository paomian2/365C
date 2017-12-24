package com.commsdk.common.sdk_qrqcoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.widget.ImageView;

import com.commsdk.R;
import com.commsdk.common.sdk_qrqcoder.zxing.encode.EncodingHandler;
import com.google.zxing.WriterException;

import java.io.UnsupportedEncodingException;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月20日  16:59
 * 版本：3.0
 */

public class RQCoderHelper {

    /**
     * @param imageView:二维码Imageview
     *
     * @param key:二维码数据
     * */
    public static void setRQCoderToImageView(Context context,ImageView imageView,String key){
        Bitmap bitmap = create2Code(imageView,key);
        Bitmap headBitmap = getHeadBitmap(context,60);
        if (bitmap != null && headBitmap != null) {
            createQRCodeBitmapWithPortrait(bitmap, headBitmap);
        }
    }

    /**
     * 生成二维码
     * @param key:二维码数据
     */
    private static Bitmap create2Code(ImageView iv2Code,String key) {
        Bitmap qrCode=null;
        try {
            qrCode= EncodingHandler.create2Code(key, 400);
            iv2Code.setImageBitmap(qrCode);
        } catch (WriterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return qrCode;
    }

    /**
     * 初始化头像图片
     */
    private static Bitmap getHeadBitmap(Context context,int size) {
        try {
            // 这里采用从asset中加载图片abc.jpg
            Bitmap portrait = BitmapFactory.decodeResource(context.getResources(), R.drawable.head);
            // 对原有图片压缩显示大小
            Matrix mMatrix = new Matrix();
            float width = portrait.getWidth();
            float height = portrait.getHeight();
            mMatrix.setScale(size / width, size / height);
            return Bitmap.createBitmap(portrait, 0, 0, (int) width,
                    (int) height, mMatrix, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在二维码上绘制头像
     */
    private static void createQRCodeBitmapWithPortrait(Bitmap qr, Bitmap portrait) {
        // 头像图片的大小
        int portrait_W = portrait.getWidth();
        int portrait_H = portrait.getHeight();

        // 设置头像要显示的位置，即居中显示
        int left = (qr.getWidth() - portrait_W) / 2;
        int top = (qr.getHeight() - portrait_H) / 2;
        int right = left + portrait_W;
        int bottom = top + portrait_H;
        Rect rect1 = new Rect(left, top, right, bottom);

        // 取得qr二维码图片上的画笔，即要在二维码图片上绘制我们的头像
        Canvas canvas = new Canvas(qr);

        // 设置我们要绘制的范围大小，也就是头像的大小范围
        Rect rect2 = new Rect(0, 0, portrait_W, portrait_H);
        // 开始绘制
        canvas.drawBitmap(portrait, rect2, rect1, null);
    }
}
