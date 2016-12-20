package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */

public class FadeInFadeOutActivity2 extends Activity {
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        tv_show.setText("淡入淡出效果");
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
    }
}