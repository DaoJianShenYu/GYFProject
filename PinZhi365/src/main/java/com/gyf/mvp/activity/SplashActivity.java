package com.gyf.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gyf.mvp.R;
import com.gyf.mvp.global.MyApplication;
import com.gyf.mvp.utils.SPUtils;

/**
 * Created by 高烨峰 on 2016/12/3.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //判断有没有展示过引导页
        boolean isGuideShow = SPUtils.getBoolean(
                getApplicationContext(), "is_guide_show", false);
        if (!isGuideShow) {
            //跳到新手引导页
            startActivity(new Intent(getApplicationContext(),
                    GuideActivity.class));
        } else {
            MyApplication.mainHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
            }, 1500);
        }
        finish();
    }
}
