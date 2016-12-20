package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.adapter.MyViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class NormalViewPagerActivity extends Activity {
    private ViewPager vp_normal_viewpager;
    private ArrayList<View> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_viewpager);
        initView();
        vp_normal_viewpager.setAdapter(new MyViewPagerAdapter());
    }

    private void initView() {
        vp_normal_viewpager = (ViewPager) findViewById(R.id.vp_normal_viewpager);
    }
}
