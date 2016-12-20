package com.hrw.network.volleytwiceencap.http.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/**
 * Created by Administrator on 2016/11/18.
 */
public class DrawableUtils {
    /**
     * 生成圆角图片,对应的xml中的shape标签
     * @param rgb
     * @param radius
     * @return
     */
    public static Drawable generateDrawable(int rgb,float radius){
        GradientDrawable drawable = new GradientDrawable();
        //设置为矩形,默认就是矩形
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(rgb);
        drawable.setCornerRadius(radius);
        return drawable;
    }
    public static Drawable generateSelector(Drawable pressed,Drawable normal){
        StateListDrawable drawable = new StateListDrawable();
        //设置按下的图片
        drawable.addState(new int[]{android.R.attr.state_pressed},pressed);
        //设置默认的图片
        drawable.addState(new int[]{},normal);

        //设置状态选择器过渡动画
        if (Build.VERSION.SDK_INT > 10) {
            drawable.setEnterFadeDuration(500);
            drawable.setExitFadeDuration(500);
        }
        return drawable;
    }
}
