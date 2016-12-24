package com.hrw.memoryleak.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/23.
 */
public class TablayoutViewPagerActivity extends FragmentActivity {
    private ViewPager vp_tablayout_viewpager;
    private TabLayout tl_tablayout_tablayout;
    private String[] tabContent = new String[]{"商家","评论","详情","活动"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_viewpager_activity);
        initView();
        vp_tablayout_viewpager.setAdapter(new TableLayoutViewPagerAdapter(getSupportFragmentManager(),tabContent));
        tl_tablayout_tablayout.setupWithViewPager(vp_tablayout_viewpager);
    }

    private void initView() {
        vp_tablayout_viewpager = (ViewPager) findViewById(R.id.vp_tablayout_viewpager);
        tl_tablayout_tablayout = (TabLayout) findViewById(R.id.tl_tablayout_tablayout);
    }
}
