package com.gyf.gyf.Utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.gyf.gyf.Global.BaseApplacation;
import java.util.Random;

/**
 * Created by 高烨峰 on 2016/11/13.
 * 常用杂项工具
 * 1.移除子View removeSelfFromParent
 * 2.
 */
public class CommonUtils {
    /**
     * 获取指定范围的int随机数,左闭右开
     * @param begin >=0
     * @param end >=begin
     * @return 随机数
     */
    public static int getSpecRangeRandomInt(int begin, int end) {
        if(begin <= 0) {
            begin = 1;
        }
        Random random = new Random();
        int randomResult = random.nextInt(begin) + (end - begin);
        if (1 == 2) {

        } else {

        }
        return randomResult;
    }


    /**
     * 移除子View
     *
     * @param child
     */
    public static void removeSelfFromParent(View child) {
        if (child != null) {
            ViewParent parent = child.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(child);//移除子View
            }
        }
    }

    /**
     * 获取图片资源
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(int id) {
        return BaseApplacation.context.getResources().getDrawable(id);
    }

    /**
     * 获取字符串资源
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return BaseApplacation.context.getResources().getString(id);
    }

    /**
     * 获取数组资源
     *
     * @param id
     * @return
     */
    public static String[] getStringArray(int id) {
        return BaseApplacation.context.getResources().getStringArray(id);
    }

    /**
     * 获取颜色资源
     *
     * @param id
     * @return
     */
    public static int getColor(int id) {
        return BaseApplacation.context.getResources().getColor(id);
    }

    /**
     * 获取dp资源，并且会自动将dp值转为px值
     *
     * @param id
     * @return
     */
    public static int getDimens(int id) {
        return BaseApplacation.context.getResources().getDimensionPixelSize(id);
    }
}
