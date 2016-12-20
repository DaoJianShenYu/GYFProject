package com.gyf.mvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.gyf.mvp.R;

/**
 * Created by 高烨峰 on 2016/12/3.
 */
public class GuideActivity extends Activity {
    private ViewPager guide_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
       // guide_vp.setAdapter(new GuideViewPagerAdapterPresenter());
    }

    private void initView() {
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
    }
}
