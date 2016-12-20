package com.gyf.mvp.adapterBase;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/4.
 */
public class BaseViewPagerAdapter<T> extends PagerAdapter {
    public ArrayList<T> list;

    public BaseViewPagerAdapter(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
