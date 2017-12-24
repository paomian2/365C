package com.a365vintagewine.widget.addcar;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * 描述：加入购物车动画效果
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年12月17日  18:27
 * 版本：V1.0
 */
public class PathAnimation extends Animation {

    private PathMeasure measure;
    private float[] pos = new float[2];

    public PathAnimation(Path path) {
        measure = new PathMeasure(path, false);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        measure.getPosTan(measure.getLength() * interpolatedTime, pos, null);
        t.getMatrix().setTranslate(pos[0], pos[1]);

    }
}
