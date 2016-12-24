package com.hrw.memoryleak.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hrw.memoryleak.fragment.MyFragment0;

/**
 * Created by 高烨峰 on 2016/12/23.
 */
public class TableLayoutViewPagerAdapter extends FragmentPagerAdapter {
    private String[] tabContent;
    public TableLayoutViewPagerAdapter(FragmentManager fm, String[] tabContent) {
        super(fm);
        this.tabContent = tabContent;
    }

    @Override
    public Fragment getItem(int position) {
        return new MyFragment0();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabContent[position];
    }
}
